package com.ssaw.CashManagement.service;

import com.ssaw.CashManagement.entity.TransferMoney;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
*@program:TescComment
*@Eescription:划款指令
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Service
public interface TransferMoneyService {
    public Map<String,Object> selectTransferMoney(String pageSize,String page);
    public int insertTransferMoney(TransferMoney transferMoney);
    public int updateTransferMoney(TransferMoney transferMoney);
    public int deleteTransferMoney();
}
