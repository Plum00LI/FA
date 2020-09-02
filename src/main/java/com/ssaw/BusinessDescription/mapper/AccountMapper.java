package com.ssaw.BusinessDescription.mapper;

import com.ssaw.BusinessDescription.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
*@program:TescComment
*@Eescription:现金账户的增删改查
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Mapper
public interface AccountMapper {
    public void selectAccount(HashMap hashMap);
    public int insertAccount(Account account);
    public int updateAccount(Account account);
    public int deleteAccount(int accountId);
}
