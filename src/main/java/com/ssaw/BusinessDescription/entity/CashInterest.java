package com.ssaw.BusinessDescription.entity;

/**
 * 收益计提
 * 现金计息实体类
 */
public class CashInterest {
    /*
    accountId           varchar2(50)        primary key         not null ,      -- 现金账户Id
    fundId                      varchar2(50)                                not null ,      -- 基金信息表Id
    cashInventoryId             Varchar2(50)                                not null ,               主键现金库存 C202008310001
    blankName           varchar2(50)                            not null ,      -- 银行名称
    accountName         varchar2(50)                            not null ,      -- 账户名称
    deposit             number(1)                               not null ,      -- 存款类型 1代表活期 2代表定期
    cardRate            number(16,4)                            not null ,      -- 卡号利率 ?/100 年利率
    procisionDays       number(1)                               not null ,      -- 计息期间 1代表360  2代表365天 3代表366天
    openTime            varchar2(12)                            not null ,      -- 开户时间
    cashBlance 	                Number(16,4)                                not null ,                   现金余额
    dateTime                    varchar2(10)                                not null ,                      统计日期
    */
    private String accountId;
    private  String fundId;
    private  String cashInventoryId;
    private  String blankName;
    private  String accountName;
    private int deposit;
    private double cardRate;
    private int procisionDays;
    private  String openTime;
    private double cashBlance;
    private  String dateTime;

    public CashInterest() {
    }

    public CashInterest(String accountId, String fundId, String cashInventoryId, String blankName, String accountName, int deposit, double cardRate, int procisionDays, String openTime, double cashBlance, String dateTime) {
        this.accountId = accountId;
        this.fundId = fundId;
        this.cashInventoryId = cashInventoryId;
        this.blankName = blankName;
        this.accountName = accountName;
        this.deposit = deposit;
        this.cardRate = cardRate;
        this.procisionDays = procisionDays;
        this.openTime = openTime;
        this.cashBlance = cashBlance;
        this.dateTime = dateTime;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getCashInventoryId() {
        return cashInventoryId;
    }

    public void setCashInventoryId(String cashInventoryId) {
        this.cashInventoryId = cashInventoryId;
    }

    public String getBlankName() {
        return blankName;
    }

    public void setBlankName(String blankName) {
        this.blankName = blankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public double getCardRate() {
        return cardRate;
    }

    public void setCardRate(double cardRate) {
        this.cardRate = cardRate;
    }

    public int getProcisionDays() {
        return procisionDays;
    }

    public void setProcisionDays(int procisionDays) {
        this.procisionDays = procisionDays;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public double getCashBlance() {
        return cashBlance;
    }

    public void setCashBlance(double cashBlance) {
        this.cashBlance = cashBlance;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "CashInterest{" +
                "accountId='" + accountId + '\'' +
                ", fundId='" + fundId + '\'' +
                ", cashInventoryId='" + cashInventoryId + '\'' +
                ", blankName='" + blankName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", deposit=" + deposit +
                ", cardRate=" + cardRate +
                ", procisionDays=" + procisionDays +
                ", openTime='" + openTime + '\'' +
                ", cashBlance=" + cashBlance +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
