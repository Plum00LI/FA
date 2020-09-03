package com.ssaw.BusinessDescription.service;

import com.ssaw.BusinessDescription.entity.Securities;
import com.ssaw.BusinessDescription.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 债券参数
 * @type Securities的service类
 * @author fusaiying
 * @date 2020-09-01
 * @version 1.0
 */
public interface SecuritiesService {
    /**
     * 按条件查询 调用存储过程
     * @return 条件查询的集合
     */
    public Map<String,Object> selectSecurities(String pageSize, String page);
    /**
     * 增加
     * @param securities
     */
    public void insertSecurities(Securities securities);
    /**
     * 单个删除
     *根据证券编号 securitiesId
     */
    public void deleteSecurities(String securitiesId);
    /**
     * 修改
     * 根据证券编号 securitiesId
     */
    public void updateSecurities(Securities securities);

}
