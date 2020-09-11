package com.ssaw.InventoryManagement.entity;

/**
 * ClassName:    SecuritiesClosedPayInventory
 * Package:    com.ssaw.InventoryManagement.entity
 * Description:
 * Version:
 * Datetime:    2020/9/6   20:17
 * Author:   SYT
 */

public class SecuritiesClosedPayInventory {
    //证券应收应付存库Id
    private String securitiesClosedPayInventoryId;

    //业务日期
    private String dateTime;
    //基金信息表Id
    private String fundId;
    //证券信息表ID  securities表
    private String securitiesId;
    //证券应收应付类型 1=估值款 2=证券清算款 3=债券利息
    private int securitiesType;
    //业务状态 1流入，-1流出
    private int flag;
    //总金额*
    private double totalPrice;
    //备注
    private String securitiesClosedPayDesc;
    //期初标志 是否从其他系统导入得期初数据 0：不是 1：是
    private int securityPeriodFlag;

    public SecuritiesClosedPayInventory(){

    }


    /**
     *
     * @param securitiesClosedPayInventoryId    证券应收应付存库Id
     * @param dateTime  业务日期
     * @param fundId    基金信息表Id
     * @param securitiesId  证券信息表ID  securities表
     * @param securitiesType    证券应收应付类型 1=估值款 2=证券清算款 3=债券利息
     * @param flag  业务状态 1流入，-1流出
     * @param totalPrice    总金额*
     * @param securitiesClosedPayDesc   备注
     * @param securityPeriodFlag    期初标志 是否从其他系统导入得期初数据 0：不是 1：是
     */
    public SecuritiesClosedPayInventory(String securitiesClosedPayInventoryId,String dateTime, String fundId, String securitiesId, int securitiesType, int flag, double totalPrice, String securitiesClosedPayDesc, int securityPeriodFlag) {
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
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


    @Override
    public String toString() {
        return "SecuritiesClosedPayInventory{" +
                "securitiesClosedPayInventoryId='" + securitiesClosedPayInventoryId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", fundId='" + fundId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", securitiesType=" + securitiesType +
                ", flag=" + flag +
                ", totalPrice=" + totalPrice +
                ", securitiesClosedPayDesc='" + securitiesClosedPayDesc + '\'' +
                ", securityPeriodFlag=" + securityPeriodFlag +
                '}';
    }
}
