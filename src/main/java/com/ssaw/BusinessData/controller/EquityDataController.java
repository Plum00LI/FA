package com.ssaw.BusinessData.controller;

import com.ssaw.BusinessData.entity.EquityData;
import com.ssaw.BusinessData.service.EquityDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @program:权益数据模块
 * @Description:控制类
 * @author:孙浩
 * @create:2020-09-01
 */
@RestController
public class EquityDataController {
    @Resource
    EquityDataService transactionDataService;

    @RequestMapping("/insertEquityData")
    public int insertTransactionData(EquityData transactionData){
        int i = transactionDataService.insertTransactionData(transactionData);
        return i;
    }

    @RequestMapping("/deleteEquityData")
    public void deleteTransactionData(int equityId){
        transactionDataService.deleteTransactionData(equityId);
    }

    @RequestMapping("/updateEquityData")
    public int updateTransactionData(EquityData transactionData){
        int i = transactionDataService.updateTransactionData(transactionData);
        return i;
    }

    @RequestMapping("/selectEquityData")
    public HashMap selectTransactionData(){
        List<EquityData> transactionDataList =transactionDataService.selectTransactionData();
        HashMap transactionDateMap = new HashMap();
        transactionDateMap.put("count",10);
        transactionDateMap.put("code",0);
        transactionDateMap.put("msg","");
        transactionDateMap.put("data",transactionDataList);
        System.out.println("已有"+transactionDataList.size()+"条数据");
        return transactionDateMap;
    }
}
