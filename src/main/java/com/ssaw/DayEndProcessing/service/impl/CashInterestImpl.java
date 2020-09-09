package com.ssaw.DayEndProcessing.service.impl;

import com.ssaw.DayEndProcessing.entity.BondInterest;
import com.ssaw.DayEndProcessing.entity.CashInterest;
import com.ssaw.DayEndProcessing.entity.TwoFeeInterest;
import com.ssaw.DayEndProcessing.mapper.CashInterestMapper;
import com.ssaw.DayEndProcessing.service.CashInterestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 收益计提
 */
@Service
public class CashInterestImpl implements CashInterestService {
    @Resource
    CashInterestMapper cashInterestMapper;
    //现金计息
    @Override
    public List<CashInterest> selectCashInterest(String dateTime) {
        return cashInterestMapper.selectCashInterest(dateTime);
    }
    //查询债券计息
    @Override
    public List<BondInterest> selectBondInterest(String dateTime) {
        return cashInterestMapper.selectBondInterest(dateTime);
    }
    //查询两费
    @Override
    public List<TwoFeeInterest> selectTwoFeeInterest(String dateTime) {
        return cashInterestMapper.selectTwoFeeInterest(dateTime);
    }


}
