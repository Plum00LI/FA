package com.ssaw.BusinessData.service.impl;/**
 * @program: TescComment
 * @Description:实体类
 * @author: 瞿平
 * @create: 2020-09-01
 */

import com.ssaw.BusinessData.entity.Market;
import com.ssaw.BusinessData.mapper.MarketMapper;
import com.ssaw.BusinessData.service.MarketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*@program: TescComment
*@Description:行情数据实现类
*@author: 瞿平
*@version:1.0
*@create: 2020-09-01
*/
@Service
public class MarketServiceImpl implements MarketService {
    @Resource
    MarketMapper marketMapper;


    @Override
    public List<Market> selectMarket() {
        return marketMapper.selectMarket();
    }

    @Override
    public int insertMarket(Market market) {
        return marketMapper.insertMarket(market);
    }

    @Override
    public int deleteMarket(int marketId) {
        return marketMapper.deleteMarket(marketId);
    }

    @Override
    public int updateMarket(Market market) {
        return marketMapper.updateMarket(market);
    }
}
