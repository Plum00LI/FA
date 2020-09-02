package com.ssaw.BusinessData.controller;

import com.ssaw.BusinessData.entity.Market;
import com.ssaw.BusinessData.service.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
*@program: TescComment
*@Description:行情数据控制器，处理器
*@author: 瞿平
*@version:1.0
*@create: 2020-09-01
*/
@RestController
@RequestMapping("market")
public class MarketController {
    //调用用户Biz对象
    //自动装配 按照类型自动装配
    @Resource
    MarketService marketService;

    @RequestMapping("selectMarket")
    public HashMap selectMarket(){
        System.out.println("行情数据查询控制器");
        HashMap hashMap = new HashMap();
        List<Market> markets = marketService.selectMarket();
        hashMap.put("count",10);
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("data",markets);
        System.out.println("信息的大小："+markets.size());
        return hashMap;
    }

    @RequestMapping(value = "insertMarket",method = {RequestMethod.GET,RequestMethod.POST})
    public int insertMarket(@ModelAttribute Market market){
       /* Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dates = simpleDateFormat.format(date);

        market.setDateTime(dates);*/
        int i = marketService.insertMarket(market);
        return i;
    }


    @RequestMapping(value = "/updateMarket",method = {RequestMethod.GET,RequestMethod.POST})
    public int updateMarket(@ModelAttribute Market market){

        int i = marketService.updateMarket(market);
        return i;
    }

    @RequestMapping("/deleteMarket")
    public int deleteMarket(int marketId){
        int i = marketService.deleteMarket(marketId);
        return i;
    }
}
