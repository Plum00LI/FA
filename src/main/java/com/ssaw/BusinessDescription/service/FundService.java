package com.ssaw.BusinessDescription.service;

import com.ssaw.BusinessDescription.entity.Fund;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by: 曾钦辉
 * description: 基金信息service接口
 * create time: 2020/9/1 9:48
 *
  * @Param: null
 * @return
 */
@Service
public interface FundService {
    /**
     * 增加基金信息
     * @param fund
     * @return int
     */
    int insertFund(Fund fund);
    /**
     * 删除基金信息
     * @param fundId
     */
    void deleteFund(int fundId);

    /**
     * 修改基金信息
     * @param fund
     * @return
     */
    int updateFund(Fund fund);
    /**
     * 查询基金信息
     * @param
     * @return List<Fund>
     */
    List<Fund> selectFund();
}