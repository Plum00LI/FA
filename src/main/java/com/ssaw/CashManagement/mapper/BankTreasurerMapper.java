package com.ssaw.CashManagement.mapper;

import com.ssaw.CashManagement.entity.BankTreasurer;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

/**
*@program:TescComment
*@Eescription:资金调拨的增删改查
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Mapper
public interface BankTreasurerMapper {
    public void selectBankTreasurer(Map map);
    public int insertBankTreasurer(BankTreasurer bankTreasurer);
    public int updateBankTreasurer(BankTreasurer bankTreasurer);
    public int deleteBankTreasurer(List bankTreasurerId);
    public int deleteBankTreasurerByDepositId(String depositId);
}
