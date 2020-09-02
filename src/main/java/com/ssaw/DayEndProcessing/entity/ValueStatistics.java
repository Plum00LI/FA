package com.ssaw.DayEndProcessing.entity;

/**
 * create by: 佘高鹏
 * description: TODO
 * create time: 2020/9/1 9:43
 * version number 1.0
  * @Param: 净值统计类
 * @return 
 */

/**
 * 表名	valueStatistics净值统计
 * 表字段	数据类型	表字段名称	备注	模块名	关系人
 * valueStatisticsId	varchar(50)	库存编号/ID列
 * projectId	varchar(50)	项目编号	体现层次分级关系/例如股票
 * projectName	varchar(50)	项目名称	例如证券	证券库存统计	瞿萍
 * projectCode	varchar(50)	项目代码/账户号		证券库存统计	瞿萍
 * quantity	Number(12)	股数		证券库存统计	瞿萍
 * peice	Number(14,2)	行情		行情数据	瞿萍
 * cost	Number(12,3)	成本		资产估值	瞿萍
 * marketValue	Number(12,3)	市值		资产估值	瞿萍
 * valuation	Number(6,3)	估值增值		资产估值	瞿萍
 * projectFatherId	varchar(50)	父项目编号	体现层次分级关系/例如证券
 * relation	varchar(50)	项目关系	父子关系，例如证券为父，股票为子
 * appreciationSum	Number(12,3)	合计估值增值	可要可不要，有待确定/如果分别实现统计和查询，会方便一点	页面增值合计
 * liabilities	Number(12,3)	总负债	可要可不要，有待确定/如果分别实现统计和查询，会方便一点	页面总负债
 * propertySum	Number(14,2)	资产合计	可要可不要，有待确定/如果分别实现统计和查询，会方便一点	未计算负债时总资产
 * propertyNetWorth	Number(14,2)	资产净值
 * unitNetWorth	Number(14,2)	单位净值
 * valueStatisticsDate	varchar(50)	统计日期	主键
 */
public class ValueStatistics {
    private String valueStatisticsDate;
    private String valueStatisticsId;
    private String projectId;
    private String projectName;
    private String projectCode;
    private int quantity;
    private int peice;
    private int cost;
    private int marketValue;
    private int valuation;
    private String projectFatherId;
    private String relation;
    private int appreciationSum;
    private int liabilities;
    private int propertySum;
    private int propertyNetWorth;
    private int unitNetWorth;

    public ValueStatistics() {
    }

    public ValueStatistics(String valueStatisticsDate, String valueStatisticsId, String projectId, String projectName, String projectCode, int quantity, int peice, int cost, int marketValue, int valuation, String projectFatherId, String relation, int appreciationSum, int liabilities, int propertySum, int propertyNetWorth, int unitNetWorth) {
        this.valueStatisticsDate = valueStatisticsDate;
        this.valueStatisticsId = valueStatisticsId;
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.quantity = quantity;
        this.peice = peice;
        this.cost = cost;
        this.marketValue = marketValue;
        this.valuation = valuation;
        this.projectFatherId = projectFatherId;
        this.relation = relation;
        this.appreciationSum = appreciationSum;
        this.liabilities = liabilities;
        this.propertySum = propertySum;
        this.propertyNetWorth = propertyNetWorth;
        this.unitNetWorth = unitNetWorth;
    }

    public String getValueStatisticsDate() {
        return valueStatisticsDate;
    }

    public void setValueStatisticsDate(String valueStatisticsDate) {
        this.valueStatisticsDate = valueStatisticsDate;
    }

    public String getValueStatisticsId() {
        return valueStatisticsId;
    }

    public void setValueStatisticsId(String valueStatisticsId) {
        this.valueStatisticsId = valueStatisticsId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPeice() {
        return peice;
    }

    public void setPeice(int peice) {
        this.peice = peice;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    public int getValuation() {
        return valuation;
    }

    public void setValuation(int valuation) {
        this.valuation = valuation;
    }

    public String getProjectFatherId() {
        return projectFatherId;
    }

    public void setProjectFatherId(String projectFatherId) {
        this.projectFatherId = projectFatherId;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getAppreciationSum() {
        return appreciationSum;
    }

    public void setAppreciationSum(int appreciationSum) {
        this.appreciationSum = appreciationSum;
    }

    public int getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(int liabilities) {
        this.liabilities = liabilities;
    }

    public int getPropertySum() {
        return propertySum;
    }

    public void setPropertySum(int propertySum) {
        this.propertySum = propertySum;
    }

    public int getPropertyNetWorth() {
        return propertyNetWorth;
    }

    public void setPropertyNetWorth(int propertyNetWorth) {
        this.propertyNetWorth = propertyNetWorth;
    }

    public int getUnitNetWorth() {
        return unitNetWorth;
    }

    public void setUnitNetWorth(int unitNetWorth) {
        this.unitNetWorth = unitNetWorth;
    }

    @Override
    public String toString() {
        return "ValueStatistics{" +
                "valueStatisticsDate='" + valueStatisticsDate + '\'' +
                ", valueStatisticsId='" + valueStatisticsId + '\'' +
                ", projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", quantity=" + quantity +
                ", peice=" + peice +
                ", cost=" + cost +
                ", marketValue=" + marketValue +
                ", valuation=" + valuation +
                ", projectFatherId='" + projectFatherId + '\'' +
                ", relation='" + relation + '\'' +
                ", appreciationSum=" + appreciationSum +
                ", liabilities=" + liabilities +
                ", propertySum=" + propertySum +
                ", propertyNetWorth=" + propertyNetWorth +
                ", unitNetWorth=" + unitNetWorth +
                '}';
    }
}
