package com.ssaw.DayEndProcessing.service;

import com.ssaw.BusinessDescription.entity.Stock;
import com.ssaw.DayEndProcessing.entity.BondInterest;
import com.ssaw.DayEndProcessing.entity.CashInterest;
import com.ssaw.DayEndProcessing.entity.TwoFeeInterest;

import java.util.List;
import java.util.Map;

/**
 * 收益计提
 */
public interface CashInterestService {

    /**现金计息
     * 分页查询 调用存储过程
     * @return 条件查询的集合
     */
    public List<CashInterest> selectCashInterest(String dateTime);
    //查询债券计息
    public List<BondInterest> selectBondInterest(String dateTime);
    //查询两费
    public List<TwoFeeInterest> selectTwoFeeInterest(String dateTime);
}
