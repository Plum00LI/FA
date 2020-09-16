package com.ssaw.DayEndProcessing.entity;

/**
 * 两费计息实体类
 */
public class TwoFeeInterest {
    /*valueStatistics and fund
       fundId              varchar2(50)            primary key             not null ,          -- 基金代码
    fundName            varchar2(50)                                    not null ,          -- 基金名称
    fundType            number(1)                                       not null ,          -- 1 - 开放式基金  2 - 封闭式基金
    managerId           varchar2(50)                                    not null ,          -- 管理人ID
    trusteeBlank        varchar2(50)                                    not null ,          -- 托管人ID
    initNetWorth        number(16,4)                                    not null ,          -- 初始净值
    sizeOfThe           number(16,4)                                    not null ,          -- 基金规模
    managerRate         number(16,4)                                    not null ,          -- 管理人费率 年利率 ？/100
    hostingRate         number(16,4)                                    not null ,          -- 托管人费率 年利率 ？/100
    provisionDays       number(1)                                       not null ,          -- 1 - 360天  2 - 365天  3 - 366天
    setUpDate           varchar2(12)                                    not null ,          -- 基金成立时间
    fundDesc            varchar2(100)                                            ,          -- 备注
    accountId           varchar2(50)                                    not null            -- 账户信息表

    valueStatisticsDate         varchar2(12)        primary key         not null ,      -- 净值统计日期
    valueStatisticsId           varchar2(50)                            not null ,      -- 库存编号
    projectId                   varchar2(50)                            not null ,      -- 项目编号
    projectName                 varchar2(50)                            not null ,      -- 项目名称
    projectCode                 varchar2(50)                            not null ,      -- 项目代码/账户号
    quantity                    number(12)                              not null ,      -- 股数
    peice                       number(16,4)                            not null ,      -- 行情
    cost                        number(16,4)                            not null ,      -- 成本
    marketValue                 number(16,4)                            not null ,      -- 市值
    valuation                   number(16,4)                            not null ,      -- 估值增值
    projectFatherId             varchar2(50)                            not null ,      -- 父项目编号
    relation                    varchar2(50)                            not null ,      -- 项目关系
    appreciationSum             number(16,4)                            not null ,      -- 合计估值增值
    liabilities                 number(16,4)                            not null ,      -- 总负债
    propertySum                 number(16,4)                            not null ,      -- 资产合计
    propertyNetWorth            number(16,4)                            not null ,      -- 资产净值
    unitNetWorth                number(16,4)                            not null        -- 单位净值
     */
    private String fundName;//基金名称
    private String fundId;//基金代码
    private double managerRate;//管理人费率
    private double hostingRate;//托管人费率
    private double propertyNetWorth;//资产净值
    private String dateTime;//业务日期
    private String managerMoney;//管理费利息
    private String hostingMoney;//托管费利息

    public TwoFeeInterest() {
    }

    public TwoFeeInterest(String fundName, String fundId, double managerRate, double hostingRate, double propertyNetWorth, String dateTime, String managerMoney, String hostingMoney) {
        this.fundName = fundName;
        this.fundId = fundId;
        this.managerRate = managerRate;
        this.hostingRate = hostingRate;
        this.propertyNetWorth = propertyNetWorth;
        this.dateTime = dateTime;
        this.managerMoney = managerMoney;
        this.hostingMoney = hostingMoney;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public double getManagerRate() {
        return managerRate;
    }

    public void setManagerRate(double managerRate) {
        this.managerRate = managerRate;
    }

    public double getHostingRate() {
        return hostingRate;
    }

    public void setHostingRate(double hostingRate) {
        this.hostingRate = hostingRate;
    }

    public double getPropertyNetWorth() {
        return propertyNetWorth;
    }

    public void setPropertyNetWorth(double propertyNetWorth) {
        this.propertyNetWorth = propertyNetWorth;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getManagerMoney() {
        return managerMoney;
    }

    public void setManagerMoney(String managerMoney) {
        this.managerMoney = managerMoney;
    }

    public String getHostingMoney() {
        return hostingMoney;
    }

    public void setHostingMoney(String hostingMoney) {
        this.hostingMoney = hostingMoney;
    }

    @Override
    public String toString() {
        return "TwoFeeInterest{" +
                "fundName='" + fundName + '\'' +
                ", fundId='" + fundId + '\'' +
                ", managerRate=" + managerRate +
                ", hostingRate=" + hostingRate +
                ", propertyNetWorth=" + propertyNetWorth +
                ", dateTime='" + dateTime + '\'' +
                ", managerMoney='" + managerMoney + '\'' +
                ", hostingMoney='" + hostingMoney + '\'' +
                '}';
    }
}
