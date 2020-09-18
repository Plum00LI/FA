package com.ssaw.ReportManagement.entity;

/**
 *@program: FA
 *@description: 成交清算日报表实体类
 *@author: 瞿平
 *@create: 2020-09-16 16:03
 **/
public class ClosingDate {
    private String securitiesId;    //FK 证券编号ID （证券表的ID）
    private String securitiesName;                //证券名称
    private Double num;             //交易数量
    private Double price;           //交易价格(单价)
    private int flag;  // 流入 1  流出-1
    private Double commission;        //佣金费用（券商）
    private Double stamp;            //印花税（上交国家的税）
    private Double brokerage;        //经手费（交易所）
    private Double transfer;        //过户费（交易所）
    private Double management;        //征管费（上交国家的税）
    private Double security;        //证券利息
    private Double netReceipts;        //交易总金额
    private int transactionDataMode;//交易方式(1买入、2卖出，3分红，4送股)
    private int securitiesType;//证券类型 1=债券  2=股票

    public ClosingDate() {
    }

    public ClosingDate(String securitiesId, String securitiesName, Double num, Double price,int flag,Double commission, Double stamp, Double brokerage, Double transfer, Double management, Double security, Double netReceipts, int transactionDataMode, int securitiesType) {
        this.securitiesId = securitiesId;
        this.securitiesName = securitiesName;
        this.num = num;
        this.price = price;
        this.flag = flag;
        this.commission = commission;
        this.stamp = stamp;
        this.brokerage = brokerage;
        this.transfer = transfer;
        this.management = management;
        this.security = security;
        this.netReceipts = netReceipts;
        this.transactionDataMode = transactionDataMode;
        this.securitiesType = securitiesType;
    }

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
    }

    public String getSecuritiesName() {
        return securitiesName;
    }

    public void setSecuritiesName(String securitiesName) {
        this.securitiesName = securitiesName;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getStamp() {
        return stamp;
    }

    public void setStamp(Double stamp) {
        this.stamp = stamp;
    }

    public Double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Double brokerage) {
        this.brokerage = brokerage;
    }

    public Double getTransfer() {
        return transfer;
    }

    public void setTransfer(Double transfer) {
        this.transfer = transfer;
    }

    public Double getManagement() {
        return management;
    }

    public void setManagement(Double management) {
        this.management = management;
    }

    public Double getSecurity() {
        return security;
    }

    public void setSecurity(Double security) {
        this.security = security;
    }

    public Double getNetReceipts() {
        return netReceipts;
    }

    public void setNetReceipts(Double netReceipts) {
        this.netReceipts = netReceipts;
    }

    public int getTransactionDataMode() {
        return transactionDataMode;
    }

    public void setTransactionDataMode(int transactionDataMode) {
        this.transactionDataMode = transactionDataMode;
    }

    public int getSecuritiesType() {
        return securitiesType;
    }

    public void setSecuritiesType(int securitiesType) {
        this.securitiesType = securitiesType;
    }

    @Override
    public String toString() {
        return "ClosingDate{" +
                "securitiesId='" + securitiesId + '\'' +
                ", securitiesName='" + securitiesName + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", commission=" + commission +
                ", stamp=" + stamp +
                ", brokerage=" + brokerage +
                ", transfer=" + transfer +
                ", management=" + management +
                ", security=" + security +
                ", netReceipts=" + netReceipts +
                ", transactionDataMode=" + transactionDataMode +
                ", securitiesType=" + securitiesType +
                '}';
    }
}
