package com.ssaw.CashManagement.mapper;


import com.ssaw.CashManagement.entity.TransferMoney;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
*@program:TescComment
*@Eescription:划款指令增删改查
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Mapper
public interface TransferMoneyMapper {
    public void selectTransferMoney(Map map);
    public int insertTransferMoney(TransferMoney transferMoney);
    public int updateTransferMoney(TransferMoney transferMoney);
    public int deleteTransferMoney();
}
