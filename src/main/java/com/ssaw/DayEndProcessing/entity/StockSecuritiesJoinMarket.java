package com.ssaw.DayEndProcessing.entity;

public class StockSecuritiesJoinMarket {
    private String fundId;
    private String securitiesId;
    private Double totalPrice;
    private int securityPeriodFlag;

    public StockSecuritiesJoinMarket() {
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getSecurityPeriodFlag() {
        return securityPeriodFlag;
    }

    public void setSecurityPeriodFlag(int securityPeriodFlag) {
        this.securityPeriodFlag = securityPeriodFlag;
    }

    @Override
    public String toString() {
        return "StockSecuritiesJoinMarket{" +
                "fundId='" + fundId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", securityPeriodFlag='" + securityPeriodFlag + '\'' +
                '}';
    }
}
