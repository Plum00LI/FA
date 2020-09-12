package com.ssaw.DayEndProcessing.entity;

/**
 * ClassName:    CashInventoryData
 * Package:    com.ssaw.DayEndProcessing.entity
 * Description: 保存现金库存查询信息
 * Version:
 * Datetime:    2020/9/11   14:54
 * Author:   SYT
 */
public class CashInventoryData {
    private double cashTotal;
    public CashInventoryData(){

    }

    public CashInventoryData(double cashTotal) {
        this.cashTotal = cashTotal;
    }

    @Override
    public String
    toString() {
        return "CashInventoryData{" +
                "cashTotal=" + cashTotal +
                '}';
    }

    public double getCashTotal() {
        return cashTotal;
    }

    public void setCashTotal(double cashTotal) {
        this.cashTotal = cashTotal;
    }
}
