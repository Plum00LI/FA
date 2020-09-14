package com.ssaw.DayEndProcessing.service.impl;

import com.ssaw.DayEndProcessing.entity.SecuritiesValueStatistics;
import com.ssaw.DayEndProcessing.mapper.SecuritiesValueStatisticsMapper;
import com.ssaw.DayEndProcessing.service.SecuritiesValueStatisticsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * create by: 佘高鹏
 * description: TODO
 * 证券净值统计查询业务层实现类
 * create time: 2020/9/11 17:09
 * version number 1.0
  * @Param: null
 * @return
 */
@Service
@Transactional
public class SecuritiesValueStatisticsServiceImpl implements SecuritiesValueStatisticsService {
    @Resource
    SecuritiesValueStatisticsMapper ecuritiesValueStatisticsMapper;

    @Override
    public List<SecuritiesValueStatistics> selectSecuritiesValueStatistics(String dateTime, String fundID, String dateTimeTwo,int type) {

        return ecuritiesValueStatisticsMapper.selectSecuritiesValueStatistics(dateTime,fundID,dateTimeTwo,type);
    }

    @Override
    public List<SecuritiesValueStatistics> selectSecuritiesValueStatisticsTwo(String dateTime, String fundID, String dateTimeTwo, int type, int typeTwo) {
        return ecuritiesValueStatisticsMapper.selectSecuritiesValueStatisticsTwo(dateTime,fundID,dateTimeTwo,type,typeTwo);
    }
}