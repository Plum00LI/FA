package com.ssaw.DayEndProcessing.controller;

import com.ssaw.DayEndProcessing.entity.SecuritiesValueStatistics;
import com.ssaw.DayEndProcessing.entity.ValueStatistics;
import com.ssaw.DayEndProcessing.service.SecuritiesValueStatisticsService;
import com.ssaw.DayEndProcessing.service.ValueStatisticsService;
import com.ssaw.GlobalManagement.util.DateTimeUtil;
import com.ssaw.GlobalManagement.util.DbUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * create by: 佘高鹏
 * description: TODO
 * create time: 2020/9/1 10:23
 * updata time: 2020/9/3 16:07
 * version number 2.0
 * RS风格的净值统计处理器
  * @Param: null
 * @return
 */


@RestController
@RequestMapping("ValueStatistics")
public class ValueStatisticsController {
    @Resource
    ValueStatisticsService valueStatisticsService;
    @Resource
    SecuritiesValueStatisticsService securitiesValueStatisticsService;



    /**
     * 净值统计方法
     * @param valueStatisticsDate 时间
     * @return null
     * 数据库先删后增
     */
    @RequestMapping("insertValueStatistics")
    @ResponseBody
    public Object insertValueStatistics(String valueStatisticsDate) throws ParseException {
        String dateTimeTwo="";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = df.parse(valueStatisticsDate);
        Calendar instance = Calendar.getInstance();
        instance.setTime(parse);
        int i = instance.get(Calendar.DAY_OF_WEEK);
        i--;
        if(i==6){
              instance.add(Calendar.DATE, -1); //得到前一天
              Date time = instance.getTime();
              dateTimeTwo=df.format(time);

        }else if(i==7){
              instance.add(Calendar.DATE, -2); //得到前一天
              Date time = instance.getTime();
              dateTimeTwo=df.format(time);
        }

        List<SecuritiesValueStatistics> securitiesValueStatistics = securitiesValueStatisticsService.selectSecuritiesValueStatistics("2020-09-10", "000899", "2020-09-10",1);
        for (SecuritiesValueStatistics securitiesValueStatistic : securitiesValueStatistics) {
            System.out.println(securitiesValueStatistic);
        }
//
//        ValueStatistics valueStatistics1 = new ValueStatistics(valueStatisticsDate, "1",1, "证券",  -1);
//            ValueStatistics valueStatistics2 = new ValueStatistics(valueStatisticsDate, "1",2, "股票",  1);
//            ValueStatistics valueStatistics3 = new ValueStatistics(valueStatisticsDate, "1",3,"南方航空", "600028", 2000.00, 4.43, 8820.00, 8860.00, 40.00, 2);
//            ValueStatistics valueStatistics4 = new ValueStatistics(valueStatisticsDate, "1",4, "中达股份", "600074", 1500.00, 5.61, 6310.00, 8415.00, 2105.00, 2);
//            ValueStatistics valueStatistics5 = new ValueStatistics(valueStatisticsDate, "1",5, "债券",1);
//            ValueStatistics valueStatistics6 = new ValueStatistics(valueStatisticsDate, "1",6, "01三峡债", "120102", 1000.00, 99.08, 98730.00, 99080.00, 350.00, 5);
//            ValueStatistics valueStatistics7 = new ValueStatistics(valueStatisticsDate, "1",7, "96国债⑹", "000696", 1200.00, 114.48, 120000.00, 137376.00, 17376.00, 5);
//            ValueStatistics valueStatistics8 = new ValueStatistics(valueStatisticsDate, "1",8, "现金", -1);
//            ValueStatistics valueStatistics9 = new ValueStatistics(valueStatisticsDate, "1",9, "基金托管副账户", "622233771139923", 1000000.00, 8);
//            ValueStatistics valueStatistics10 = new ValueStatistics(valueStatisticsDate, "1",10, "存款利息A0008", 54.80, 9);
//            ValueStatistics valueStatistics11 = new ValueStatistics(valueStatisticsDate, "1",11, "一度教育主托管账户", "622233771138842",  79040290.00,  8);
//            ValueStatistics valueStatistics12 = new ValueStatistics(valueStatisticsDate, "1",12,"债券利息", 9.43,  11);
//            ValueStatistics valueStatistics13 = new ValueStatistics(valueStatisticsDate, "1",13, "存款利息A0006",  4330.98,  11);
//            ValueStatistics valueStatistics14 = new ValueStatistics(valueStatisticsDate, "1", 14,"证券清算款", 8888.0, 11);
//            ValueStatistics valueStatistics15 = new ValueStatistics(valueStatisticsDate, "1",15, "TA清算款",  666.0,  11);
//            ValueStatistics valueStatistics16 = new ValueStatistics(valueStatisticsDate, "1", 16,"运营", -1);
//            ValueStatistics valueStatistics17 = new ValueStatistics(valueStatisticsDate, "1",17, "管理费", 5918.9,  16);
//            ValueStatistics valueStatistics18 = new ValueStatistics(valueStatisticsDate, "1",18, "托管费", 7398.70, 16);
//            ValueStatistics valueStatistics19 = new ValueStatistics(valueStatisticsDate, "1",19, "合计", -1);
//            ValueStatistics valueStatistics20 = new ValueStatistics(valueStatisticsDate, "1",20, "估值增值", 20741.00, 19);
//            ValueStatistics valueStatistics21 = new ValueStatistics(valueStatisticsDate, "1",21,"负债", 257167.66,  19);
//            ValueStatistics valueStatistics22 = new ValueStatistics(valueStatisticsDate, "1",22, "资产合计", 80309276.21,  19);
//            ValueStatistics valueStatistics23 = new ValueStatistics(valueStatisticsDate, "1",23, "资产净值", 80052108.55,  19);
//            ValueStatistics valueStatistics24 = new ValueStatistics(valueStatisticsDate, "1",24, "单位净值", 1.00, 19);
//            //确保数据的唯一性，先删后增
//            valueStatisticsService.deleteValueStatistics(valueStatisticsDate,"1");
//            //增加到数据库
//            valueStatisticsService.insertValueStatistics(valueStatistics1);
//            valueStatisticsService.insertValueStatistics(valueStatistics2);
//            valueStatisticsService.insertValueStatistics(valueStatistics3);
//            valueStatisticsService.insertValueStatistics(valueStatistics4);
//            valueStatisticsService.insertValueStatistics(valueStatistics5);
//            valueStatisticsService.insertValueStatistics(valueStatistics6);
//            valueStatisticsService.insertValueStatistics(valueStatistics7);
//            valueStatisticsService.insertValueStatistics(valueStatistics8);
//            valueStatisticsService.insertValueStatistics(valueStatistics9);
//            valueStatisticsService.insertValueStatistics(valueStatistics10);
//            valueStatisticsService.insertValueStatistics(valueStatistics11);
//            valueStatisticsService.insertValueStatistics(valueStatistics12);
//            valueStatisticsService.insertValueStatistics(valueStatistics13);
//            valueStatisticsService.insertValueStatistics(valueStatistics14);
//            valueStatisticsService.insertValueStatistics(valueStatistics15);
//            valueStatisticsService.insertValueStatistics(valueStatistics16);
//            valueStatisticsService.insertValueStatistics(valueStatistics17);
//            valueStatisticsService.insertValueStatistics(valueStatistics18);
//            valueStatisticsService.insertValueStatistics(valueStatistics19);
//            valueStatisticsService.insertValueStatistics(valueStatistics20);
//            valueStatisticsService.insertValueStatistics(valueStatistics21);
//            valueStatisticsService.insertValueStatistics(valueStatistics22);
//            valueStatisticsService.insertValueStatistics(valueStatistics23);
//            valueStatisticsService.insertValueStatistics(valueStatistics24);
//
//        //从数据库查询新增的数据
//
//        List<ValueStatistics> valueStatisticsList = valueStatisticsService.selectValueStatistics(valueStatisticsDate,"1");
//
//
//        Map<String,Object> josn = new HashMap<String,Object>();
//        josn.put("code", 0);
//        josn.put("count",valueStatisticsList.size());
//        josn.put("msg", "");
//        josn.put("data", valueStatisticsList);
        return null;
    }
    /**
     * 净值查询方法
     * @param valueStatisticsDate 时间
     * @return null
     */
    @RequestMapping("selectValueStatistics")
    @ResponseBody
    public Object selectValueStatistics(String valueStatisticsDate){
        System.out.println(valueStatisticsDate);
        System.out.println("进来了");
        List<ValueStatistics> valueStatisticsList = valueStatisticsService.selectValueStatistics(valueStatisticsDate,"1");
        Map<String,Object> josn = new HashMap<String,Object>();
        josn.put("code", 0);
        josn.put("count",valueStatisticsList.size());
        josn.put("msg", "");
        josn.put("data", valueStatisticsList);
        return josn;
    }

}
