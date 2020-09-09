package com.ssaw.BusinessData.entity;
/**
 *@program: FA
 *@description: 证券应收应付实体类
 *@author: 瞿平
 *@create: 2020-09-09 10:36
 **/
public class SecuritiesClosedPay {
    private String securitiesClosedPayId;       // 证券应收应付Id
    private String fundId;                     // 基金信息表Id
    private String accountId;                   // 账户信息表ID
    private String securitiesId;                //证券信息表ID
    private Integer serviceType;                 //业务类型 1=清算款 2=估值增值 3=债券利息
    private Double amount;                      //金额
    private String dateTime;                    //日期
    private Integer flag;                        //流入1 流出-1
    /**
     * 证券名称
     */
    private String securitiesName;

    public SecuritiesClosedPay() {
    }

    public SecuritiesClosedPay(String securitiesClosedPayId, String fundId, String accountId, String securitiesId, Integer serviceType, Double amount, String dateTime, Integer flag,String securitiesName) {
        this.securitiesClosedPayId = securitiesClosedPayId;
        this.fundId = fundId;
        this.accountId = accountId;
        this.securitiesId = securitiesId;
        this.serviceType = serviceType;
        this.amount = amount;
        this.dateTime = dateTime;
        this.flag = flag;
        this.securitiesName = securitiesName;
    }

    public String getSecuritiesClosedPayId() {
        return securitiesClosedPayId;
    }

    public void setSecuritiesClosedPayId(String securitiesClosedPayId) {
        this.securitiesClosedPayId = securitiesClosedPayId;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getSecuritiesName() {
        return securitiesName;
    }

    public void setSecuritiesName(String securitiesName) {
        this.securitiesName = securitiesName;
    }

    @Override
    public String toString() {
        return "SecuritiesClosedPay{" +
                "securitiesClosedPayId='" + securitiesClosedPayId + '\'' +
                ", fundId='" + fundId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", serviceType=" + serviceType +
                ", amount=" + amount +
                ", dateTime='" + dateTime + '\'' +
                ", flag=" + flag +
                ", securitiesName='" + securitiesName + '\'' +
                '}';
    }
}
