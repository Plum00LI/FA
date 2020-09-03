package com.ssaw.BusinessData.entity;

/**
 * @program:权益数据模块
 * @Description:实体类
 * @author:孙浩
 * @create:2020-09-01
 */
public class EquityData {
    private String equityId;//权益ID（隐藏字段）
    private String dateTime;//业务日期
    private int securityId;//证券Id
    private String securityName;//证券名称
    private String equitiesRecord;//权益登记日
    private String equitiesExright;//权益除权日
    private String receivedDate;//到账日期
    private int equitiesType;//权益类型  1.送股   2.分红
    private int proportion;//比例
    private int disposeStatus;//处理状态   0.未处理   1.已处理

    public EquityData() {
    }

    public EquityData(String equityId, String dateTime, int securityId, String securityName, String equitiesRecord,
                      String equitiesExright, String receivedDate, int equitiesType, int proportion, int disposeStatus) {
        this.equityId = equityId;
        this.dateTime = dateTime;
        this.securityId = securityId;
        this.securityName = securityName;
        this.equitiesRecord = equitiesRecord;
        this.equitiesExright = equitiesExright;
        this.receivedDate = receivedDate;
        this.equitiesType = equitiesType;
        this.proportion = proportion;
        this.disposeStatus = disposeStatus;
    }

    public String getEquityId() {
        return equityId;
    }

    public void setEquityId(String equityId) {
        this.equityId = equityId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getSecurityId() {
        return securityId;
    }

    public void setSecurityId(int securityId) {
        this.securityId = securityId;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getEquitiesRecord() {
        return equitiesRecord;
    }

    public void setEquitiesRecord(String equitiesRecord) {
        this.equitiesRecord = equitiesRecord;
    }

    public String getEquitiesExright() {
        return equitiesExright;
    }

    public void setEquitiesExright(String equitiesExright) {
        this.equitiesExright = equitiesExright;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public int getEquitiesType() {
        return equitiesType;
    }

    public void setEquitiesType(int equitiesType) {
        this.equitiesType = equitiesType;
    }

    public int getProportion() {
        return proportion;
    }

    public void setProportion(int proportion) {
        this.proportion = proportion;
    }

    public int getDisposeStatus() {
        return disposeStatus;
    }

    public void setDisposeStatus(int disposeStatus) {
        this.disposeStatus = disposeStatus;
    }

    @Override
    public String toString() {
        return "权益数据模块{" +
                "权益ID=" + equityId +
                ", 业务日期='" + dateTime + '\'' +
                ", 证券ID=" + securityId +
                ", 证券名称='" + securityName + '\'' +
                ", 登记日='" + equitiesRecord + '\'' +
                ", 除权日='" + equitiesExright + '\'' +
                ", 到账日='" + receivedDate + '\'' +
                ", 权益类型=" + equitiesType +
                ", 比例=" + proportion +
                ", 处理状态=" + disposeStatus +
                '}';
    }
}
