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
