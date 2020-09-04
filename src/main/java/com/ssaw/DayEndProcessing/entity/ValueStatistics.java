package com.ssaw.DayEndProcessing.entity;

/**
 * create by: 佘高鹏
 * description: TODO
 * create time: 2020/9/1 9:43
 * updata time: 2020/9/3 16:03
 * version number 2.0
  * @Param: 净值统计类
 * @return 
 */

/**
 * 表名	valueStatistics净值统计
 * 表字段	数据类型	表字段名称	备注
 * valueStatisticsDate varchar(50) 时间 主键
 * projectId	Number (5)	项目编号	主键 体现层次分级关系/例如股票
 * projectName	varchar(50)	项目名称	例如证券
 * projectCode	varchar(50)	项目代码/账户号
 * quantityint	varchar(50)	股数		证券库存统计
 * peice	varchar(50)	行情		行情数据
 * cost	varchar(50)	成本		资产估值
 * marketValue	varchar(50)	市值
 * valuation	varchar(50)	估值增值
 * projectFatherId	Number (5)	父项目编号	体现层次分级关系/例如证券
 */
public class ValueStatistics {
    private String valueStatisticsDate;
    private int projectId;
    private String projectName;
    private String projectCode;
    private String quantityint;
    private String peice;
    private String cost;
    private String marketValue;
    private String valuation;
    private int projectFatherId;


    public ValueStatistics() {
    }

    public ValueStatistics( int projectId, String projectName, String projectCode, String quantityint, String peice, String cost, String marketValue, String valuation, int projectFatherId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.quantityint = quantityint;
        this.peice = peice;
        this.cost = cost;
        this.marketValue = marketValue;
        this.valuation = valuation;
        this.projectFatherId = projectFatherId;
    }


    public ValueStatistics(String valueStatisticsDate, int projectId, String projectName, String projectCode, String quantityint, String peice, String cost, String marketValue, String valuation, int projectFatherId) {
        this.valueStatisticsDate = valueStatisticsDate;
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.quantityint = quantityint;
        this.peice = peice;
        this.cost = cost;
        this.marketValue = marketValue;
        this.valuation = valuation;
        this.projectFatherId = projectFatherId;
    }

    public String getValueStatisticsDate() {
        return valueStatisticsDate;
    }

    public void setValueStatisticsDate(String valueStatisticsDate) {
        this.valueStatisticsDate = valueStatisticsDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getQuantity() {
        return quantityint;
    }

    public void setQuantity(String quantityint) {
        this.quantityint = quantityint;
    }

    public String getPeice() {
        return peice;
    }

    public void setPeice(String peice) {
        this.peice = peice;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getValuation() {
        return valuation;
    }

    public void setValuation(String valuation) {
        this.valuation = valuation;
    }

    public int getProjectFatherId() {
        return projectFatherId;
    }

    public void setProjectFatherId(int projectFatherId) {
        this.projectFatherId = projectFatherId;
    }

    @Override
    public String toString() {
        return "ValueStatistics{" +
                "valueStatisticsDate='" + valueStatisticsDate + '\'' +
                ", projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", quantityint='" + quantityint + '\'' +
                ", peice='" + peice + '\'' +
                ", cost='" + cost + '\'' +
                ", marketValue='" + marketValue + '\'' +
                ", valuation='" + valuation + '\'' +
                ", projectFatherId=" + projectFatherId +
                '}';
    }
}
