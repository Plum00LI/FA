package com.ssaw.BusinessDescription.service.impl;

import com.ssaw.BusinessDescription.entity.Securities;
import com.ssaw.BusinessDescription.entity.Stock;
import com.ssaw.BusinessDescription.service.SecuritiesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 债券参数
 * @type Securities的service的实现类
 * @author fusaiying
 * @date 2020-09-01
 * @version 1.0
 */
@Service
public class SecuritiesServiceImpl implements SecuritiesService {
    @Resource
    SecuritiesService securitiesService;

    @Override
    public List<Securities> selectSecurities() {
        return securitiesService.selectSecurities();
    }

    @Override
    public void insertSecurities(Securities securities) {
        securitiesService.insertSecurities(securities);
    }

    @Override
    public void deleteSecurities(String securitiesId) {
        securitiesService.deleteSecurities(securitiesId);
    }

    @Override
    public void updateSecurities(Securities securities) {
        securitiesService.updateSecurities(securities);
    }
}
