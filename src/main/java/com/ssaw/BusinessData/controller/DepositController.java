package com.ssaw.BusinessData.controller;

import com.ssaw.BusinessData.entity.Deposit;
import com.ssaw.BusinessData.service.DepositService;
import com.ssaw.BusinessDescription.entity.Account;
import com.ssaw.BusinessDescription.service.AccountService;
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
 * @Eescription:Controller控制层
 * @author:黄庆
 * @Version:1.0
 * @create:2020-09-05
 */
@RestController
@RequestMapping("/deposit")
public class DepositController {

    /**
     * 注入account服务层
     */
    @Resource
    DepositService depositService;

    @Resource
    DbUtil dbUtil;
    @RequestMapping("selectDeposit")
    public Map<String,Object> selectDeposit(String page, String limit,String businessType,String endDate){
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map = depositService.selectDeposit(limit,page,businessType,endDate);
        //从结果集中拿出结果
        List<Deposit> depositList= (List<Deposit>) map.get("depositList");
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String,Object> json=new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",depositList);
        //返回数据
        return json;
    }
    @RequestMapping("insertDeposit")
    public int insertDeposit(Deposit deposit){
        System.out.println(deposit);
        int i = depositService.insertDeposit(deposit);
        return i;
    }
    @RequestMapping("deleteDeposit")
    public int deleteDeposit(String depositId){
        System.out.println(depositId);
        int i = depositService.deleteDeposit(depositId);
        return i;
    }
    @RequestMapping("updateDeposit")
    public int updateDeposit(Deposit deposit){
        System.out.println("deposit进去了===========");
        int i = depositService.updateDeposit(deposit);
        System.out.println(deposit);
        return i;
    }
}


