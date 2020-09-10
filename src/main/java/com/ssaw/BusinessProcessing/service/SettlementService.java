package com.ssaw.BusinessProcessing.service;

import com.ssaw.BusinessProcessing.entity.Settlement;
import org.springframework.stereotype.Service;

import java.util.HashMap;
/**
 * create by: 曾钦辉
 * description: 交易结算Service
 * create time: 2020/9/10 9:31
 *
  * @Param: null
 * @return
 */
@Service
public interface SettlementService {
    /**
     * 查询交易数据
     * @return
     */
    HashMap selectSettlement(int page, int limit, String dateTime, String transactionDataMode,String status);
    int updateSettlement(Settlement settlement);
}
