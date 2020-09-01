package com.ssaw.CashManagement.service.impl;

import com.ssaw.CashManagement.entity.BankTreasurer;
import com.ssaw.CashManagement.mapper.BankTreasurerMapper;
import com.ssaw.CashManagement.service.BankTreasurerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*@program:TescComment
*@Eescription:资金调拨
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Service
public class BankTreasurerServiceImpl implements BankTreasurerService {
    @Resource
    BankTreasurerMapper bankTreasurerMapper;
    @Override
    public List<BankTreasurer> selectBankTreasurer() {
        return bankTreasurerMapper.selectBankTreasurer();
    }

    @Override
    public int insertBankTreasurer(BankTreasurer bankTreasurer) {
        return bankTreasurerMapper.insertBankTreasurer(bankTreasurer);
    }

    @Override
    public int updateBankTreasurer(BankTreasurer bankTreasurer) {
        return bankTreasurerMapper.updateBankTreasurer(bankTreasurer);
    }

    @Override
    public int deleteBankTreasurer(int treasurerId) {
        return bankTreasurerMapper.deleteBankTreasurer(treasurerId);
    }
}
