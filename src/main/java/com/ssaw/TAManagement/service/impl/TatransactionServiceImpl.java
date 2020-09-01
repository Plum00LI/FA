package com.ssaw.TAManagement.service.impl;

import com.ssaw.TAManagement.entity.Tatransaction;
import com.ssaw.TAManagement.mapper.TaTransactionMapper;
import com.ssaw.TAManagement.service.TatransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * TA交易数据实现类
 * @type:TatransactionServiceImpl
 * @version:v1.0
 * @authod:洪彬峰
 * @date:2020-09-01
 */

@Service
public class TatransactionServiceImpl implements TatransactionService{
    @Resource
    TaTransactionMapper tatransactionMapper;

    @Override
    public List<Tatransaction> selectTatransaction() {
        return tatransactionMapper.selectTatransaction();
    }

    @Override
    public int insertTatransaction(Tatransaction tatransaction) {
        int msg = tatransactionMapper.insertTatransaction(tatransaction);
        return msg;
    }

    @Override
    public int deleteTatransaction(int transactionId) {
        int a  = tatransactionMapper.deleteTatransaction(transactionId);
        return a;
    }

    @Override
    public int updateTatransaction(Tatransaction tatransaction) {
        int i = tatransactionMapper.updateTatransaction(tatransaction);
        return i;
    }
}
