package com.ssaw.BusinessProcessing.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program:TescComment
 * @Description:实体类
 * @authod:洪彬峰
 * @create:2020-09-01
 */
@Service
public interface TaSettlementServise {
    /**
     * 查询
     */
    Map<String,Object> selectTatransaction(String pageSize, String page, String dateTime,String transactionType);
}
