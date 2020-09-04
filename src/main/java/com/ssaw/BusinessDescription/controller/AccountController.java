package com.ssaw.BusinessDescription.controller;

import com.ssaw.BusinessDescription.entity.Account;
import com.ssaw.BusinessDescription.mapper.AccountMapper;
import com.ssaw.BusinessDescription.service.AccountService;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @create:2020-09-02
 */
@RestController
public class AccountController {

    /**
     * 注入account服务层
     */
    @Resource
    AccountService accountService;

    @Resource
    DbUtil dbUtil;
    @RequestMapping("selectAccount")
    public Map<String,Object> selectAccount(String page, String limit,String accountName,String blankName){
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map = accountService.selectAccount(limit, page,accountName,blankName);
        //从结果集中拿出结果
        List<Account> accountList= (List<Account>) map.get("accountList");
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String,Object> json=new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",accountList);
        //返回数据
        return json;
    }
    @RequestMapping("insertAccount")
    public int insertAccount(Account account){
        account.setAccountId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.A));
        account.setFundId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.F));
        int i = accountService.insertAccount(account);
        return i;
    }
    @RequestMapping("deleteAccount")
    public int deleteAccount(String accountId){
        System.out.println(accountId);
        int i = accountService.deleteAccount(accountId);
        return i;
    }
    @RequestMapping("updateAccount")
    public int deleteAccount(Account account){
        System.out.println(account);
        int i = accountService.updateAccount(account);
        return i;
    }
}


