package com.ssaw.DayEndProcessing.controller;

import com.ssaw.DayEndProcessing.entity.BondInterestIncome;
import com.ssaw.DayEndProcessing.entity.CashInterestIncome;
import com.ssaw.DayEndProcessing.entity.PayTwoFees;
import com.ssaw.DayEndProcessing.service.IncomePaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName IncomePaymentController
 * @Description: TODO
 * @Author 阙魁
 * @Date 2020/9/9
 * @Version 1.0
 **/
@RestController
@RequestMapping("incomePayment")
public class IncomePaymentController {
    @Resource
    IncomePaymentService incomePaymentService;

    @RequestMapping("selectCashInterestIncome")
    public Map<String, Object> selectCashInterestIncome(String page, String limit, String statDate, String fundId) {
        System.out.println("进入了现金利息收入查询controller");
        System.out.println("时间："+statDate);
        //调用service层，返回结果集map
        Map<String, Object> map = incomePaymentService.selectCashInterestIncome(limit, page,statDate,fundId);
        //从结果集中拿出结果
        //接收返回数据
        List<CashInterestIncome> cashInterestIncomes= (List<CashInterestIncome>) map.get("cashInterestIncomes");
        //接收返回总条数
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",cashInterestIncomes);
        System.out.println("控制层:"+cashInterestIncomes.toString());
        //返回数据
        return json;
    }

    @RequestMapping("selectBondInterestIncome")
    public Map<String, Object> selectBondInterestIncome(String page, String limit, String statDate, String fundId) {
        System.out.println("进入了债券利息收入查询controller");
        //调用service层，返回结果集map
        Map<String, Object> map = incomePaymentService.selectBondInterestIncome(limit,page,statDate,fundId);
        //从结果集中拿出结果
        //接收返回数据
        List<BondInterestIncome> bondInterestIncomes= (List<BondInterestIncome>) map.get("bondInterestIncomes");
        //接收返回总条数
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",bondInterestIncomes);
        System.out.println("控制层:"+bondInterestIncomes.toString());
        //返回数据
        return json;
    }

    @RequestMapping("selectPayTwoFees")
    public Map<String, Object> selectPayTwoFees(String page, String limit, String statDate, String fundId) {
        System.out.println("进入了支付两费查询controller");
        //调用service层，返回结果集map
        Map<String, Object> map = incomePaymentService.selectPayTwoFees(limit,page,statDate,fundId);
        //从结果集中拿出结果
        //接收返回数据
        List<PayTwoFees> payTwoFees= (List<PayTwoFees>) map.get("payTwoFees");
        //接收返回总条数
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",payTwoFees);
        System.out.println("控制层:"+payTwoFees.toString());
        //返回数据
        return json;
    }


}