package com.ssaw.DayEndProcessing.controller;

import com.ssaw.DayEndProcessing.entity.ValueStatistics;
import com.ssaw.DayEndProcessing.service.ValueStatisticsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 净值统计方法
     * @param valueStatisticsDate 时间
     * @return null
     * 数据库先删后增
     */
    @RequestMapping("insertValueStatistics")
    @ResponseBody
    public Object insertValueStatistics(String valueStatisticsDate){
        System.out.println(valueStatisticsDate);
        System.out.println("进来了");
        //获取数据，封装到实体类
        ValueStatistics valueStatistics1=new ValueStatistics(valueStatisticsDate,1,"证券","","","","","","",-1);
        ValueStatistics valueStatistics2=new ValueStatistics(valueStatisticsDate,2,"股票","","","","","","",1);
        ValueStatistics valueStatistics3=new ValueStatistics(valueStatisticsDate,3,"南方航空","600028","2,000.00","4.43","8,820.00","8,860.00","40.00",2);
        ValueStatistics valueStatistics4=new ValueStatistics(valueStatisticsDate,4,"中达股份","600074","1,500.00","5.61","6,310.00","8,415.00","2,105.00",2);
        ValueStatistics valueStatistics5=new ValueStatistics(valueStatisticsDate,5,"债券","","","","","","",1);
        ValueStatistics valueStatistics6=new ValueStatistics(valueStatisticsDate,6,"01三峡债","120102","1,000.00","99.08","98,730.00","99,080.00","350.00",5);
        ValueStatistics valueStatistics7=new ValueStatistics(valueStatisticsDate,7,"96国债⑹","000696","1,200.00","114.48","120,000.00","137,376.00","17,376.00",5);
        ValueStatistics valueStatistics8=new ValueStatistics(valueStatisticsDate,8,"现金","","","","","","",-1);
        ValueStatistics valueStatistics9=new ValueStatistics(valueStatisticsDate,9,"基金托管副账户","622233771139923","","","1,000,000.00","","",8);
        ValueStatistics valueStatistics10=new ValueStatistics(valueStatisticsDate,10,"存款利息A0008","","","","54.80","","",9);
        ValueStatistics valueStatistics11=new ValueStatistics(valueStatisticsDate,11,"一度教育主托管账户","622233771138842","","","79,040,290.00","","",8);
        ValueStatistics valueStatistics12=new ValueStatistics(valueStatisticsDate,12,"债券利息","","","","9.43","","",11);
        ValueStatistics valueStatistics13=new ValueStatistics(valueStatisticsDate,13,"存款利息A0006","","","","4,330.98","","",11);
        ValueStatistics valueStatistics14=new ValueStatistics(valueStatisticsDate,14,"证券清算款","","","","8888","","",11);
        ValueStatistics valueStatistics15=new ValueStatistics(valueStatisticsDate,15,"TA清算款","","","","666","","",11);
        ValueStatistics valueStatistics16=new ValueStatistics(valueStatisticsDate,16,"运营","","","","","","",-1);
        ValueStatistics valueStatistics17=new ValueStatistics(valueStatisticsDate,17,"管理费","","","","5,918.9","","",16);
        ValueStatistics valueStatistics18=new ValueStatistics(valueStatisticsDate,18,"托管费","","","","7,398.70","","",16);
        ValueStatistics valueStatistics19=new ValueStatistics(valueStatisticsDate,19,"合计","","","","","","",-1);
        ValueStatistics valueStatistics20=new ValueStatistics(valueStatisticsDate,20,"估值增值","","","","20,741.00","","",19);
        ValueStatistics valueStatistics21=new ValueStatistics(valueStatisticsDate,21,"负债","","","","257,167.66","","",19);
        ValueStatistics valueStatistics22=new ValueStatistics(valueStatisticsDate,22,"资产合计","","","","80,309,276.21","","",19);
        ValueStatistics valueStatistics23=new ValueStatistics(valueStatisticsDate,23,"资产净值","","","","80,052,108.55","","",19);
        ValueStatistics valueStatistics24=new ValueStatistics(valueStatisticsDate,24,"单位净值","","","","1.00","","",19);
        //确保数据的唯一性，先删后增
        valueStatisticsService.deleteValueStatistics(valueStatisticsDate);
        //增加到数据库
        valueStatisticsService.insertValueStatistics(valueStatistics1);
        valueStatisticsService.insertValueStatistics(valueStatistics2);
        valueStatisticsService.insertValueStatistics(valueStatistics3);
        valueStatisticsService.insertValueStatistics(valueStatistics4);
        valueStatisticsService.insertValueStatistics(valueStatistics5);
        valueStatisticsService.insertValueStatistics(valueStatistics6);
        valueStatisticsService.insertValueStatistics(valueStatistics7);
        valueStatisticsService.insertValueStatistics(valueStatistics8);
        valueStatisticsService.insertValueStatistics(valueStatistics9);
        valueStatisticsService.insertValueStatistics(valueStatistics10);
        valueStatisticsService.insertValueStatistics(valueStatistics11);
        valueStatisticsService.insertValueStatistics(valueStatistics12);
        valueStatisticsService.insertValueStatistics(valueStatistics13);
        valueStatisticsService.insertValueStatistics(valueStatistics14);
        valueStatisticsService.insertValueStatistics(valueStatistics15);
        valueStatisticsService.insertValueStatistics(valueStatistics16);
        valueStatisticsService.insertValueStatistics(valueStatistics17);
        valueStatisticsService.insertValueStatistics(valueStatistics18);
        valueStatisticsService.insertValueStatistics(valueStatistics19);
        valueStatisticsService.insertValueStatistics(valueStatistics20);
        valueStatisticsService.insertValueStatistics(valueStatistics21);
        valueStatisticsService.insertValueStatistics(valueStatistics22);
        valueStatisticsService.insertValueStatistics(valueStatistics23);
        valueStatisticsService.insertValueStatistics(valueStatistics24);
        //从数据库查询新增的数据
        ValueStatistics valueStatistics25=new ValueStatistics();
        valueStatistics25.setValueStatisticsDate(valueStatisticsDate);
        List<ValueStatistics> valueStatisticsList = valueStatisticsService.selectValueStatistics(valueStatistics25);


//        List<ValueStatistics> valueStatisticsList=new ArrayList();
//        valueStatisticsList.add(valueStatistics1);
//        valueStatisticsList.add(valueStatistics2);
//        valueStatisticsList.add(valueStatistics3);
//        valueStatisticsList.add(valueStatistics4);
//        valueStatisticsList.add(valueStatistics5);
//        valueStatisticsList.add(valueStatistics6);
//        valueStatisticsList.add(valueStatistics7);
//        valueStatisticsList.add(valueStatistics8);
//        valueStatisticsList.add(valueStatistics9);
//        valueStatisticsList.add(valueStatistics10);
//        valueStatisticsList.add(valueStatistics11);
//        valueStatisticsList.add(valueStatistics12);
//        valueStatisticsList.add(valueStatistics13);
//        valueStatisticsList.add(valueStatistics14);
//        valueStatisticsList.add(valueStatistics15);
//        valueStatisticsList.add(valueStatistics16);
//        valueStatisticsList.add(valueStatistics17);
//        valueStatisticsList.add(valueStatistics18);
//        valueStatisticsList.add(valueStatistics19);
//        valueStatisticsList.add(valueStatistics20);
//        valueStatisticsList.add(valueStatistics21);
//        valueStatisticsList.add(valueStatistics22);
//        valueStatisticsList.add(valueStatistics23);
//        valueStatisticsList.add(valueStatistics24);
        Map<String,Object> josn = new HashMap<String,Object>();
        josn.put("code", 0);
        josn.put("count",valueStatisticsList


                .size());
        josn.put("msg", "");
        josn.put("data", valueStatisticsList);
        return josn;
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

        ValueStatistics valueStatistics25=new ValueStatistics();
        valueStatistics25.setValueStatisticsDate(valueStatisticsDate);
        List<ValueStatistics> valueStatisticsList = valueStatisticsService.selectValueStatistics(valueStatistics25);
        Map<String,Object> josn = new HashMap<String,Object>();
        josn.put("code", 0);
        josn.put("count",valueStatisticsList.size());
        josn.put("msg", "");
        josn.put("data", valueStatisticsList);
        return josn;
    }

}
