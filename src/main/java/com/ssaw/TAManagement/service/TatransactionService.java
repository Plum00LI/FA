package com.ssaw.TAManagement.service;

import com.ssaw.TAManagement.entity.Tatransaction;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TA交易数据服务层接口
 * @type:service_interface
 * @version:v1.0
 * @authod:洪彬峰
 * @date:2020-09-01
 */
public interface TatransactionService {
    //查询
    public List<Tatransaction> selectTatransaction();
    //增加
    public int insertTatransaction(Tatransaction tatransaction);
    //删除
    public int  deleteTatransaction(int transactionId);
    //修改
    public int updateTatransaction(Tatransaction tatransaction);
}
