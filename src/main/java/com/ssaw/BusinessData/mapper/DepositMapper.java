package com.ssaw.BusinessData.mapper;

import com.ssaw.BusinessData.entity.Deposit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
*@program:TescComment
*@Eescription:存款业务的增删改查
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Mapper
public interface DepositMapper {
    public void selectDeposit(Map map);
    public int insertDeposit(Deposit deposit);
    public int updateDeposit(Deposit deposit);
    public int deleteDeposit(String depositId);
}
