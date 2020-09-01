package com.ssaw.BusinessDescription.service.impl;

import com.ssaw.BusinessDescription.entity.Fund;
import com.ssaw.BusinessDescription.mapper.FundMapper;
import com.ssaw.BusinessDescription.service.FundService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by: 曾钦辉
 * description: 基金信息serviceImpl实现类
 * create time: 2020/9/1 9:50
 *
 * @Param: null
 * @return
 */
@Service
public class FundServiceImpl implements FundService {
    @Resource
    FundMapper fundMapper;

    /**
     * 增加serviceImpl方法
     *
     * @param fund
     * @return i
     */
    @Override
    public int insertFund(Fund fund) {
        int i = fundMapper.insertFund(fund);
        return i;
    }

    /**
     * 删除serviceImpl方法
     *
     * @param fundId
     */
    @Override
    public void deleteFund(int fundId) {
        fundMapper.deleteFund(fundId);

    }

    /**
     * 修改serviceImpl方法
     *
     * @param fund
     * @return i
     */
    @Override
    public int updateFund(Fund fund) {
        int i = fundMapper.updateFund(fund);
        return i;
    }

    /**
     * 查询serviceImpl方法
     *
     * @return fundList
     */
    @Override
    public List<Fund> selectFund() {
        List<Fund> fundList = fundMapper.selectFund();
        return fundList;
    }
}
