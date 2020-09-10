package com.ssaw.DayEndProcessing.entity;

import java.math.BigDecimal;

/**
 * ClassName:    SecuritiesInventoryData
 * Package:    com.ssaw.DayEndProcessing.entity
 * Description:
 * Version:
 * Datetime:    2020/9/9   19:31
 * Author:   SYT
 */
public class SecuritiesInventoryData {
    private String securitiesId;// 证券Id
    private int todayNum;// 总数量
    private Double todayTotal;// 总金额
    private Double unitPrice;// 单位成本

    public SecuritiesInventoryData(){

    }

    public SecuritiesInventoryData(String securitiesId, Double todayTotal, Integer todayNum, Double unitPrice) {
        this.securitiesId = securitiesId;
        this.todayTotal = todayTotal;
        this.todayNum = todayNum;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "SecuritiesInventoryData{" +
                "securitiesId='" + securitiesId + '\'' +
                ", todayTotal=" + todayTotal +
                ", todayNum=" + todayNum +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
    }

    public Double getTodayTotal() {
        return todayTotal;
    }

    public void setTodayTotal(Double todayTotal) {
        this.todayTotal = todayTotal;
    }

    public Integer getTodayNum() {
        return todayNum;
    }

    public void setTodayNum(Integer todayNum) {
        this.todayNum = todayNum;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
