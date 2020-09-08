package com.ssaw.BusinessDescription.entity;

/**
 * 现金计息实体类
 */
public class CashInterest {
    /*
    accountId           varchar2(50)        primary key         not null ,      -- 现金账户Id
    fundId                      varchar2(50)                                not null ,      -- 基金信息表Id
    cashInventoryId             Varchar2(50)                                not null ,               主键现金库存 C202008310001
    blankName           varchar2(50)                            not null ,      -- 银行名称
    accountName         varchar2(50)                            not null ,      -- 账户名称
    deposit             number(1)                               not null ,      -- 存款类型 1代表活期 2代表定期
    cardRate            number(16,4)                            not null ,      -- 卡号利率 ?/100 年利率
    procisionDays       number(1)                               not null ,      -- 计息期间 1代表360  2代表365天 3代表366天
    openTime            varchar2(12)                            not null ,      -- 开户时间
    cashBlance 	                Number(16,4)                                not null ,                   现金余额
    dateTime                    varchar2(10)                                not null ,                      统计日期
    */
}
