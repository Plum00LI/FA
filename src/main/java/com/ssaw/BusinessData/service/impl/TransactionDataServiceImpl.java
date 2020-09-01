package com.ssaw.BusinessData.service.impl;

import com.ssaw.BusinessData.entity.TransactionData;
import com.ssaw.BusinessData.mapper.TransactionDataMapper;
import com.ssaw.BusinessData.service.TransactionDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * create by: 曾钦辉
 * description: 交易数据Service实现类
 * create time: 2020/9/1 11:26
 *
  * @Param: null
 * @return
 */
@Service
public class TransactionDataServiceImpl implements TransactionDataService {
    @Resource
    TransactionDataMapper transactionDataMapper;

    /**
     * 增加serviceImpl方法
     * @param transactionData
     * @return i
     */
    @Override
    public int insertTransactionData(TransactionData transactionData) {
        int i = transactionDataMapper.insertTransactionData(transactionData);
        return i ;
    }

    /**
     * 删除serviceImpl方法
     * @param tradeId
     */
    @Override
    public void deleteTransactionData(String tradeId) {
        transactionDataMapper.deleteTransactionData(tradeId);
    }

    /**
     * 修改serviceImpl方法
     * @param transactionData
     * @return i
     */
    @Override
    public int updateTransactionData(TransactionData transactionData) {
        int i = transactionDataMapper.updateTransactionData(transactionData);
        return i;
    }

    /**
     * 查询serviceImpl方法
     * @return transactionDataList
     */
    @Override
    public List<TransactionData> selectTransactionData() {
        List<TransactionData> transactionDataList = transactionDataMapper.selectTransactionData();
        return transactionDataList;
    }
}
