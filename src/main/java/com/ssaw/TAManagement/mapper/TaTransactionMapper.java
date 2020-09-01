package com.ssaw.TAManagement.mapper;

import com.ssaw.TAManagement.entity.Tatransaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TA交易数据dao层接口
 * @type:Mapper_interface
 * @version:v1.0
 * @authod:洪彬峰
 * @date:2020-09-01
 */

@Mapper
public interface TaTransactionMapper {

    //查询
    public List<Tatransaction> selectTatransaction();
    //增加
    public int insertTatransaction(Tatransaction tatransaction);
    //删除
    public int deleteTatransaction(int transactionId);
    //修改
    public int updateTatransaction(Tatransaction tatransaction);
}
