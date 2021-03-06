package com.ssaw.BusinessProcessing.mapper;

import com.ssaw.BusinessProcessing.entity.TaSettlement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @program:TescComment
 * @Description:实体类
 * @authod:洪彬峰
 * @create:2020-09-01
 */
@Mapper
public interface TaSettlementMapper {
    /**
     * 查询
     */
    void selectTaSettlement(Map map);
    /*
    修改
     */
    public int updateTaSettlement(int Status,String taTransactionId);
    public int updateTaSettlementTwo(int Status,String taTransactionId);
}
