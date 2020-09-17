package com.ssaw.DayEndProcessing.controller;

import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.BusinessData.entity.TransactionData;
import com.ssaw.DayEndProcessing.entity.AssetValuationData;
import com.ssaw.DayEndProcessing.entity.StockSecuritiesJoinMarket;
import com.ssaw.DayEndProcessing.mapper.AssetValuationMapper;
import com.ssaw.DayEndProcessing.service.AssetValuationService;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import com.ssaw.GlobalManagement.util.SysUtil;
import com.ssaw.InventoryManagement.entity.CashClosedPayInventory;
import com.ssaw.InventoryManagement.entity.SecuritiesClosedPayInventory;
import com.ssaw.InventoryManagement.service.SecuritiesClosedPayInventoryService;
import com.ssaw.TAManagement.entity.TaTransaction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 *@program: FA
 *@description: 资产估值控制类
 *@author: 瞿平
 *@create: 2020-09-13 17:28
 **/
@RestController
@RequestMapping("assetValuationController")
public class AssetValuationController {
    @Resource
    AssetValuationMapper assetValuationMapper;

    @Resource
    AssetValuationService assetValuationService;

    @Resource
    SecuritiesClosedPayInventoryService securitiesClosedPayInventoryService;

    @Resource
    DbUtil dbUtil;

    @RequestMapping("selectAssetValuationData")
    public HashMap selectAssetValuationData() {
        List<AssetValuationData> assetValuationDataList = assetValuationService.selectBiaoge();
        HashMap assetValuationDataMap = new HashMap();
        assetValuationDataMap.put("code",0);
        assetValuationDataMap.put("msg","");
        assetValuationDataMap.put("count",null);
        assetValuationDataMap.put("data",assetValuationDataList);
        System.out.println(assetValuationDataMap);
        return assetValuationDataMap;
    }

    @RequestMapping("startValuation")
    public int startValuation(String toDay,String arrJson ){
        System.out.println("进来了");
        System.out.println(arrJson+" "+toDay);
        List<AssetValuationData> assetValuationDataList = SysUtil.jsonToArrayList(arrJson, AssetValuationData.class);
        for (AssetValuationData assetValuationData : assetValuationDataList) {

            if(assetValuationData.getState().equals("证券估值增值")){
                System.out.println("证券估值增值开始估值");
                HashMap stockarketMap = assetValuationService.selectStockarket();
                List<StockSecuritiesJoinMarket> stockSecuritiesJoinMarketList = (List<StockSecuritiesJoinMarket>) stockarketMap.get("p_cursor");
                for (StockSecuritiesJoinMarket stockSecuritiesJoinMarket : stockSecuritiesJoinMarketList) {
                    System.out.println( stockSecuritiesJoinMarket.getSecuritiesId()+"========================================");

                    SecuritiesClosedPayInventory securitiesClosedPayInventory = new SecuritiesClosedPayInventory();
                    //开始执行增加
                    securitiesClosedPayInventory.setFundId(stockSecuritiesJoinMarket.getFundId());
                    securitiesClosedPayInventory.setSecuritiesId(stockSecuritiesJoinMarket.getSecuritiesId());
                    securitiesClosedPayInventory.setSecurityPeriodFlag(stockSecuritiesJoinMarket.getSecurityPeriodFlag());
                    securitiesClosedPayInventory.setSecuritiesClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI));
                    securitiesClosedPayInventory.setDateTime(toDay);
                    securitiesClosedPayInventory.setSecuritiesType(1);
                    securitiesClosedPayInventory.setFlag(1);
                    securitiesClosedPayInventory.setTotalPrice(stockSecuritiesJoinMarket.getTootaIPrice());
                    securitiesClosedPayInventory.setSecuritiesClosedPayDesc("投资有风险");
                    System.out.println("=============================增加的实体类"+securitiesClosedPayInventory);
//                        执行删除
                    int i = assetValuationService.deleteSecuritiesClosedPayInventory(securitiesClosedPayInventory);
                    System.out.println("============================================="+i);
                    //调用增加方法
                    securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventory);

                }
            }else {
                System.out.println("清算款清算中");
                //查交易数据 按证券代码分组 插入证券应收应付库存
                HashMap hashMap = assetValuationService.selectTransactionData();
                List<TransactionData> transactionDataList = (List<TransactionData>)hashMap.get("p_cursor");
                for (TransactionData transactionData : transactionDataList) {
                    System.out.println("TransactionData================="+transactionData);
                    SecuritiesClosedPayInventory securitiesClosedPayInventory = new SecuritiesClosedPayInventory();
                    securitiesClosedPayInventory.setSecuritiesClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI));
                    securitiesClosedPayInventory.setDateTime(toDay);
                    securitiesClosedPayInventory.setFundId(transactionData.getFundId());
                    securitiesClosedPayInventory.setSecuritiesType(2);
                    securitiesClosedPayInventory.setSecuritiesId(transactionData.getSecuritiesId());
                    securitiesClosedPayInventory.setTotalPrice(transactionData.getTotalSum());
                    securitiesClosedPayInventory.setFlag(transactionData.getFlag());
                    securitiesClosedPayInventory.setSecurityPeriodFlag(2);
                    assetValuationService.deleteSecuritiesClosedPayInventoryTwo(securitiesClosedPayInventory);
                    securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventory);
                    System.out.println("查ta交易数据================================");
                    HashMap taTransactionMap = assetValuationService.selectTaTransaction();
                    List<TaTransaction> taTransactionList = (List<TaTransaction>)taTransactionMap.get("p_cursor");
                    for (TaTransaction taTransaction : taTransactionList) {
                        System.out.println(taTransaction+"ta==========================================");
                        CashClosedPayInventory cashClosedPayInventory = new CashClosedPayInventory();
                        cashClosedPayInventory.setCashClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCPI));
                        cashClosedPayInventory.setBusinessDate(taTransaction.getDateTime());
                        cashClosedPayInventory.setFundId(taTransaction.getFundId());
                        cashClosedPayInventory.setAccountId(taTransaction.getAccountId());
                        cashClosedPayInventory.setBusinessType(4);
                        cashClosedPayInventory.setBusinessStatus(1);
                        cashClosedPayInventory.setInitialSigns(1);
                        cashClosedPayInventory.setTotalMoney((double) taTransaction.getTotalMoney());

                    }

                }

            }
        }
        return 0;
    }
}
