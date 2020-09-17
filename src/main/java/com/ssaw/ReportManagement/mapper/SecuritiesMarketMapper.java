package com.ssaw.ReportManagement.mapper;

import com.ssaw.ReportManagement.entity.SecuritiesMarket;

import java.util.List;

/**
 * ClassName:    SecuritiesMarketMapper
 * Package:    com.ssaw.ReportManagement.mapper
 * Description: 证券市场变动表
 * Version:
 * Datetime:    2020/9/17   11:44
 * Author:   SYT
 */
public interface SecuritiesMarketMapper {

    public List<SecuritiesMarket> selectSecuritiesMarket(SecuritiesMarket securitiesMarket);
}
