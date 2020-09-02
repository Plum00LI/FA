package com.ssaw.BusinessDescription.controller;

import com.ssaw.BusinessDescription.entity.Account;
import com.ssaw.BusinessDescription.mapper.AccountMapper;
import com.ssaw.BusinessDescription.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @program:TescComment
 * @Eescription:Controller控制层
 * @author:黄庆
 * @Version:1.0
 * @create:2020-09-02
 */
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/selectAccount")
    public HashMap selectAccount(){
        List<Account> accountList = accountService.selectAccount();
        HashMap accountMap=new HashMap();
        accountMap.put("count",0);
        accountMap.put("code", 0);
        accountMap.put("msg", "");
        accountMap.put("data", accountList);
        return accountMap;
    }
}


