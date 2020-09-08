package com.ssaw.BusinessData.service;

import com.ssaw.BusinessData.entity.Deposit;
import com.ssaw.BusinessData.mapper.DepositMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
*@program:TescComment
*@Eescription:存款业务service
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Service
@Transactional
public interface DepositService {
    public Map<String,Object> selectDeposit(String pageSize,String page,String businessType,String endDate);
    public int insertDeposit(Deposit deposit);
    public int deleteDeposit(int depositId);
}
