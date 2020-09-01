package com.ssaw.BusinessDescription.service;

import com.ssaw.BusinessDescription.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@program:TescComment
*@Eescription:现金账户Service
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Service
public interface AccountService {
    public List<Account> selectAccount();
    public int insertAccount();
    public int updateAccount();
    public int deleteAccount();
}
