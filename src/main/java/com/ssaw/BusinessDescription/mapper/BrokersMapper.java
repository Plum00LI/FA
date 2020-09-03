package com.ssaw.BusinessDescription.mapper;

import com.ssaw.BusinessDescription.entity.Brokers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @program:TescComment
 * @Description:持久层
 * @author:邓玺中
 * @create:2020-09-01
 */
@Mapper
public interface BrokersMapper {
    /**
     * 查询
     *
     * @param map
     * @return
     */
    public void selectBrokers(Map map);

    /**
     * 删除
     *
     * @param brokersId
     * @return
     */
    public int deleteBrokers(String brokersId);

    /**
     * 添加
     *
     * @param brokers
     * @return
     */
    public int insertBrokers(Brokers brokers);

    /**
     * 修改
     *
     * @param brokersId
     * @return
     */
    public int updateBrokers(String brokersId);
}



