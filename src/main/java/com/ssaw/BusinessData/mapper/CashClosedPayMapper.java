package com.ssaw.BusinessData.mapper;

import com.ssaw.BusinessData.entity.CashClosedPay;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName CashClosedPayMapper
 * @Description: TODO
 * @Author 阙魁
 * @Date create in 22:13 2020/9/1
 * @Version 1.0
 **/
@Mapper
public interface CashClosedPayMapper {

    int insertCashClosedPay(CashClosedPay cashClosePay);
    int deleteCashClosedPay(List cashClosedPayId);
    int updateCashClosedPay(CashClosedPay cashClosePay);
    void selectCashClosedPay(Map map);
}
