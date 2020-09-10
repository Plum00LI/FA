package com.ssaw.CashManagement.controller;

import com.ssaw.CashManagement.entity.BankTreasurer;
import com.ssaw.CashManagement.entity.TransferMoney;
import com.ssaw.CashManagement.service.BankTreasurerService;
import com.ssaw.CashManagement.service.TransferMoneyService;
import com.ssaw.GlobalManagement.util.DbUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:TescComment
 * @Eescription:实体类
 * @author:黄庆
 * @Version:1.0
 * @create:2020-09-01
 */
@RestController
@RequestMapping("/transferMoney")
public class TransferMoneyController {
    @Resource
    TransferMoneyService transferMoneyService;
    @Resource
    DbUtil dbUtil;

    @RequestMapping("selectTransferMoney")
    public Map<String,Object> selectAccount(String page, String limit){
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map = transferMoneyService.selectTransferMoney(limit,page);
        //从结果集中拿出结果
        List<TransferMoney> transferMoneyList= (List<TransferMoney>) map.get("transferMoneyList");
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String,Object> json=new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",transferMoneyList);
        //返回数据
        return json;
    }
    @RequestMapping("insertTransferMoney")
    public int insertTransferMoney(TransferMoney transferMoney){
        int i = transferMoneyService.insertTransferMoney(transferMoney);
        return i;
    }
/*    @RequestMapping("deleteTransferMoney")
    public int deleteBankTreasurer(String bankTreasurerId){
        System.out.println(bankTreasurerId);
        return  bankTreasurerService.deleteBankTreasurer(bankTreasurerId);
    }*/
    @RequestMapping("updateTransferMoney")
    public int updateTransferMoney(TransferMoney transferMoney){
        int i = transferMoneyService.updateTransferMoney(transferMoney);
        return i;
    }
}
