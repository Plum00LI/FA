package com.ssaw.BusinessDescription.service;

import com.ssaw.BusinessDescription.entity.VarietiesRate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 交易所品种费率 的service层
 * @type:VarietiesRateService
 * @version v1.0
 * @author:阙魁
 * @create:2020-09-01
 */
@Service
@Transactional
public interface VarietiesRateService {
    //查询与分页查询
    public Map<String,Object> selectVarietiesRate(String pageSize,String page);
    //删除
    public void deleteVarietiesRate(int exchangeName,int rateType);
    //增加
    public int insertVarietiesRate(VarietiesRate varietiesRate);
    //修改
    public int updateVarietiesRate(VarietiesRate varietiesRate);
}
