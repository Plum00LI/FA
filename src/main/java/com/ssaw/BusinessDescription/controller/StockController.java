package com.ssaw.BusinessDescription.controller;

import com.ssaw.BusinessDescription.entity.Fund;
import com.ssaw.BusinessDescription.entity.Stock;
import com.ssaw.BusinessDescription.service.FundService;
import com.ssaw.BusinessDescription.service.StockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 股票板块
 * @type 控制层
 * @author fusaiying
 * @date 2020-09-01
 * @version 1.0
 */
@RestController
public class StockController {
    @Resource
    StockService stockService;

    @RequestMapping(value = "/insertStock")
    public void insertStock(Fund fund){
        System.out.println("进来了");
        Stock stock = new Stock("003","000","纺织业","轻工业类");
        stockService.insertStockParentMsg(stock);
    }

    @RequestMapping(value = "/selectStock")
    private HashMap selectStock(){
        List<Stock> stocksList= stockService.selectStock();
        HashMap stockMap = new HashMap();
        stockMap.put("count",10);
        stockMap.put("code",0);
        stockMap.put("msg","");
        stockMap.put("data",stocksList);
        return stockMap;
    }
}

