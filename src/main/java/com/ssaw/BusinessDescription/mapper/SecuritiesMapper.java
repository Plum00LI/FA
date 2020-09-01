package com.ssaw.BusinessDescription.mapper;

import com.ssaw.BusinessDescription.entity.Securities;
import com.ssaw.BusinessDescription.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 债券参数
 * @type Securities的dao层
 * @author fusaiying
 * @date 2020-09-01
 * @version 1.0
 */
@Mapper
public interface SecuritiesMapper {
    /**
     * 查询所有
     */
    /**
     * 按条件查询
     * @return 条件查询的集合
     */
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
