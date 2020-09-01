package com.ssaw.BusinessData.service;

import com.ssaw.BusinessData.entity.Market;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@program: TescComment
*@Description:行情数据Biz类
*@author: 瞿平
*@version:1.0
*@create: 2020-09-01
*/
@Service
public interface MarketService {
    /**
     * 查询
     * @return 返回一个集合
     */
    public List<Market> selectMarket();

    /**
     * 增加
     * @return 返回一个int类型的参数
     */
    public int insertMarket(Market market);

    /**
     * 删除
     * @return 返回一个int类型的参数
     */
    public int deleteMarket(int marketId);

    /**
     * 修改
     * @return 返回一个int类型的参数
     */
    public int updateMarket(Market market);
}
