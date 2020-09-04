package com.ssaw.BusinessDescription.controller;

import com.ssaw.BusinessDescription.entity.Fund;
import com.ssaw.BusinessDescription.entity.Securities;
import com.ssaw.BusinessDescription.entity.SecuritiesAndStock;
import com.ssaw.BusinessDescription.entity.Stock;
import com.ssaw.BusinessDescription.service.FundService;
import com.ssaw.BusinessDescription.service.StockService;
import oracle.net.ano.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 股票板块
 * @type 控制层
 * @author fusaiying
 * @date 2020-09-01
 * @version 1.0
 */
@RestController
@RequestMapping("Stock")
public class StockController {
    @Resource
    StockService stockService;

    @RequestMapping(value = "/insertStock")
    public void insertStock(Fund fund) {
        System.out.println("进来了");
        Stock stock = new Stock("003", "000", "纺织业", "轻工业类");
        stockService.insertStockParentMsg(stock);
    }
//查询
    @RequestMapping(value = "selectStock")
    public Map<String,Object> selectStock() {
        List<Securities> securitiesList = stockService.selectStock();
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",null);
        json.put("data",securitiesList);
        //返回数据
        return json;

    }
}

