package com.ssaw.BusinessDescription.controller;

import com.ssaw.BusinessDescription.entity.Fund;
import com.ssaw.BusinessDescription.service.FundService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by: 曾钦辉
 * description: 基金信息Controller控制层
 * create time: 2020/9/1 11:14
 *
 * @Param: null
 * @return
 */
@RestController
public class FundController {
    @Resource
    FundService fundService;

    @RequestMapping(value = "/insertFund")
    public int insertFund(Fund fund) {
        System.out.println("进来了");

        int i = fundService.insertFund(fund);
        System.out.println(fund);
        return i;
    }

    @RequestMapping(value = "/deleteFund")
    public void deleteFund(int fundId) {
        System.out.println("进来了");
        fundService.deleteFund(fundId);
    }

    @RequestMapping(value = "/updateFund")
    public int updateFund(Fund fund) {
        System.out.println("进来了");
        int i = fundService.updateFund(fund);
        System.out.println(fund);
        return i;
    }

    @RequestMapping(value = "/selectFund")
    public Map<String, Object> selectFund(String page, String limit) {
        System.out.println("进来了");
        Map<String, Object> map = fundService.selectFund(limit, page);
        List<Fund> fundList = (List<Fund>) map.get("fundList");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", count);
        json.put("data", fundList);
        //返回数据
        return json;
    }
}
