package com.ssaw.BusinessData.controller;

import com.ssaw.BusinessData.entity.Market;
import com.ssaw.BusinessData.service.MarketService;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
*@program: TescComment
*@Description:行情数据控制器，处理器
*@author: 瞿平
*@version:1.0
*@create: 2020-09-01
*/
@RequestMapping("market")
@RestController
public class MarketController {
    //调用用户Biz对象
    //自动装配 按照类型自动装配
    @Resource
    MarketService marketService;

    //调用工具类
    @Resource
    DbUtil dbUtil;

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

    @RequestMapping("selectMarketInfo")
    public Map<String,Object> selectMarketInfo(String page,String limit,String securitiesId,String dateTime){
        System.out.println("行情数据分页查询控制器");
        Map<String,Object> map = marketService.selectMarketInfo(limit,page,securitiesId,dateTime);
        List<Market> markets = (List<Market>) map.get("markets");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("count",count);
        hashMap.put("data",markets);
        System.out.println("信息的大小："+markets.size());
        return hashMap;
    }

    @RequestMapping("insertMarket")
    @ResponseBody
    public int insertMarket(Market market){
        market.setMarketId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.M));

        System.out.println("添加"+market);
        return marketService.insertMarket(market);
    }


    @RequestMapping(value = "/updateMarket",method = {RequestMethod.GET,RequestMethod.POST})
    public int updateMarket(@ModelAttribute Market market){
        int i = marketService.updateMarket(market);
        System.out.println("修改："+i);
        return i;
    }

    /*@RequestMapping("/deleteMarket")
    public int deleteMarket(String marketId){
        int i = marketService.deleteMarket(marketId);
        System.out.println("删除："+i);
        return i;
    }*/

    /**
     * 行情数据单行删除多行删除
     * @param marketId 行情编号
     * @return marketId 行情编号
     */
    @RequestMapping("deleteMarket")
    public int deleteMarket(@RequestParam("marketId")String marketId) {
        return marketService.deleteMarket(marketId);
    }
}
