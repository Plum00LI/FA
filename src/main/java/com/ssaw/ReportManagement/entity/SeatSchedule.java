package com.ssaw.ReportManagement.entity;

public class SeatSchedule {
    private String seateId;         //FK 席位Id 排序
    private String seateName;                //席位名称
    private String fundName;        //基金名称
    private String securitiesId;    //FK 证券编号ID （证券表的ID） 排序
    private Double price;           //交易价格(单价)
    private Double num;             //交易数量
    private int flag;              //交易标识,1流入，-1流出
    private Double commission;        //佣金费用（券商）
    private Double transfer;        //过户费（交易所）
    private Double brokerage;        //经手费（交易所）
    private Double stamp;            //印花税（上交国家的税）
    private Double management;        //征管费（上交国家的税）
    private Double netReceipts;        //实收金额
    private Double totalSum;        //交易总金额
    private String settlementDate;  //结算日期(交易结算的日期)

    public SeatSchedule() {
    }

    public SeatSchedule(String seateId, String seateName, String fundName, String securitiesId, Double price, Double num, int flag, Double commission, Double transfer, Double brokerage, Double stamp, Double management, Double netReceipts, Double totalSum, String settlementDate) {
        this.seateId = seateId;
        this.seateName = seateName;
        this.fundName = fundName;
        this.securitiesId = securitiesId;
        this.price = price;
        this.num = num;
        this.flag = flag;
        this.commission = commission;
        this.transfer = transfer;
        this.brokerage = brokerage;
        this.stamp = stamp;
        this.management = management;
        this.netReceipts = netReceipts;
        this.totalSum = totalSum;
        this.settlementDate = settlementDate;
    }

    public String getSeateId() {
        return seateId;
    }

    public void setSeateId(String seateId) {
        this.seateId = seateId;
    }

    public String getSeateName() {
        return seateName;
    }

    public void setSeateName(String seateName) {
        this.seateName = seateName;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
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

    public Double getTransfer() {
        return transfer;
    }

    public void setTransfer(Double transfer) {
        this.transfer = transfer;
    }

    public Double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Double brokerage) {
        this.brokerage = brokerage;
    }

    public Double getStamp() {
        return stamp;
    }

    public void setStamp(Double stamp) {
        this.stamp = stamp;
    }

    public Double getManagement() {
        return management;
    }

    public void setManagement(Double management) {
        this.management = management;
    }

    public Double getNetReceipts() {
        return netReceipts;
    }

    public void setNetReceipts(Double netReceipts) {
        this.netReceipts = netReceipts;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    @Override
    public String toString() {
        return "SeatSchedule{" +
                "seateId='" + seateId + '\'' +
                ", seateName='" + seateName + '\'' +
                ", fundName='" + fundName + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", flag=" + flag +
                ", commission=" + commission +
                ", transfer=" + transfer +
                ", brokerage=" + brokerage +
                ", stamp=" + stamp +
                ", management=" + management +
                ", netReceipts=" + netReceipts +
                ", totalSum=" + totalSum +
                ", settlementDate='" + settlementDate + '\'' +
                '}';
    }
}
