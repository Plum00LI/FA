package com.ssaw.DayEndProcessing.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 收益支付 的service层
 * @type:IncomePaymentService
 * @version v1.0
 * @author:阙魁
 * @create:2020-09-08
 */

public interface IncomePaymentService {
    //现金利息收入的查询
    public Map<String,Object> selectCashInterestIncome(String pageSize,String page);
    //债券利息收入的查询
    public Map<String,Object> selectBondInterestIncome(String pageSize,String page);
    //支付两费的查询
    public Map<String,Object> selectPayTwoFees(String pageSize,String page);

}
