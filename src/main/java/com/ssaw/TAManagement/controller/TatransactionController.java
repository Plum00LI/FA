package com.ssaw.TAManagement.controller;

import com.ssaw.BusinessDescription.entity.Bond;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import com.ssaw.TAManagement.entity.TaTransaction;
import com.ssaw.TAManagement.service.TatransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:TescComment
 * @Description:实体类
 * @authod:洪彬峰
 * @create:2020-09-01
 */
@RestController
public class TatransactionController {
    @Resource
    TatransactionService tatransactionService;
    @Resource
    DbUtil dbUtil;
    @RequestMapping ("/insertTatTransaction")
    public int insertTatTransaction(TaTransaction taTransaction){
        taTransaction.setTaTransactionId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TT));

        System.out.println("taTransaction=" + taTransaction);
        int i= tatransactionService.insertTatransaction(taTransaction);
        return i;
    }
    @RequestMapping("/deleteTaTransaction")
    public int deleteTatransaction(String taTransactionId){
        System.out.println("进来了");
        int i = tatransactionService.deleteTatransaction(taTransactionId);
        return i;
    }
    @RequestMapping("/updateTaTransaction")
    public int updataTatransaction(TaTransaction taTransaction){
        System.out.println("进来了");
        System.out.println("修改时：" + taTransaction);
        int b = tatransactionService.updataTetransaction(taTransaction);

        return b;
    }
    @RequestMapping("/selectTaTransaction")
    public Map<String,Object> selectTatransaction(String page, String limit,String dateTime,String transactionStatus,String transactionType) {
        System.out.println("进来了");
        System.out.println(dateTime+","+","+transactionStatus+","+transactionType);
        Map<String,Object> map=tatransactionService.selectTatransaction(limit, page,dateTime,transactionStatus,transactionType);
        List<TaTransaction> tatransactionList= (List<TaTransaction>) map.get("taTransactionList");
        int count = (int) map.get("count");

        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",tatransactionList);
        //返回数据
        return json;
    }

}
