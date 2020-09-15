package com.ssaw.DayEndProcessing.service.impl;

import com.ssaw.BusinessData.entity.Market;
import com.ssaw.BusinessData.entity.SecuritiesClosedPay;
import com.ssaw.BusinessData.service.CashClosedPayService;
import com.ssaw.BusinessData.service.SecuritiesClosedPayService;
import com.ssaw.DayEndProcessing.entity.AssetValuation;
import com.ssaw.DayEndProcessing.entity.AssetValuationData;
import com.ssaw.DayEndProcessing.mapper.AssetValuationMapper;
import com.ssaw.DayEndProcessing.service.AssetValuationService;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import com.ssaw.InventoryManagement.entity.CashClosedPayInventory;
import com.ssaw.InventoryManagement.entity.SecuritiesClosedPayInventory;
import com.ssaw.InventoryManagement.service.CashClosedPayInventoryService;
import com.ssaw.InventoryManagement.service.SecuritiesClosedPayInventoryService;
import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@program: FA
 *@description: 资产估值实现类
 *@author: 瞿平
 *@create: 2020-09-11 16:54
 **/
@Service
public class AssetValuationServiceImpl implements AssetValuationService {
    @Resource
    AssetValuationMapper assetValuationMapper;

    @Resource
    SecuritiesClosedPayInventoryService securitiesClosedPayInventoryService;

    @Resource
    CashClosedPayInventoryService cashClosedPayInventoryService;

    @Resource
    DbUtil dbUtil;

    @Override
    public List<AssetValuation> selectAssetValuation(AssetValuation assetValuation, HttpSession session) {
        //获取基金编号
        assetValuation.setFundId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.F));
        System.out.println("前端传过来的日期："+assetValuation.getToDay());
        //查询估值增值的收据
        List<AssetValuation> assetValuationList = assetValuationMapper.selectAssetValuation(assetValuation);
        //得到增值估值的数据
        for (AssetValuation assetValuation1:assetValuationList){
            //应付-1 应收1 默认是1
            Integer flag = 1;
            //估值增值小于0
            if (assetValuation1.getAssetValuationVal()<0){
                //把估值转成整数
                assetValuation1.setAssetValuationVal(Math.abs(assetValuation1.getAssetValuationVal()));
                //状态为应付
                flag = -1;
            }
            System.out.println("估值增值的值："+assetValuation1.getAssetValuationVal());
            System.out.println("当前状态："+flag);
           SecuritiesClosedPayInventory securitiesClosedPayInventory = new SecuritiesClosedPayInventory(
                   null,assetValuation.getFundId(),assetValuation1.getSecuritiesId(),assetValuation.getToDay(),
                   1,flag,new Double(assetValuation1.getAssetValuationVal()+""),null,1);
            Integer securitiesType=assetValuationMapper.selectSecuritiesType1(assetValuation.getToDay(),1);
            System.out.println("查询应收应付库存大小："+securitiesType);
            if (securitiesType==null){
                System.out.println("没有数据：直接添加");
                securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventory);
            }else if (securitiesType==1){
                System.out.println("查询到值：先删后增");
                securitiesClosedPayInventoryService.deleteSecuritiesClosedPayInventoryDate(assetValuation1.getSecuritiesId(),
                        assetValuation.getToDay(),securitiesType);
                securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventory);
            }
        }
        return assetValuationList;
    }


    @Override
    public List<AssetValuation> selectTaTransaction(AssetValuation assetValuation, HttpSession session) {
        assetValuation.setFundId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.F));
        //TA交易数据清算款
        List<AssetValuation> assetValuations = assetValuationMapper.selectTaTransaction(assetValuation);
        for (AssetValuation taTransaction:assetValuations){
            //流入1  流出-1
            int businessStatus = 1;
            // TA交易数据 申购 1 赎回-1 -----判断是否是赎回
            if (taTransaction.getTransactionType()==-1){
                businessStatus=-1;
            }
            try {
                CashClosedPayInventory cashClosedPayInventory = new CashClosedPayInventory(null, dbUtil.requestDbTableMaxId(SysTableNameListUtil.A), 4,
                        new Double(taTransaction.getActualMoney()), assetValuation.getToDay(), 1, businessStatus,null);
                this.deleteTAReceivables(assetValuation.getToDay(),businessStatus,dbUtil.requestDbTableMaxId(SysTableNameListUtil.F),dbUtil.requestDbTableMaxId(SysTableNameListUtil.A));
                cashClosedPayInventoryService.insertCashClosedPayInventory(cashClosedPayInventory);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 清算款-交易数据！
        // 查询交易数据的数据
        List<AssetValuation> transactionData = assetValuationMapper.selectTransactionData(assetValuation);
        //得到交易数据
        for (AssetValuation transaction:transactionData){
            //判断总金额是否小于零
            int businessStatus=1;
            if (transaction.getTotalSum()<0){
                //把负数转成整数
                transaction.setTotalSum(Math.abs(transaction.getTotalSum()));
                businessStatus=-1;
            }
            SecuritiesClosedPayInventory securitiesClosedPayInventory = new SecuritiesClosedPayInventory(
                    null,dbUtil.requestDbTableMaxId(SysTableNameListUtil.A),transaction.getSecuritiesId(),assetValuation.getToDay(),
                    2,businessStatus,new Double(transaction.getTotalSum()+""),null,1);
            Integer securitiesType = assetValuationMapper.selectSecuritiesType1(assetValuation.getToDay(), 2);
            System.out.println("清算款="+securitiesType);
            if (securitiesType == null){
                System.out.println("清算款-没有数据：直接添加");
                securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventory);
            }else if (securitiesType==2){
                System.out.println("清算款-查询到值：先删后增");
                securitiesClosedPayInventoryService.deleteSecuritiesClosedPayInventoryDate(transaction.getSecuritiesId(),assetValuation.getToDay(),securitiesType);
            }
        }
        return null;
    }



    @Override
    public List<Integer> selectSecuritiesType(String today) {

        return assetValuationMapper.selectAllSecuritiesType(today);
    }

    @Override
    public int deleteTAReceivables(String toDay, int flag,String fundId,String accountId) {
        Map<String,Object> map = new HashMap<>();
        map.put("toDay",toDay);
        map.put("flag",flag);
        map.put("fundId",fundId);
        map.put("accountId",accountId);
        System.out.println("map="+map);
        int i = assetValuationMapper.deleteTAReceivables(map);
        return i;
    }


    @Override
    public List<AssetValuationData> selectAssecuritisStates(String toDay, Integer securitiesType) {
        System.out.println("dada==========================");
        List<AssetValuationData> dataList = new ArrayList<AssetValuationData>();
        AssetValuationData assetValuationData = new AssetValuationData(1,"证券估值增值","未估值",false);
        AssetValuationData assetValuationData1 = new AssetValuationData(2,"清算款","未清算",false);


        List<Integer> stateList = assetValuationMapper.selectSecuritiesType(toDay,securitiesType);
        System.out.println("strAppraisement="+securitiesType);
        if (securitiesType!=null && !securitiesType.equals("")){
            System.out.println("不为null");
            if (securitiesType==1){
                assetValuationData.setChecked(true);
            }
            if (securitiesType==2){
                assetValuationData1.setChecked(true);
            }
            System.out.println("stateList="+stateList.size());
            for (Integer state:stateList){
                if (securitiesType==1){
                    if (state==1){
                        System.out.println("进来，以估值");
                        assetValuationData.setState("已估值");
                    }
                }
                if (securitiesType==2){
                    if(state==2 || state==4){
                        assetValuationData1.setState("已清算");
                    }
                }
            }
        }
        System.out.println(stateList.size());
        for (Integer state:stateList){
            if (state==1){
                System.out.println("已估值");
                assetValuationData.setState("已估值");
            }
            if (state==2 || state==4){
                System.out.println("已清算");
                assetValuationData1.setState("已清算");
            }
        }



        dataList.add(assetValuationData);
        dataList.add(assetValuationData1);

        return dataList;
    }
}
