package com.ssaw.BusinessDescription.service;

import com.ssaw.BusinessDescription.entity.Brokers;

import java.util.Map;

/**
 * @program:TescComment
 * @Description:业务
 * @author:邓玺中
 * @create:2020-09-01
 */
public interface BrokersService {
    /**
     * 查询
     * @param pageSize
     * @param page
     * @return
     */
    //查询所有用户的服务类接口方法-待实现
    public Map<String,Object> selectBrokers(String pageSize,String page);

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
     * 删除
     *
     * @param brokersId
     * @return
     */
    public int updateBrokers(String brokersId);
}
