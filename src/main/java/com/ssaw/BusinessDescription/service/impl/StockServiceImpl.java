package com.ssaw.BusinessDescription.service.impl;

import com.ssaw.BusinessDescription.entity.Stock;
import com.ssaw.BusinessDescription.mapper.StockMapper;
import com.ssaw.BusinessDescription.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Stock> selectStock() {
        return stockMapper.selectStock();
    }

    @Override
    public List<Stock> selectSonStock(String stockId) {
        return stockMapper.selectSonStock(stockId);
    }

    @Override
    public void insertStockParentMsg(Stock stock) {
        stockMapper.insertStockParentMsg(stock);
    }

    @Override
    public void insertStockSonMsg(Stock stock) {
        stockMapper.insertStockSonMsg(stock);
    }

    @Override
    public void deleteStock(String stockId) {
        stockMapper.deleteStock(stockId);
    }

    @Override
    public void updateStock(Stock stock) {
        stockMapper.updateStock(stock);
    }
}
