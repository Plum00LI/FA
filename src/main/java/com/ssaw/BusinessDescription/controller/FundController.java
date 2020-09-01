package com.ssaw.BusinessDescription.controller;

import com.ssaw.BusinessDescription.entity.Fund;
import com.ssaw.BusinessDescription.service.FundService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public int insertFund(Fund fund){
        System.out.println("进来了");
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss ");
        Date date = new Date(System.currentTimeMillis());
        String format = formatter.format(date);
        Fund fund1=new Fund(1,"1",1,"1","1",1,
                1,1,1,1,format,"1","1");
        int i= fundService.insertFund(fund1);
        System.out.println(i);
        return i;
    }
    @RequestMapping(value = "/deleteFund")
    public void deleteFund(){
        System.out.println("进来了");
        fundService.deleteFund(1);
    }
    @RequestMapping(value = "/updateFund")
    public int updateFund(){
        System.out.println("进来了");
        Fund fund=new Fund(1,"1",1,"1","1",1,
                1,1,1,1,"format","1","1");
      int i= fundService.updateFund(fund);
      return i;
    }
    @RequestMapping(value = "/selectFund")
    public List<Fund> selectFund(){
        System.out.println("进来了");
        List<Fund> fundList = fundService.selectFund();
        for (Fund fund : fundList) {
            System.out.println(fund);
        }
        return fundList;
    }
}
