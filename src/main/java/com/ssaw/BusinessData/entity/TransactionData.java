package com.ssaw.BusinessData.entity;
/**
 * create by: 曾钦辉
 * description: 交易数据实体类
 * create time: 2020/9/1 10:22
 *
  * @Param: null
 * @return
 */

/**表名transactionData
 * tradeId	Varchar2(50)	PK 交易的单子号(主键) T2020083100001
 * dateTime	date	成交日期(交易成交的日期)
 * settlementDate	date	结算日期(交易结算的日期)
 * fundId	Varchar2(50)	FK 基金代码来自基金表
 * securitiesId	Varchar2(50)	FK 证券编号 （证券表的ID）
 * brokersId	Varchar2(50)	FK 券商ID(引用券商表的券商的ID)
 * seateId	Varchar2(50)	FK 席位Id(交易席位的Id)
 * mode	Number(1)	交易方式(1买入、2卖出，3分红，4送股)
 * status	Number(1)	交易状态（0未结算，1已结算）
 * price	number(14,2)	交易价格(单价)
 * num	number(14,2)	交易数量
 * accountId	Varchar2(50)	FK 来自现金账户表
 * netReceipts	number(14,2)	实收金额
 * totalSum	number(14,2)	交易总金额
 * flag	number(14,2)	交易标识,1流入，-1流出
 * commission	number(14,2)	佣金费用（券商）
 * transfer	number(14,2)	过户费（交易所）
 * brokerage	number(14,2)	经手费（交易所）
 * stamp	number(14,2)	印花税（上交国家的税）
 * management	number(14,2)	征管费（上交国家的税）
 * security	number(14,2)	证券利息
 * desc	varchar2(50)	备注
 */
public class TransactionData {
    private String tradeId;
    private String dateTime;
    private String settlementDate;
    private String fundId;
    private String securitiesId;
    private String brokersId;
    private String seateId;
    private double transactionDataMode;
    private double status;
    private double price;
    private double num;
    private String accountId;
    private double netReceipts;
    private double totalSum;
    private double flag;
    private double commission;
    private double transfer;
    private double brokerage;
    private double stamp;
    private double management;
    private double security;
    private String transactionDataDesc;

    public TransactionData() {
    }

    public TransactionData(String dateTime, String settlementDate, String fundId, String securitiesId, String brokersId, String seateId, double transactionDataMode, double status, double price, double num, String accountId, double netReceipts, double totalSum, double flag, double commission,
                           double transfer, double brokerage, double stamp, double management, double security, String transactionDataDesc) {
        this.dateTime = dateTime;
        this.settlementDate = settlementDate;
        this.fundId = fundId;
        this.securitiesId = securitiesId;
        this.brokersId = brokersId;
        this.seateId = seateId;
        this.transactionDataMode = transactionDataMode;
        this.status = status;
        this.price = price;
        this.num = num;
        this.accountId = accountId;
        this.netReceipts = netReceipts;
        this.totalSum = totalSum;
        this.flag = flag;
        this.commission = commission;
        this.transfer = transfer;
        this.brokerage = brokerage;
        this.stamp = stamp;
        this.management = management;
        this.security = security;
        this.transactionDataDesc = transactionDataDesc;
    }

    public TransactionData(String tradeId, String dateTime, String settlementDate, String fundId, String securitiesId, String brokersId, String seateId, double transactionDataMode, double status, double price, double num, String accountId, double netReceipts, double totalSum, double flag, double commission,
                           double transfer, double brokerage, double stamp, double management, double security, String transactionDataDesc) {
        this.tradeId = tradeId;
        this.dateTime = dateTime;
        this.settlementDate = settlementDate;
        this.fundId = fundId;
        this.securitiesId = securitiesId;
        this.brokersId = brokersId;
        this.seateId = seateId;
        this.transactionDataMode = transactionDataMode;
        this.status = status;
        this.price = price;
        this.num = num;
        this.accountId = accountId;
        this.netReceipts = netReceipts;
        this.totalSum = totalSum;
        this.flag = flag;
        this.commission = commission;
        this.transfer = transfer;
        this.brokerage = brokerage;
        this.stamp = stamp;
        this.management = management;
        this.security = security;
        this.transactionDataDesc = transactionDataDesc;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
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

    public String getBrokersId() {
        return brokersId;
    }

    public void setBrokersId(String brokersId) {
        this.brokersId = brokersId;
    }

    public String getSeateId() {
        return seateId;
    }

    public void setSeateId(String seateId) {
        this.seateId = seateId;
    }

    public double getTransactionDataMode() {
        return transactionDataMode;
    }

    public void setTransactionDataMode(double transactionDataMode) {
        this.transactionDataMode = transactionDataMode;
    }

    public double getStatus() {
        return status;
    }

    public void setStatus(double status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getNetReceipts() {
        return netReceipts;
    }

    public void setNetReceipts(double netReceipts) {
        this.netReceipts = netReceipts;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public double getFlag() {
        return flag;
    }

    public void setFlag(double flag) {
        this.flag = flag;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getTransfer() {
        return transfer;
    }

    public void setTransfer(double transfer) {
        this.transfer = transfer;
    }

    public double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(double brokerage) {
        this.brokerage = brokerage;
    }

    public double getStamp() {
        return stamp;
    }

    public void setStamp(double stamp) {
        this.stamp = stamp;
    }

    public double getManagement() {
        return management;
    }

    public void setManagement(double management) {
        this.management = management;
    }

    public double getSecurity() {
        return security;
    }

    public void setSecurity(double security) {
        this.security = security;
    }

    public String getTransactionDataDesc() {
        return transactionDataDesc;
    }

    public void setTransactionDataDesc(String transactionDataDesc) {
        this.transactionDataDesc = transactionDataDesc;
    }

    @Override
    public String toString() {
        return "TransactionData{" +
                "tradeId='" + tradeId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", settlementDate='" + settlementDate + '\'' +
                ", fundId='" + fundId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", brokersId='" + brokersId + '\'' +
                ", seateId='" + seateId + '\'' +
                ", transactionDataMode=" + transactionDataMode +
                ", status=" + status +
                ", price=" + price +
                ", num=" + num +
                ", accountId='" + accountId + '\'' +
                ", netReceipts=" + netReceipts +
                ", totalSum=" + totalSum +
                ", flag=" + flag +
                ", commission=" + commission +
                ", transfer=" + transfer +
                ", brokerage=" + brokerage +
                ", stamp=" + stamp +
                ", management=" + management +
                ", security=" + security +
                ", transactionDataDesc='" + transactionDataDesc + '\'' +
                '}';
    }
}
