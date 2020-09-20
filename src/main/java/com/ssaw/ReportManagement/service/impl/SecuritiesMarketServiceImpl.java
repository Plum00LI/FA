package com.ssaw.ReportManagement.service.impl;

import com.ssaw.ReportManagement.entity.SecuritiesMarket;
import com.ssaw.ReportManagement.mapper.SecuritiesMarketMapper;
import com.ssaw.ReportManagement.service.SecuritiesMarketService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:    SecuritiesMarketServiceImpl
 * Package:    com.ssaw.ReportManagement.service.impl
 * Description:
 * Version:
 * Datetime:    2020/9/19   10:18
 * Author:   SYT
 */
public class SecuritiesMarketServiceImpl implements SecuritiesMarketService {

    @Resource
    SecuritiesMarketMapper securitiesMarketMapper;

    @Override
    public List<SecuritiesMarket> selectSecuritiesMarket(SecuritiesMarket securitiesMarket) {
        //创建List保持证券市场变动表信息
//        List<SecuritiesMarket> list=new ArrayList<>();
        //
        List<SecuritiesMarket> securitiesMarketList=securitiesMarketMapper.selectSecuritiesMarket(securitiesMarket);
        return null;
    }

    @Override
    public double selectProjectId(String dateTime, String fundId) {
        return 0;
    }
}
