package com.ssaw.BusinessDescription.service.impl;

import com.ssaw.BusinessDescription.entity.VarietiesRate;
import com.ssaw.BusinessDescription.mapper.VarietiesRateMapper;
import com.ssaw.BusinessDescription.service.VarietiesRateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 交易所品种费率 的impl层
 * @type:VarietiesRateServiceImpl
 * @version v1.0
 * @author:阙魁
 * @create:2020-09-01
 */
@Service
public class VarietiesRateServiceImpl implements VarietiesRateService {

    @Resource
    VarietiesRateMapper varietiesRateMapper;
    //查询
    @Override
    public List<VarietiesRate> selectVarietiesRate() {
        return varietiesRateMapper.selectVarietiesRate();
    }
    //删除
    @Override
    public void deleteVarietiesRate(int exchangeNameId, int rateTypeId) {
        varietiesRateMapper.deleteVarietiesRate(exchangeNameId, rateTypeId);
    }
    //增加
    @Override
    public int insertVarietiesRate(VarietiesRate varietiesRate) {
        int i=varietiesRateMapper.insertVarietiesRate(varietiesRate);
        return i;
    }
    //修改
    @Override
    public int updateVarietiesRate(VarietiesRate varietiesRate) {
        int i=varietiesRateMapper.updateVarietiesRate(varietiesRate);
        return i;
    }
}
