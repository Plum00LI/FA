package com.ssaw.CashManagement.mapper;

import com.ssaw.CashManagement.entity.BankTreasurer;
import com.ssaw.CashManagement.entity.TransferMoney;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
*@program:TescComment
*@Eescription:划款指令增删改查
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Mapper
public interface TransferMoneyMapper {
    public List<TransferMoney> selectTransferMoney();
    public int insertTransferMoney();
    public int updateTransferMoney();
    public int deleteTransferMoney();
}
