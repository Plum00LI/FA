package com.ssaw.DayEndProcessing.controller;

import com.ssaw.BusinessData.entity.CashClosedPay;
import com.ssaw.BusinessData.entity.Market;
import com.ssaw.DayEndProcessing.entity.AssetValuation;
import com.ssaw.DayEndProcessing.entity.AssetValuationData;
import com.ssaw.DayEndProcessing.mapper.AssetValuationMapper;
import com.ssaw.DayEndProcessing.service.AssetValuationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 调用业务逻辑方法进行资产估值
     * @param assetValuation 资产估值实体对象
     * @param session session对象
     * @return
     */
    @RequestMapping("selectAllAssetValuation")
    public Map<String,Object> selectAllAssetValuation(AssetValuation assetValuation, HttpSession session){
        String[] split = assetValuation.getStrAppraisement().split(",");
        List<AssetValuation> assetValuationList = null;
        for (int i=0;i<split.length;i++){
            if (Integer.parseInt(split[i])==1){
                System.out.println("-----估值增值-----");
                assetValuationList = assetValuationService.selectAssetValuation(assetValuation,session);
            }
            if (Integer.parseInt(split[i])==2){
                System.out.println("-----清算款-----");
                assetValuationService.selectTaTransaction(assetValuation,session);
            }
        }
        List<CashClosedPay> cashClosedPays = assetValuationMapper.selectCashClosedPay(assetValuation.getToDay());
        List<Integer> taTransactionList = assetValuationMapper.selectAllSecuritiesType(assetValuation.getToDay());
        Map<String,Object> map = new HashMap<>();
        map.put("cashClosedPays",cashClosedPays);
        map.put("taTransactionList",taTransactionList);
        map.put("assetValuationList",assetValuationList);
        System.out.println("实体对象="+assetValuation);
        return map;
    }

    /**
     * 动态加载证券估值增值状态和清算款状态
     * @param toDay 估值日期
     * @return
     */
    @RequestMapping("selectAllSecuritiesType")
    public List<Integer> selectAllSecuritiesType(String toDay){
        System.out.println("估值日期="+toDay);
        List<Integer> integers = assetValuationMapper.selectAllSecuritiesType(toDay);
        return integers;
    }

    /**
     * 动态加载证券估值增值状态和清算状态
     * @param
     * @param
     * @return
     */
    @RequestMapping("selectAssecuritisState1")
    public List<AssetValuationData> selectAssecuritisState(String toDay, String strAppraisement){
        AssetValuationData assetValuationData = new AssetValuationData(1,"证券估值增值","未估值",false);
        AssetValuationData assetValuationData1 = new AssetValuationData(2,"清算款","未清算",false);

        List<Integer> stateList = assetValuationService.selectSecuritiesType(toDay);
        System.out.println("strAppraisement="+strAppraisement);
        if (strAppraisement!=null && !strAppraisement.equals("")){
            System.out.println("不为null");
            String[] split = strAppraisement.split(",");
            for (int i=0; i<split.length;i++){
                if (Integer.parseInt(split[i])==1){
                    assetValuationData.setChecked(true);
                }
                if (Integer.parseInt(split[i])==2){
                    assetValuationData1.setChecked(true);
                }
                System.out.println("stateList="+stateList.size());
                for (Integer state:stateList){
                    if (Integer.parseInt(split[i])==1){
                        if (state==1){
                            System.out.println("进来，以估值");
                            assetValuationData.setState("已估值");
                        }
                    }
                    if (Integer.parseInt(split[i])==2){
                        if(state==2 || state==4){
                            assetValuationData1.setState("已清算");
                        }
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

        List<AssetValuationData> dataList = new ArrayList<AssetValuationData>();
        dataList.add(assetValuationData);
        dataList.add(assetValuationData1);
        System.out.println(strAppraisement);

        return dataList;
    }


    @RequestMapping("selecAssetValuationData")
    public HashMap selecAssetValuationData(String toDay, Integer securitiesType){
        System.out.println("dada==========================");
        System.out.println("资产估值分页查询控制器");
        List<AssetValuationData> assetValuationDataList = assetValuationService.selectAssecuritisStates(toDay,securitiesType);
        HashMap<String,Object> hashMap = new HashMap<>();

        //以layui要求存储响应数据格式
        hashMap.put("code",10);
        hashMap.put("msg","");
        hashMap.put("count",0);
        hashMap.put("data",assetValuationDataList);
        System.out.println("信息的大小："+assetValuationDataList.size());
        return hashMap;
    }
}
