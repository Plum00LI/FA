package com.ssaw.CashManagement.service;

import com.ssaw.CashManagement.entity.TransferMoney;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
*@program:TescComment
*@Eescription:划款指令
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Service
public interface TransferMoneyService {
    public List<TransferMoney> selectTransferMoney();
    public int insertTransferMoney();
    public int updateTransferMoney();
    public int deleteTransferMoney();
}
