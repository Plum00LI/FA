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

    //查询表格内容
    @Override
    public List<AssetValuationData> selectBiaoge(){
        AssetValuationData assetValuation = new AssetValuationData(1,"证券估值增值","未估值");
        AssetValuationData assetValuation1 = new AssetValuationData(2,"清算款","未清算");
        List<AssetValuationData> assetValuationList = new ArrayList();
        assetValuationList.add(assetValuation);
        assetValuationList.add(assetValuation1);
        return assetValuationList;
    }

    // 查询是否处理的实现类
    @Override
    public List<AssetValuation> selectValuationProcessing() {
        return assetValuationMapper.selectValuationProcessing();
    }

    @Override
    public HashMap selectStockarket() {
        HashMap stockarketMap = new HashMap();
        stockarketMap.put("p_tableName","(select se.fundId,se.securitiesId,ROUND((se.securitiesNum*m.closingPrice),2) as totalPrice, SE.securityPeriodFlag from securitiesInventory se join market m on se.securitiesId=m.securitiesId)");
        stockarketMap.put("p_condition","");
        stockarketMap.put("p_pageSize",10);
        stockarketMap.put("p_page",1);
        stockarketMap.put("p_count",0);
        stockarketMap.put("p_cursor",null);
        assetValuationMapper.selectStockarket(stockarketMap);
        return stockarketMap;
    }


    @Override
    public int deleteSecuritiesClosedPayInventory(SecuritiesClosedPayInventory securitiesClosedPayInventory) {
        return assetValuationMapper.deleteSecuritiesClosedPayInventory(securitiesClosedPayInventory);
    }

    //查交易数据 按证券代码分组 插入证券应收应付库存
    @Override
    public HashMap selectTransactionData(String dateTime) {
        HashMap ransactionDataMap = new HashMap();
        ransactionDataMap.put("p_tableName","(select securitiesId,dateTime,fundId,status,SUM((totalSum*status)) totalSum from transactionData\n" +
                "where to_date(dateTime,'yyyy-MM-dd') <= to_date(dateTime,'yyyy-MM-dd') and transactionDataMode in (1,2,3,4)\n" +
                "  and to_date(dateTime,'yyyy-MM-dd') < to_date(settlementDate,'yyyy-MM-dd') GROUP BY securitiesId,dateTime,fundId,status)");
        ransactionDataMap.put("p_condition","");
        ransactionDataMap.put("p_pageSize",5);
        ransactionDataMap.put("p_page",1);
        ransactionDataMap.put("p_count",0);
        ransactionDataMap.put("p_cursor",null);
        System.out.println("插入="+ransactionDataMap);
        assetValuationMapper.selectTransactionData(ransactionDataMap);
        return ransactionDataMap;
    }


    @Override
    public int deleteSecuritiesClosedPayInventoryTwo(SecuritiesClosedPayInventory securitiesClosedPayInventory) {
        return assetValuationMapper.deleteSecuritiesClosedPayInventoryTwo(securitiesClosedPayInventory);
    }

    /**
     * 查询TA交易清算款数据
     * @return
     */
    @Override
    public HashMap selectTaTransaction() {
        HashMap taTransactionMap = new HashMap();
        taTransactionMap.put("p_tableName","(select sum(totalMoney) totalMoney,transactionType,accountId,dateTime ,fundId from taTransaction where to_date(dateTime,'yyyy-MM-dd')<= to_date('2020-09-13','yyyy-MM-dd')\n" +
                "and to_date('2020-09-13','yyyy-MM-dd')<to_date(balanceDate,'yyyy-MM-dd') group by transactionType, accountId,fundId,dateTime)");
        taTransactionMap.put("p_condition","");
        taTransactionMap.put("p_pageSize",5);
        taTransactionMap.put("p_page",1);
        taTransactionMap.put("p_count",0);
        taTransactionMap.put("p_cursor",null);
        assetValuationMapper.selectTaTransaction(taTransactionMap);
        return taTransactionMap;
    }
    @Override
    public int deleteCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory){
        return assetValuationMapper.deleteCashClosedPaylnventory(cashClosedPayInventory);
    }
}
