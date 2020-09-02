package com.ssaw.BusinessDescription.mapper;

import com.ssaw.BusinessDescription.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 股票板块
 * @type stock的dao层
 * @author fusaiying
 * @date 2020-09-01
 * @version 1.0
 */
@Mapper
public interface StockMapper {
    /**
     * 查询所有
     */
    public List<Stock> selectStock();
    /**
     * 根据父类查子类
     */
    public List<Stock> selectSonStock(String stockId);
    /**
     * 增加父类
     * @param stock
     */
    public void insertStockParentMsg(Stock stock);

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
