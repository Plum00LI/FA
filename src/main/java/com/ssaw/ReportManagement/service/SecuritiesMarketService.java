package com.ssaw.ReportManagement.service;

import com.ssaw.ReportManagement.entity.SecuritiesMarket;

import java.util.List;

/**
 * ClassName:    SecuritiesMarketService
 * Package:    com.ssaw.ReportManagement.service
 * Description:     证券市场变动报表
 * Version:
 * Datetime:    2020/9/19   10:16
 * Author:   SYT
 */
public interface SecuritiesMarketService {
    public List<SecuritiesMarket> selectSecuritiesMarket(SecuritiesMarket securitiesMarket);

    public double selectProjectId(String dateTime,String fundId);
}
