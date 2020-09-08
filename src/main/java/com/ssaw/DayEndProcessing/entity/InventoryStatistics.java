package com.ssaw.DayEndProcessing.entity;

/**
 * ClassName:    InventoryStatistics
 * Package:    com.ssaw.DayEndProcessing.entity
 * Description: 库存统计
 * Version:
 * Datetime:    2020/9/8   11:06
 * Author:   SYT
 */
public class InventoryStatistics {
    // 库存编号
    private String inventoryId;
    //库存名称
    private String inventoryName;
    //基金代码  来自基金表
    private String fundId;
    //操作员 来自操作员信息表
    private String userId;
    //统计日期
    private String dateTime;
    //已统计数据
    private int haveStatisticalData;
    //统计状态
    private String stateOfStatistical;
    //    private String fundName;


    public InventoryStatistics(){

    }

    public InventoryStatistics(String inventoryId, String inventoryName, String fundId, String userId, String dateTime, int haveStatisticalData, String stateOfStatistical) {
        this.inventoryId = inventoryId;
        this.inventoryName = inventoryName;
        this.fundId = fundId;
        this.userId = userId;
        this.dateTime = dateTime;
        this.haveStatisticalData = haveStatisticalData;
        this.stateOfStatistical = stateOfStatistical;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getHaveStatisticalData() {
        return haveStatisticalData;
    }

    public void setHaveStatisticalData(int haveStatisticalData) {
        this.haveStatisticalData = haveStatisticalData;
    }

    public String getStateOfStatistical() {
        return stateOfStatistical;
    }

    public void setStateOfStatistical(String stateOfStatistical) {
        this.stateOfStatistical = stateOfStatistical;
    }
}
