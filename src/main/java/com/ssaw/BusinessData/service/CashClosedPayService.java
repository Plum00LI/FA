package com.ssaw.BusinessData.service;

import com.ssaw.BusinessData.entity.CashClosedPay;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName CashClosedPayService
 * @Description: TODO
 * @Author 阙魁
 * @Date create in 22:51 2020/9/7
 * @Version 1.0
 **/
@Service

public interface CashClosedPayService {
    int insertCashClosedPay(CashClosedPay cashClosePay);
    int deleteCashClosedPay(String cashClosedPayId);
    int updateCashClosedPay(CashClosedPay cashClosePay);
    Map<String,Object> selectCashClosedPay(String pageSize, String page,String dateTime,String serviceType);
}
