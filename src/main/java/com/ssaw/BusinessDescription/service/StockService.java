package com.ssaw.BusinessDescription.service;

import com.ssaw.BusinessDescription.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 股票板块
 * @type stock的service类
 * @author fusaiying
 * @date 2020-09-01
 * @version 1.0
 */

@Service
public interface StockService {
    /**
     * 查询所有
     */
    public List<Stock> selectStock();
    /**
     * 增加父类
     * @param stock
     */
    public void insertStockParentMsg(Stock stock);
    /**
     * 根据父类查子类
     */
    public List<Stock> selectSonStock(String stockId);
    /**
    /**
     * 增加子类
     * @param stock
     */
    public void insertStockSonMsg(Stock stock);
    /**
     * 单个删除
     * 根据板块编号 stockId
     */
    public void deleteStock(String stockId);
    /**
     * 修改
     * 根据板块编号 stockId
     */
    public void updateStock(Stock stock);
}
