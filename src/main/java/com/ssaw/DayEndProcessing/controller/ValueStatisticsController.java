package com.ssaw.DayEndProcessing.controller;

import com.ssaw.DayEndProcessing.entity.OperationValueStatistics;
import com.ssaw.DayEndProcessing.entity.SecuritiesValueStatistics;
import com.ssaw.DayEndProcessing.entity.ValueStatistics;
import com.ssaw.DayEndProcessing.service.OperationValueStatisticsService;
import com.ssaw.DayEndProcessing.service.SecuritiesValueStatisticsService;
import com.ssaw.DayEndProcessing.service.TaValueStatisticsService;
import com.ssaw.DayEndProcessing.service.ValueStatisticsService;
import com.ssaw.GlobalManagement.util.DateTimeUtil;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.InventoryManagement.entity.TaInventory;
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
    @Resource
    OperationValueStatisticsService operationValueStatisticsService;
    @Resource
    TaValueStatisticsService taValueStatisticsService;


    /**
     * 净值统计方法
     * @param valueStatisticsDate 时间
     * @return null
     * 数据库先删后增
     */
    @RequestMapping("insertValueStatistics")
    @ResponseBody
    public Object insertValueStatistics(String valueStatisticsDate,String fundId,String accountId) throws ParseException {
        //债券利息
        double num=0;
        //查询证券清算款-流入（应收）
        double num1=0;
        //查询证券清算款-流出（应付）
        double num2=0;
        //主账户TA清算款-应收
        double num3=0;
        //主账户TA清算款-应付
        double num4=0;
        //次账户TA清算款-应收
        double num5=0;
        //次账户TA清算款-应付
        double num6=0;
        //主账户管理费
        double num7=0;
        //主账户托管费
        double num8=0;
        //次账户管理费
        double num9=0;
        //次账户托管费
        double num10=0;
        //合计估值增值
        double num11=0;
        //合计总资产
        double num13=0;
        //单位资产净值
        double num14=0;

        //根据时间先删后增
        valueStatisticsService.deleteValueStatistics(valueStatisticsDate,fundId);
        //行情数据周六周日特殊处理模块
        String dateTimeTwo=valueStatisticsDate;
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
        //查询证券模块
        List<SecuritiesValueStatistics> securitiesValueStatistics = securitiesValueStatisticsService.selectSecuritiesValueStatistics(valueStatisticsDate, fundId, dateTimeTwo,1);
        //查询债券利息
        List<SecuritiesValueStatistics> securitiesValueStatistics1 = securitiesValueStatisticsService.selectSecuritiesValueStatistics(valueStatisticsDate, fundId, dateTimeTwo, 3);

        //合计债券利息
        for (SecuritiesValueStatistics valueStatistics : securitiesValueStatistics1) {
            num=num+valueStatistics.getTotalPrice();
        }

        //合计证券清算款所有流入
        List<SecuritiesValueStatistics> securitiesValueStatistics2 = securitiesValueStatisticsService.selectSecuritiesValueStatisticsTwo(valueStatisticsDate, fundId, dateTimeTwo, 2, 1);
        for (SecuritiesValueStatistics valueStatistics : securitiesValueStatistics2) {
            num1=num1+valueStatistics.getTotalPrice();
        }

        //合计证券清算款所有流出
        List<SecuritiesValueStatistics> securitiesValueStatistics3 = securitiesValueStatisticsService.selectSecuritiesValueStatisticsTwo(valueStatisticsDate, fundId, dateTimeTwo, 2, -1);
        for (SecuritiesValueStatistics valueStatistics : securitiesValueStatistics3) {
            num2=num2+valueStatistics.getTotalPrice();
        }
        //查询现金模块及现金利息
        List<OperationValueStatistics> operationValueStatistics = operationValueStatisticsService.selectOperationValueStatistics(valueStatisticsDate, fundId, 3);

//        for (OperationValueStatistics operationValueStatistic : operationValueStatistics) {
//            //根据现金模块查询出的账户ID及其他条件查询TA清算款
//            //根据账户ID循环查询TA应收
//            List<OperationValueStatistics> operationValueStatistics1 = operationValueStatisticsService.selectOperationTA(operationValueStatistic.getAccountId(), 4, 1, valueStatisticsDate,fundId);
//            for (OperationValueStatistics valueStatistics : operationValueStatistics1) {
//                //合计TA应收
//                num3=num3+valueStatistics.getTotalMoney();
//            }
//            //根据账户ID循环查询TA应付
//            List<OperationValueStatistics>  operationValueStatistics2 = operationValueStatisticsService.selectOperationTA(operationValueStatistic.getAccountId(), 4, -1, valueStatisticsDate,fundId);
//            for (OperationValueStatistics valueStatistics : operationValueStatistics2) {
//                //合计TA应付
//                num4=num4+valueStatistics.getTotalMoney();
//            }
//        }
        //查询管理费
//        List<OperationValueStatistics> operationValueStatistics1 = operationValueStatisticsService.selectOperationCost(valueStatisticsDate, fundId, 1);
//        //查询托管费
//        List<OperationValueStatistics> operationValueStatistics2 = operationValueStatisticsService.selectOperationCost(valueStatisticsDate, fundId, 2);

        //递增功能ID
        int id=3;
        //数据块插入证券模块外层对象
        ValueStatistics valueStatistics1 = new ValueStatistics(valueStatisticsDate, fundId,1, "证券",  -1);
        valueStatisticsService.insertValueStatistics(valueStatistics1);
        //数据块插入股票模块外层对象
        ValueStatistics valueStatistics2 = new ValueStatistics(valueStatisticsDate, fundId,2, "股票", 1 );
        valueStatisticsService.insertValueStatistics(valueStatistics2);
        //遍历证券模块数据集合
        for (SecuritiesValueStatistics securitiesValueStatistic : securitiesValueStatistics) {
            //数据库插入股票板块据
           if(securitiesValueStatistic.getSecuritiesType().equals("股票")){
               valueStatisticsService.insertValueStatistics(new ValueStatistics(valueStatisticsDate,fundId,id,securitiesValueStatistic.getSecuritiesName(),securitiesValueStatistic.getSecuritiesId(),securitiesValueStatistic.getSecuritiesNum(),securitiesValueStatistic.getClosingPrice(),securitiesValueStatistic.getTotal(),securitiesValueStatistic.getMarketValue(),securitiesValueStatistic.getTotalPrice(),2));
               id++;
           }
        }
        //数据块插入债券模块外层对象
        ValueStatistics valueStatistics3=new ValueStatistics(valueStatisticsDate,fundId,id,"债券",1);
        valueStatisticsService.insertValueStatistics(valueStatistics3);
        //递增功能ID
        id++;
        //遍历证券模块数据集合
        for (SecuritiesValueStatistics securitiesValueStatistic : securitiesValueStatistics) {
            //合计总市值
            num13=num13+securitiesValueStatistic.getMarketValue();
            //合计证券模块估值增值
            num11=num11+securitiesValueStatistic.getTotalPrice();
            //数据库插入债券板块据
            if(securitiesValueStatistic.getSecuritiesType().equals("债券")){
                valueStatisticsService.insertValueStatistics(new ValueStatistics(valueStatisticsDate,fundId,id,securitiesValueStatistic.getSecuritiesName(),securitiesValueStatistic.getSecuritiesId(),securitiesValueStatistic.getSecuritiesNum(),securitiesValueStatistic.getClosingPrice(),securitiesValueStatistic.getTotal(),securitiesValueStatistic.getMarketValue(),securitiesValueStatistic.getTotalPrice(),valueStatistics3.getProjectId()));
                id++;
            }
        }
        //数据块插入现金模块外层对象
        ValueStatistics valueStatistics4=new ValueStatistics(valueStatisticsDate,fundId,id,"现金",-1);
        valueStatisticsService.insertValueStatistics(valueStatistics4);
        //递增功能ID
        id++;
        //遍历现金模块数据集合
        for (OperationValueStatistics operationValueStatistic : operationValueStatistics) {
            //获得两个账户总余额+现金利息
            num13=num13+operationValueStatistic.getCashBlance()+operationValueStatistic.getTotalMoney();
            if(accountId.equals(operationValueStatistic.getAccountId())){
                //数据库插入主账户基本数据及余额
                ValueStatistics valueStatistics5=new ValueStatistics(valueStatisticsDate,fundId,id,operationValueStatistic.getAccountName(),operationValueStatistic.getBlankCardCode(),operationValueStatistic.getCashBlance(),valueStatistics4.getProjectId());
                valueStatisticsService.insertValueStatistics(valueStatistics5);
                id++;
                //数据库插入主账户现金利息
                ValueStatistics valueStatistics6=new ValueStatistics(valueStatisticsDate,fundId,id,"存款利息",operationValueStatistic.getTotalMoney(),valueStatistics5.getProjectId());
                valueStatisticsService.insertValueStatistics(valueStatistics6);
                id++;
                //数据库插入主账户债券利息
                ValueStatistics  valueStatistics7=new ValueStatistics(valueStatisticsDate,fundId,id,"债券利息",num,valueStatistics5.getProjectId());
                valueStatisticsService.insertValueStatistics(valueStatistics7);
                id++;
                //数据库插入主账户证券清算款
                ValueStatistics  valueStatistics8=new ValueStatistics(valueStatisticsDate,fundId,id,"证券清算款",num1-num2,valueStatistics5.getProjectId());
                valueStatisticsService.insertValueStatistics(valueStatistics8);
                id++;


                //根据账户ID循环查询TA应收
                List<OperationValueStatistics> operationValueStatistics3 = operationValueStatisticsService.selectOperationTA(operationValueStatistic.getAccountId(), 4, 1, valueStatisticsDate, fundId);
                for (OperationValueStatistics valueStatistics : operationValueStatistics3) {
                //合计TA应收
                num3=num3+valueStatistics.getTotalMoney();
                }
                //根据账户ID循环查询TA应付
                List<OperationValueStatistics> operationValueStatistics4 = operationValueStatisticsService.selectOperationTA(operationValueStatistic.getAccountId(), 4, -1, valueStatisticsDate, fundId);
                for (OperationValueStatistics valueStatistics : operationValueStatistics4) {
                //合计TA应付
                num4=num4+valueStatistics.getTotalMoney();
                }
                //数据库插入主账户TA清算款
                ValueStatistics  valueStatistics9=new ValueStatistics(valueStatisticsDate,fundId,id,"TA清算款",num3-num4,valueStatistics5.getProjectId());
                valueStatisticsService.insertValueStatistics(valueStatistics9);
                id++;
                //根据主账户ID查询管理费
                List<OperationValueStatistics> operationValueStatistics1 = operationValueStatisticsService.selectOperationCost(operationValueStatistic.getAccountId(), valueStatisticsDate, fundId, 1);
                //得到主账户管理费
                num7=operationValueStatistics1.get(0).getTotalMoney();
                //根据主账户ID查询托管费
                List<OperationValueStatistics> operationValueStatistics2 = operationValueStatisticsService.selectOperationCost(operationValueStatistic.getAccountId(), valueStatisticsDate, fundId, 2);
                //得到主账户托管费
                num8=operationValueStatistics2.get(0).getTotalMoney();
            }


        }
        //再次遍历现金模块数据集合
        for (OperationValueStatistics operationValueStatistic : operationValueStatistics) {
            if(!accountId.equals(operationValueStatistic.getAccountId())){
                //数据库插入次账户基本数据及余额
                ValueStatistics valueStatistics10=new ValueStatistics(valueStatisticsDate,fundId,id,operationValueStatistic.getAccountName(),operationValueStatistic.getBlankCardCode(),operationValueStatistic.getCashBlance(),valueStatistics4.getProjectId());
                valueStatisticsService.insertValueStatistics(valueStatistics10);
                id++;
                //数据库插入次账户现金利息
                ValueStatistics valueStatistics11=new ValueStatistics(valueStatisticsDate,fundId,id,"存款利息",operationValueStatistic.getTotalMoney(),valueStatistics10.getProjectId());
                valueStatisticsService.insertValueStatistics(valueStatistics11);
                id++;
                //根据账户ID循环查询TA应收
                List<OperationValueStatistics> operationValueStatistics3 = operationValueStatisticsService.selectOperationTA(operationValueStatistic.getAccountId(), 4, 1, valueStatisticsDate, fundId);
                for (OperationValueStatistics valueStatistics : operationValueStatistics3) {
                    //合计TA应收
                    num5=num5+valueStatistics.getTotalMoney();
                }
                //根据账户ID循环查询TA应付
                List<OperationValueStatistics> operationValueStatistics4 = operationValueStatisticsService.selectOperationTA(operationValueStatistic.getAccountId(), 4, -1, valueStatisticsDate, fundId);
                for (OperationValueStatistics valueStatistics : operationValueStatistics4) {
                    //合计TA应付
                    num6=num6+valueStatistics.getTotalMoney();
                }
                //数据库插入次账户TA清算款
                ValueStatistics  valueStatistics12=new ValueStatistics(valueStatisticsDate,fundId,id,"TA清算款",num5-num6,valueStatistics10.getProjectId());
                valueStatisticsService.insertValueStatistics(valueStatistics12);
                id++;
                //根据次账户ID查询管理费
                List<OperationValueStatistics> operationValueStatistics1 = operationValueStatisticsService.selectOperationCost(operationValueStatistic.getAccountId(), valueStatisticsDate, fundId, 1);
                //得到次账户管理费
                num9=operationValueStatistics1.get(0).getTotalMoney();
                //根据次账户ID查询托管费
                List<OperationValueStatistics> operationValueStatistics2 = operationValueStatisticsService.selectOperationCost(operationValueStatistic.getAccountId(), valueStatisticsDate, fundId, 2);
                //得到次账户托管费
                num10=operationValueStatistics2.get(0).getTotalMoney();
            }
        }

        //数据库插入运营模块外层对象
        ValueStatistics valueStatistics13=new ValueStatistics(valueStatisticsDate,fundId,id,"运营",-1);
        valueStatisticsService.insertValueStatistics(valueStatistics13);
        id++;
        //数据库插入运营模块管理费
        ValueStatistics valueStatistics14=new ValueStatistics(valueStatisticsDate,fundId,id,"管理费",num7+num9,valueStatistics13.getProjectId());
        valueStatisticsService.insertValueStatistics(valueStatistics14);
        id++;
        //数据库插入运营模块托管费
        ValueStatistics valueStatistics15=new ValueStatistics(valueStatisticsDate,fundId,id,"托管费",num8+num10,valueStatistics13.getProjectId());
        valueStatisticsService.insertValueStatistics(valueStatistics15);
        id++;

        //数据库插入合计模块外层对象
        ValueStatistics valueStatistics16=new ValueStatistics(valueStatisticsDate,fundId,id,"合计",-1);
        valueStatisticsService.insertValueStatistics(valueStatistics16);
        id++;

        //数据库插入合计模块估值增值数据
        ValueStatistics valueStatistics17=new ValueStatistics(valueStatisticsDate,fundId,id,"估值增值",num11,valueStatistics16.getProjectId());
        valueStatisticsService.insertValueStatistics(valueStatistics17);
        id++;

        //合计总负债
        double num12=num7+num8+num9+num10+num4+num6+num2;
        //数据库插入合计模块负债数据
        ValueStatistics valueStatistics18=new ValueStatistics(valueStatisticsDate,fundId,id,"负债",num12,valueStatistics16.getProjectId());
        valueStatisticsService.insertValueStatistics(valueStatistics18);
        id++;

        //合计总资产
        num13=num13+num+num1+num3+num5;
        //数据库插入合计模块资产合计数据
        ValueStatistics valueStatistics19=new ValueStatistics(valueStatisticsDate,fundId,id,"资产合计",num13,valueStatistics16.getProjectId());
        valueStatisticsService.insertValueStatistics(valueStatistics19);
        id++;

        //数据库插入合计模块资产净值数据
        ValueStatistics valueStatistics20=new ValueStatistics(valueStatisticsDate,fundId,id,"资产净值",num13-num12,valueStatistics16.getProjectId());
        valueStatisticsService.insertValueStatistics(valueStatistics20);
        id++;

        //调用方法查询TA数量
        List<TaInventory> taInventories = taValueStatisticsService.selectTaNum(fundId, valueStatisticsDate);
        //合计单位净值
        num14=(num13-num12)/taInventories.get(0).getTaNum();

        //数据库插入合计模块单位资产净值数据
        ValueStatistics valueStatistics21=new ValueStatistics(valueStatisticsDate,fundId,id,"单位净值",num14,valueStatistics16.getProjectId());
        valueStatisticsService.insertValueStatistics(valueStatistics21);





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
        //从数据库查询新增的数据
        List<ValueStatistics> valueStatisticsList = valueStatisticsService.selectValueStatistics(valueStatisticsDate, fundId);


        Map<String,Object> josn = new HashMap<String,Object>();
        josn.put("code", 0);
        josn.put("count",valueStatisticsList.size());
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
    public Object selectValueStatistics(String valueStatisticsDate,String fundId,String accountId){

        if(valueStatisticsDate.equals(" ")){
            valueStatisticsDate= DateTimeUtil.getSystemDateTime("yyyy-MM-dd");

        }
        List<ValueStatistics> valueStatisticsList = valueStatisticsService.selectValueStatistics(valueStatisticsDate,fundId);
        Map<String,Object> josn = new HashMap<String,Object>();
        josn.put("code", 0);
        josn.put("count",valueStatisticsList.size());
        josn.put("msg", "");
        josn.put("data", valueStatisticsList);
        return josn;
    }

}
