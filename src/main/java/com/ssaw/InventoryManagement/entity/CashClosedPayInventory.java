package com.ssaw.InventoryManagement.entity;

/**
 * @program:现金应收应付库存模块
 * @Description:实体类
 * @author:孙浩
 * @create:2020-09-01
 */

public class CashClosedPayInventory {
    private String crcsId;//现金应收应付库存Id（隐藏字段）
    private String businessDate;//业务日期
    private String cashAccountName;//现金账户名称
    private String fundId;//基金ID（隐藏字段）
    private String fundName;//基金名称（隐藏字段）
    private int businessType;//业务类型  1.管理费  2.托管费  3.存款利息  4.申购赎回费
    private int businessStatus;//业务状态   1.流入  -1.流出
    private int initialSigns;//期初标志  1.是   0.否
    private double toalMoney;//总金额

    public CashClosedPayInventory() {
    }

    public CashClosedPayInventory(String crcsId, String businessDate, String cashAccountName, String fundId, String fundName,
                                  int businessType, int businessStatus, int initialSigns, double toalMoney) {
        this.crcsId = crcsId;
        this.businessDate = businessDate;
        this.cashAccountName = cashAccountName;
        this.fundId = fundId;
        this.fundName = fundName;
        this.businessType = businessType;
        this.businessStatus = businessStatus;
        this.initialSigns = initialSigns;
        this.toalMoney = toalMoney;
    }

    public String getCrcsId() {
        return crcsId;
    }

    public void setCrcsId(String crcsId) {
        this.crcsId = crcsId;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public String getCashAccountName() {
        return cashAccountName;
    }

    public void setCashAccountName(String cashAccountName) {
        this.cashAccountName = cashAccountName;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public int getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(int businessStatus) {
        this.businessStatus = businessStatus;
    }

    public int getInitialSigns() {
        return initialSigns;
    }

    public void setInitialSigns(int initialSigns) {
        this.initialSigns = initialSigns;
    }

    public double getToalMoney() {
        return toalMoney;
    }

    public void setToalMoney(double toalMoney) {
        this.toalMoney = toalMoney;
    }

    @Override
    public String toString() {
        return "现金应收应付库存模块{" +
                "现金应收应付库存ID='" + crcsId + '\'' +
                ", 业务日期='" + businessDate + '\'' +
                ", 现金账户名称='" + cashAccountName + '\'' +
                ", 基金ID=" + fundId +
                ", 基金名称='" + fundName + '\'' +
                ", 业务类型=" + businessType +
                ", 业务状态=" + businessStatus +
                ", 期初标志=" + initialSigns +
                ", 总金额=" + toalMoney +
                '}';
    }
}
