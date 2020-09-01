package com.ssaw.BusinessData.mapper;

import com.ssaw.BusinessData.entity.Deposit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
*@program:TescComment
*@Eescription:存款业务的增删改查
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Mapper
public interface DepositMapper {
    public List<DepositMapper> selectDeposit();
    public int insertDeposit(Deposit deposit);
    public int deleteDeposit(int depositId);
}
