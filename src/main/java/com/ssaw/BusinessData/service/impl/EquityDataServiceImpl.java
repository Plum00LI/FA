package com.ssaw.BusinessData.service.impl;


import com.ssaw.BusinessData.entity.EquityData;
import com.ssaw.BusinessData.mapper.EquityDataMapper;
import com.ssaw.BusinessData.service.EquityDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program:权益数据模块
 * @Description:实现类
 * @author:孙浩
 * @create:2020-09-01
 */
@Service
public class EquityDataServiceImpl implements EquityDataService {
    @Resource
    EquityDataMapper equityDataMapper;

    @Override
    public int insertTransactionData(EquityData transactionData) {
        return equityDataMapper.insertTransactionData(transactionData);
    }

    @Override
    public void deleteTransactionData(int equityId) {
        equityDataMapper.deleteTransactionData(equityId);
    }

    @Override
    public int updateTransactionData(EquityData transactionData) {
        return equityDataMapper.updateTransactionData(transactionData);
    }

    @Override
    public List<EquityData> selectTransactionData() {
        return equityDataMapper.selectTransactionData();
    }
}
