package com.ssaw.DayEndProcessing.entity;

/**
 * 债券计息实体类
 */
public class BondInterest {
    /* securitiesInventory and bond
    securitiesInventoryId Varchar2(50)                                not null,          *Varchar2(50)	PK 证券库存ID*
    dateTime varchar2(10)                                not null,                      *证券库存日期*
    securitiesId Varchar2(50)                                not null,        * 证券信息表ID，引用证券编号securitiesId，证券名securitiesName*
    fundId Varchar2(50)                                not null,                *基金表Id 印入基金代码*
    securityPeriodFlag Number(16,2)                                not null,         * 是否从其他系统导入的期初数据  0：不是  1：是*
    securitiesNum Number(16,2)                                not null,   *计算总金额条件 证券的数量*
    price Number(16,2)                                not null,                      *计算总金额条件 单位成本*
    total Number(16,2)                                not null,                      *证券数量*单位成本*
    securitiesInventoryDesc Varchar(50)                                                                    *备注*

    securitiesId            varchar2(50)        primary key         not null ,      -- 证券编号
    bondName                varchar2(50)                            not null ,      -- 债券名称
    drawStartDate           varchar2(12)                            not null ,      -- 计息起始日期
    drawEndDate             varchar2(12)                            not null ,      -- 计息结束日期
    bondType                number(1)                               not null ,      -- 债券类型  1=银行间  0=非银行间
    parRate                 number(16,4)                            not null ,      -- 票面利率
    bondRate                number(16,4)                            not null ,      -- 债券利息
    bondRateAmount          varchar2(50)                            not null ,      -- 票面金额
    payInterestNum          number(1)                               not null ,      -- 付息次数  1=1年一次  2=1年俩次 3=1年四次
    bondDesc                varchar2(12)                                            -- 备注
    */
    private String bondName;//债券名称
    private String securitiesId;//证券编号
    private int bondType;//债券类型  1=银行间  0=非银行间
    private String bondRateAmount;//票面金额
    private String dateTime;//证券库存日期
    private String drawStartDate;//计息起始日期
    private double bondRate;//债券利息
    private double securitiesNum;//证券的数量
    private double parRate;//票面利率
    private int payInterestNum;//付息次数

    public BondInterest() {
    }

}