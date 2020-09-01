package com.ssaw.BusinessData.entity;

/**
 * 现金应收应付表
 * @type:CashClosedPay
 * @version v1.0
 * @author:阙魁
 * @create:2020-09-01
 */
public class CashClosedPay {
    //现金应收应付Id
    private String cashClosedPayId;
    //FK 基金信息表Id  fund表
    private String fundId;
    //FK 账户信息表ID  account表
    private  String accountId;
    //FK 证券信息表ID  securities表
    private String securitiesId;
    //业务类型  1=“管理费”2=“托管费”3=“存款利息”4=“申购赎回款”
    private int serviceType;
    //金额
    private double amount;
    //日期
    private String dateTime;
    //资金流向 1=“流入”-1 =“流出”
    private int flag;

    public CashClosedPay() {
    }

    public CashClosedPay(String cashClosedPayId, String fundId, String accountId, String securitiesId, int serviceType, double amount, String dateTime, int flag) {
        this.cashClosedPayId = cashClosedPayId;
        this.fundId = fundId;
        this.accountId = accountId;
        this.securitiesId = securitiesId;
        this.serviceType = serviceType;
        this.amount = amount;
        this.dateTime = dateTime;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "CashClosedPay{" +
                "cashClosedPayId='" + cashClosedPayId + '\'' +
                ", fundId='" + fundId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", serviceType=" + serviceType +
                ", amount=" + amount +
                ", dateTime='" + dateTime + '\'' +
                ", flag=" + flag +
                '}';
    }

    public String getCashClosedPayId() {
        return cashClosedPayId;
    }

    public void setCashClosedPayId(String cashClosedPayId) {
        this.cashClosedPayId = cashClosedPayId;
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

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}