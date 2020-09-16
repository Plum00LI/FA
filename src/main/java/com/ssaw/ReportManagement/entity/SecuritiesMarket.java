package com.ssaw.ReportManagement.entity;

/**
 * ClassName:    SecuritiesMarket
 * Package:    com.ssaw.ReportManagement.entity
 * Description: 证券市场变动表实体类
 * Version:
 * Datetime:    2020/9/16   14:51
 * Author:   SYT
 */
public class SecuritiesMarket {
    private String securitiesId;// 证券代码
    private String securitiesName;// 证券名称
    private Double securitiesNum;// 库存数量
    private Double price;// 单位成本
    private Double closingPrice;// 行情价格
    private Double mvcr;// 市值变动比
    private Double mvnv;// 市值占净值

    public SecuritiesMarket(){

    }

    public SecuritiesMarket(String securitiesId, String securitiesName, Double securitiesNum, Double price, Double closingPrice, Double mvcr, Double mvnv) {
        this.securitiesId = securitiesId;
        this.securitiesName = securitiesName;
        this.securitiesNum = securitiesNum;
        this.price = price;
        this.closingPrice = closingPrice;
        this.mvcr = mvcr;
        this.mvnv = mvnv;
    }

    @Override
    public String toString() {
        return "SecuritiesMarket{" +
                "securitiesId='" + securitiesId + '\'' +
                ", securitiesName='" + securitiesName + '\'' +
                ", securitiesNum=" + securitiesNum +
                ", price=" + price +
                ", closingPrice=" + closingPrice +
                ", mvcr=" + mvcr +
                ", mvnv=" + mvnv +
                '}';
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

    public Double getSecuritiesNum() {
        return securitiesNum;
    }

    public void setSecuritiesNum(Double securitiesNum) {
        this.securitiesNum = securitiesNum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(Double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public Double getMvcr() {
        return mvcr;
    }

    public void setMvcr(Double mvcr) {
        this.mvcr = mvcr;
    }

    public Double getMvnv() {
        return mvnv;
    }

    public void setMvnv(Double mvnv) {
        this.mvnv = mvnv;
    }
}
