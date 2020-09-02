package com.ssaw.CashManagement.mapper;

import com.ssaw.CashManagement.entity.BankTreasurer;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
*@program:TescComment
*@Eescription:资金调拨的增删改查
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Mapper
public interface BankTreasurerMapper {
    public List<BankTreasurer> selectBankTreasurer();
    public int insertBankTreasurer(BankTreasurer bankTreasurer);
    public int updateBankTreasurer(BankTreasurer bankTreasurer);
    public int deleteBankTreasurer(int treasurerId);
}
