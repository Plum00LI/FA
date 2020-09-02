package com.ssaw.BusinessDescription.service.impl;

import com.ssaw.BusinessDescription.entity.Account;
import com.ssaw.BusinessDescription.mapper.AccountMapper;
import com.ssaw.BusinessDescription.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
*@program:TescComment
*@Eescription:现金账户
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountMapper accountMapper;

    @Override
    public List<Account> selectAccount() {
        HashMap accountMap=new HashMap();
        accountMap.put("p_tableName","account");
        accountMap.put("p_condition","");
        accountMap.put("p_pageSize",4);
        accountMap.put("p_page",1);
        accountMap.put("p_count",0);
        accountMap.put("p_cursor",null);
        accountMapper.selectAccount(accountMap);
        List<Account> accountList = (List<Account>) accountMap.get("p_cursor");
        System.out.println(accountList);
        return accountList;
    }

    @Override
    public int insertAccount(Account account) {
        return accountMapper.insertAccount(account);
    }

    @Override
    public int updateAccount(Account account) {
        return accountMapper.updateAccount(account);
    }

    @Override
    public int deleteAccount(int accountId) {
        return accountMapper.deleteAccount(accountId);
    }
}
