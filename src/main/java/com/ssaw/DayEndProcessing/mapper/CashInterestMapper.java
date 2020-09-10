package com.ssaw.DayEndProcessing.mapper;

import com.ssaw.DayEndProcessing.entity.BondInterest;
import com.ssaw.DayEndProcessing.entity.CashInterest;
import com.ssaw.DayEndProcessing.entity.TwoFeeInterest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 收益计提
 */
@Mapper
public interface CashInterestMapper {
    /**现金计息
     * 按条件查询 分页查询
     * @return 按业务时间查询的集合
     */
    public List<CashInterest> selectCashInterest(String dateTime);
//    查询债券计息
    public List<BondInterest> selectBondInterest(String dateTime);
//    查询两费
    public List<TwoFeeInterest> selectTwoFeeInterest(String dateTime);
}
