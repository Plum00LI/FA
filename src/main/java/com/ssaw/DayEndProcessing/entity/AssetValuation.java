package com.ssaw.DayEndProcessing.entity;


/**
 *@program: FA
 *@description: 资产估值实体类
 *@author: 瞿平
 *@create: 2020-09-08 11:25
 **/
public class AssetValuation {
    private String dateTime;//估值日期
    private String securitiesId;//证券编号
    private Integer securitiesType;//证券类型
    private Double closingPrice;//股市收盘价格
    private Integer securitiesNum;//证券购买的数量
    private Double price;//单位成本
    private Double total;//购买的总价格
    private String fundId;//基金编号
    private Double appraisementVal;//资产估值
}
