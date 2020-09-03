package com.ssaw.CashManagement.service;

import com.ssaw.CashManagement.entity.BankTreasurer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
*@program:TescComment
*@Eescription:资金调拨service
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Service
public interface BankTreasurerService {
    public Map<String,Object> selectBankTreasurer(String pageSize,String page);
    public int insertBankTreasurer(BankTreasurer bankTreasurer);
    public int updateBankTreasurer(BankTreasurer bankTreasurer);
    public int deleteBankTreasurer(int treasurerId);
}
