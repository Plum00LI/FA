package com.ssaw.BusinessDescription.service.impl;

import com.ssaw.BusinessDescription.entity.Account;
import com.ssaw.BusinessDescription.mapper.AccountMapper;
import com.ssaw.BusinessDescription.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        return accountMapper.selectAccount();
    }

    @Override
    public int insertAccount() {
        return accountMapper.insertAccount();
    }

    @Override
    public int updateAccount() {
        return accountMapper.updateAccount();
    }

    @Override
    public int deleteAccount() {
        return accountMapper.deleteAccount();
    }
}
