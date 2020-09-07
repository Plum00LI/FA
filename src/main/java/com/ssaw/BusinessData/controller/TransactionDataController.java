package com.ssaw.BusinessData.controller;

import com.ssaw.BusinessData.entity.TransactionData;
import com.ssaw.BusinessData.service.TransactionDataService;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
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

    @Resource
    DbUtil dbUtil;
    @RequestMapping("selectTransactionData")
    public HashMap selectTransactionData(int page, int limit, String end, String equityId){
        HashMap hashMap = transactionDataService.selectTransactionData(page, limit,end,equityId);
        int count = (int) hashMap.get("p_count");
        List<TransactionData> transactionDataList = (List<TransactionData>) hashMap.get("p_cursor");
        System.out.println("总条数："+count);
        System.out.println("page="+page+",limit="+limit+",end="+end+",equityId="+equityId);
        HashMap tranMap = new HashMap();
        tranMap.put("count",count);
        tranMap.put("code",0);
        tranMap.put("msg","");
        tranMap.put("data",transactionDataList);
        System.out.println("基金大小"+transactionDataList.size());
        return tranMap;
    }
    @RequestMapping("insertTransactionData")
    public int insertTransactionData(TransactionData transactionData){
        transactionData.setTransactionDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TD));
        System.out.println(transactionData);
        return transactionDataService.insertTransactionData(transactionData);
    }

    @RequestMapping("deleteTransactionData")
    public int deleteTransactionData(String transactionDataId){
        return transactionDataService.deleteTransactionData(transactionDataId);
    }

    @RequestMapping("updateTransactionData")
    public int updateTransactionData(TransactionData transactionData){
        return transactionDataService.updateTransactionData(transactionData);
    }
}
