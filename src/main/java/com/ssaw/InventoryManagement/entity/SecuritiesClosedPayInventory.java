package com.ssaw.InventoryManagement.entity;

/**
 * ClassName:    SecuritiesClosedPayInventory
 * Package:    com.ssaw.InventoryManagement.entity
 * Description:
 * Version:
 * Datetime:    2020/9/6   20:17
 * Author:   SYT
 */
/*create table securitiesClosedPayInventory(
        securitiesClosedPayInventoryId	  varchar2(50)                      not null ,               *//*证券存库Id 主键*//*
        datetime	                varchar2(10)                            not null ,           *//*业务日期*//*
        fundId	                    varchar2(50)                            not null ,               *//*FK 基金信息表Id      fund表*//*
        securitiesId	            varchar2(50)                            not null ,          *//*FK 证券信息表ID  securities表*//*
        securitiesType	            Number(1)                               not null ,          *//*证券应收应付类型 1=估值款 2=证券清算款 3=债券利息*//*
        flag	                    varchar2(20)                            not null ,                  *//*业务日期*//*
        tootaIPrice	                Number(16,4)                            not null ,           *//*总金额*//*
        securitiesClosedPayDesc	    varchar2(50),               *//*备注*//*
        securityPeriodFlag	        Number(1)                               not null       *//*期初标志 是否从其他系统导入得期初数据 0：不是 1：是*//*
        );*/
public class SecuritiesClosedPayInventory {
    private String securitiesClosedPayInventoryId;
    private String dateTime;
    private String fundId;
    private String securitiesId;
    private int securitiesType;
    private String flag;
    private double totalPrice;
    private String securitiesClosedPayDesc;
    private int securityPeriodFlag;

    public SecuritiesClosedPayInventory(String securitiesClosedPayInventoryId, String dateTime, String fundId, String securitiesId, int securitiesType, String flag, double totalPrice, String securitiesClosedPayDesc, int securityPeriodFlag) {
        this.securitiesClosedPayInventoryId = securitiesClosedPayInventoryId;
        this.dateTime = dateTime;
        this.fundId = fundId;
        this.securitiesId = securitiesId;
        this.securitiesType = securitiesType;
        this.flag = flag;
        this.totalPrice = totalPrice;
        this.securitiesClosedPayDesc = securitiesClosedPayDesc;
        this.securityPeriodFlag = securityPeriodFlag;
    }

    @Override
    public String toString() {
        return "SecuritiesClosedPayInventory{" +
                "securitiesClosedPayInventoryId='" + securitiesClosedPayInventoryId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", fundId='" + fundId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", securitiesType=" + securitiesType +
                ", flag='" + flag + '\'' +
                ", totalPrice=" + totalPrice +
                ", securitiesClosedPayDesc='" + securitiesClosedPayDesc + '\'' +
                ", securityPeriodFlag=" + securityPeriodFlag +
                '}';
    }

    public String getSecuritiesClosedPayInventoryId() {
        return securitiesClosedPayInventoryId;
    }

    public void setSecuritiesClosedPayInventoryId(String securitiesClosedPayInventoryId) {
        this.securitiesClosedPayInventoryId = securitiesClosedPayInventoryId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
    }

    public int getSecuritiesType() {
        return securitiesType;
    }

    public void setSecuritiesType(int securitiesType) {
        this.securitiesType = securitiesType;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSecuritiesClosedPayDesc() {
        return securitiesClosedPayDesc;
    }

    public void setSecuritiesClosedPayDesc(String securitiesClosedPayDesc) {
        this.securitiesClosedPayDesc = securitiesClosedPayDesc;
    }

    public int getSecurityPeriodFlag() {
        return securityPeriodFlag;
    }

    public void setSecurityPeriodFlag(int securityPeriodFlag) {
        this.securityPeriodFlag = securityPeriodFlag;
    }
}
