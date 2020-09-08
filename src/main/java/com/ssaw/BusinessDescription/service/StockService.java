package com.ssaw.BusinessDescription.service;

import com.ssaw.BusinessDescription.entity.Securities;
import com.ssaw.BusinessDescription.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public List<Securities> selectStock();
    /**
     * 增加父类
     * @param stock
     */
    public int insertStockParentMsg(Stock stock);
    /**
     * 查子类
     */
    public List<Stock> selectSonStock();
    /**
    /**
     * 根据板块编号 stockId
     */
    public void deleteStock(String stockId);
    /**
     * 修改
     * 根据板块编号 stockId
     */
    public void updateStock(Stock stock);
}
