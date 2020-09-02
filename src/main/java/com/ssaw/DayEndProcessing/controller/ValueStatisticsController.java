package com.ssaw.DayEndProcessing.controller;

import com.ssaw.DayEndProcessing.entity.ValueStatistics;
import com.ssaw.DayEndProcessing.service.ValueStatisticsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * create by: 佘高鹏
 * description: TODO
 * create time: 2020/9/1 10:23
 * version number 1.0
 * RS风格的净值统计处理器
  * @Param: null
 * @return
 */
@RestController
@RequestMapping("ValueStatistics")
public class ValueStatisticsController {
    @Resource
    ValueStatisticsService valueStatisticsService;
    @GetMapping
    public String hello(String datetime, HttpSession session){
        System.out.println(datetime);
        System.out.println("进来了");
//        ValueStatistics valueStatistics=new ValueStatistics("3","3","3","3","2",1,1,1,1,1,"2","2",1,1,1,1,1);
//        valueStatisticsService.insertValueStatistics(valueStatistics);
        return "咕呱咕呱";
    }
    @PostMapping
    public String hello1(){
        System.out.println("进来了");

        ValueStatistics valueStatistics=new ValueStatistics();
        valueStatistics.setValueStatisticsDate("3");
        List<ValueStatistics> valueStatistics1 = valueStatisticsService.selectValueStatistics(valueStatistics);
        for (ValueStatistics statistics : valueStatistics1) {
            System.out.println(statistics);
        }
        return "咕呱咕呱";
    }
    @DeleteMapping
    public String hello2(){
        System.out.println("进来了");

        valueStatisticsService.deleteValueStatistics("2");
        return "咕呱咕呱";
    }
}
