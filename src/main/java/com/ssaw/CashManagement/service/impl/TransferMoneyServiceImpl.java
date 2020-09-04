package com.ssaw.CashManagement.service.impl;

import com.ssaw.CashManagement.entity.TransferMoney;
import com.ssaw.CashManagement.mapper.TransferMoneyMapper;
import com.ssaw.CashManagement.service.TransferMoneyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
*@program:TescComment
*@Eescription:划款指令
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Service
@Transactional
public class TransferMoneyServiceImpl implements TransferMoneyService {
    @Resource
    TransferMoneyMapper transferMoneyMapper;
    @Override
    public List<TransferMoney> selectTransferMoney() {
        return transferMoneyMapper.selectTransferMoney();
    }

    @Override
    public int insertTransferMoney() {
        return transferMoneyMapper.insertTransferMoney();
    }

    @Override
    public int updateTransferMoney() {
        return transferMoneyMapper.updateTransferMoney();
    }

    @Override
    public int deleteTransferMoney() {
        return transferMoneyMapper.deleteTransferMoney();
    }
}
