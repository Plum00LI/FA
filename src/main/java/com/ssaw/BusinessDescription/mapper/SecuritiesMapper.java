package com.ssaw.BusinessDescription.mapper;

import com.ssaw.BusinessDescription.entity.Securities;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

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
     * 按条件查询 分页查询
     * @return 条件查询的集合
     */
    public void selectSecurities(Map map);
    /**
     * 增加
     * @param securities
     */
    public int insertSecurities(Securities securities);
    /**
     * 删除
     *根据证券编号 securitiesId
     * @param securitiesId
     */
    public void deleteSecurities(String securitiesId);
    /**
     * 修改
     * 根据证券编号
     */
    public int updateSecurities(Securities securities);

}
