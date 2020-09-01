package com.ssaw.BusinessData.mapper;

import com.ssaw.BusinessData.entity.EquityData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program:权益数据模块
 * @Description:Dao层接口
 * @author:孙浩
 * @create:2020-09-01
 */

@Mapper
public interface EquityDataMapper {
    public int insertTransactionData(EquityData transactionData);
    public void deleteTransactionData(int equityId);
    public int updateTransactionData(EquityData transactionData);
    public List<EquityData> selectTransactionData();
}