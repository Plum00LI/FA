package com.ssaw.CashManagement.controller;

import com.ssaw.BusinessDescription.entity.Account;
import com.ssaw.CashManagement.entity.BankTreasurer;
import com.ssaw.CashManagement.service.BankTreasurerService;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
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
public class BankTreasurerController {
    @Resource
    BankTreasurerService bankTreasurerService;
    @Resource
    DbUtil dbUtil;

    @RequestMapping("selectBankTreasurer")
    public Map<String,Object> selectAccount(String page, String limit,String allocatingType,String flag,String dbTime){
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map = bankTreasurerService.selectBankTreasurer(limit,page,allocatingType,flag,dbTime);
        //从结果集中拿出结果
        List<BankTreasurer> bankTreasurerList= (List<BankTreasurer>) map.get("bankTreasurerList");
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String,Object> json=new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",bankTreasurerList);
        //返回数据
        return json;
    }
    @RequestMapping("insertBankTreasurer")
    public int insertBankTreasurer(BankTreasurer bankTreasurer){
        int i = bankTreasurerService.insertBankTreasurer(bankTreasurer);
        return i;
    }
    @RequestMapping("deleteBankTreasurer")
    public int deleteBankTreasurer(String bankTreasurerId){
        System.out.println(bankTreasurerId);
        return  bankTreasurerService.deleteBankTreasurer(bankTreasurerId);
    }
    @RequestMapping("updateBankTreasurer")
    public int deleteBankTreasurer(BankTreasurer bankTreasurer){
        int i = bankTreasurerService.updateBankTreasurer(bankTreasurer);
        return i;
    }
}
