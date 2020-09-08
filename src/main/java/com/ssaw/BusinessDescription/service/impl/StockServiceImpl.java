package com.ssaw.BusinessDescription.service.impl;

import com.ssaw.BusinessDescription.entity.Securities;
import com.ssaw.BusinessDescription.entity.Stock;
import com.ssaw.BusinessDescription.mapper.StockMapper;
import com.ssaw.BusinessDescription.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 股票板块
 * @type stock的service的实现类
 * @author fusaiying
 * @date 2020-09-01
 * @version 1.0
 */
@Service
public class StockServiceImpl implements StockService {

    @Resource
    StockMapper stockMapper;

    //查询
    @Override
    public List<Securities> selectStock() {
        return stockMapper.selectStock();
    }
    //查询
    @Override
    public List<Stock> selectSonStock() {
        return stockMapper.selectSonStock();
    }
//增加
    @Override
    public int insertStockParentMsg(Stock stock) {
        int i = stockMapper.insertStockParentMsg(stock);
        return i;
    }
//删除
    @Override
    public void deleteStock(String stockId) {
        stockMapper.deleteStock(stockId);
    }
//改值
    @Override
    public void updateStock(Stock stock) {
        stockMapper.updateStock(stock);
    }
}
