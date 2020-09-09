package com.ssaw.BusinessProcessing.controller;

import com.ssaw.BusinessProcessing.entity.TaSettlement;
import com.ssaw.BusinessProcessing.service.TaSettlementService;
import com.ssaw.GlobalManagement.util.DbUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询
 */
@RestController
@RequestMapping("TaSettlement")
public class TaSettlementController {
    @Resource
    TaSettlementService taSettlementService;
    @Resource
    DbUtil dbUtil;
    @RequestMapping("selectTaSettlement")
    public Map<String, Object> selectTaSettlement(String limit,String page,String dateTime,String transactionType,String status) {
        System.out.println("进来查询了" + status);
        Map<String,Object> map=taSettlementService.selectTaSettlement(limit,page,dateTime,transactionType,status);
        List<TaSettlement> taSettlementList= (List<TaSettlement>) map.get("taSettlementList");
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",taSettlementList);
        System.out.println("结果集+"+taSettlementList);

        //返回数据
        return json;
    }
}