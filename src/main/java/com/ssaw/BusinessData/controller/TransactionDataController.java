package com.ssaw.BusinessData.controller;

import com.ssaw.BusinessData.entity.TransactionData;
import com.ssaw.BusinessData.service.TransactionDataService;
import com.ssaw.BusinessDescription.entity.Fund;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * create by: 曾钦辉
 * description: 交易数据Controller控制层
 * create time: 2020/9/1 15:07
 *
  * @Param: null
 * @return
 */
@RestController
public class TransactionDataController {
    @Resource
    TransactionDataService transactionDataService;
    @RequestMapping(value = "/insertTransactionData")
    public int insertTransactionData(){
        System.out.println("进来了");
        TransactionData transactionData=new TransactionData("1","1","1","1","1",
                "1","1",1,1, 1,1,"1",1,1,
                1,1,1,1,1,1,1,"1");
        int i= transactionDataService.insertTransactionData(transactionData);
        System.out.println(i);
        return i;
    }
    @RequestMapping(value = "/deleteTransactionData")
    public void deleteTransactionData(){
        System.out.println("进来了");
        transactionDataService.deleteTransactionData("1");
    }
    @RequestMapping(value = "/updateTransactionData")
    public int updateTransactionData(){
        System.out.println("进来了");
        TransactionData transactionData=new TransactionData("1","2","3","1","1",
                "1","1",1,1, 1,1,"1",1,1,
                1,1,1,1,1,1,1,"1");
        int i= transactionDataService.updateTransactionData(transactionData);
        System.out.println(i);
        return i;
    }
    @RequestMapping(value = "/selectTransactionData")
    public List<TransactionData> selectTransactionData(){
        System.out.println("进来了");
        List<TransactionData> transactionDataList = transactionDataService.selectTransactionData();
        for (TransactionData transactionData : transactionDataList) {
            System.out.println(transactionData);
        }
        return transactionDataList;
    }
}
