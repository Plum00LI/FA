package com.ssaw.BusinessProcessing.mapper;

import com.ssaw.BusinessProcessing.entity.Settlement;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
/**
 * create by: 曾钦辉
 * description: 交易结算Mapper类
 * create time: 2020/9/10 9:30
 *
  * @Param: null
 * @return
 */
@Mapper
public interface SettlementMapper {
    /**
     * 查询交易数据
     * @return
     */
    void selectSettlement(HashMap hashMap);

    /**
     *
     * @param transactionDataId
     * @return
     */
    public int deleteSettlement(String transactionDataId);

    /**
     *
     * @param status
     * @param transactionDataId
     * @return
     */
    public int updateSettlement(int status,String transactionDataId);

    /**
     *
     * @param status
     * @param transactionDataId
     * @return
     */
    public int updateSettlementTwo(int status,String transactionDataId);
}
