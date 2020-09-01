package com.ssaw.BusinessData.service;

import com.ssaw.BusinessData.entity.EquityData;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:权益数据模块
 * @Description:Biz层接口
 * @author:孙浩
 * @create:2020-09-01
 */
public interface EquityDataService {
    public int insertTransactionData(EquityData transactionData);
    public void deleteTransactionData(int equityId);
    public int updateTransactionData(EquityData transactionData);
    public List<EquityData> selectTransactionData();
}
