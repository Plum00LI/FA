package com.ssaw.BusinessData.service.impl;

import com.ssaw.BusinessData.entity.Deposit;
import com.ssaw.BusinessData.mapper.DepositMapper;
import com.ssaw.BusinessData.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
*@program:TescComment
*@Eescription:存款业务
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Service
@Transactional
public class DepositServiceImpl implements DepositService {
   @Resource
   DepositMapper depositMapper;

    @Override
    public List<DepositMapper> selectDeposit() {
        return depositMapper.selectDeposit();
    }

    @Override
    public int insertDeposit(Deposit deposit) {
        return depositMapper.insertDeposit(deposit);
    }


    @Override
    public int deleteDeposit(int depositId) {
        return depositMapper.deleteDeposit(depositId);
    }
}
