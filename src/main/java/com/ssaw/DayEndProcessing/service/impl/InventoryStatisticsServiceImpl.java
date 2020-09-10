package com.ssaw.DayEndProcessing.service.impl;

import com.ssaw.DayEndProcessing.entity.InventoryStatistics;
import com.ssaw.DayEndProcessing.entity.SecuritiesInventoryData;
import com.ssaw.DayEndProcessing.mapper.InventoryStatisticsMapper;
import com.ssaw.DayEndProcessing.service.InventoryStatisticsService;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import com.ssaw.InventoryManagement.entity.SecuritiesInventory;

import com.ssaw.InventoryManagement.service.SecuritiesInventoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:    InventoryStatisticsServiceImpl
 * Package:    com.ssaw.DayEndProcessing.service.impl
 * Description:
 * Version:
 * Datetime:    2020/9/9   17:18
 * Author:   SYT
 */
@Service
@Transactional
public class InventoryStatisticsServiceImpl implements InventoryStatisticsService {
    //注入库存统计Mapper方法
    @Resource
     InventoryStatisticsMapper inventoryStatisticsMapper;
    //证券库存的mapper
    @Resource
     SecuritiesInventoryService securitiesInventoryService;

    @Resource
    DbUtil dbUtil;

    @Override
    public List<InventoryStatistics> selectInventoryStatistics(String dateTime, String invId) {
        //创建List保持库存统计信息
        List<InventoryStatistics>  list=new ArrayList<InventoryStatistics>();
        //库存信息
        InventoryStatistics cashInventory=new InventoryStatistics(1,"现金库存","289289289","admin","",0,"暂无");
        InventoryStatistics securitiesInventory=new InventoryStatistics(2,"证券库存","289289289","admin","",0,"暂无");
        InventoryStatistics TaInventory=new InventoryStatistics(3,"TA库存","289289289","admin","",0,"暂无");
        InventoryStatistics securitiesClosePayInventory=new InventoryStatistics(4,"证券应收应付库存","289289289","admin","",0,"暂无");
        InventoryStatistics cashClosePayInventory=new InventoryStatistics(5,"现金应收应付库存","289289289","admin","",0,"暂无");
        System.out.println("serviceImpl的dateTime"+dateTime);
        String[] invIdList=null;
        //判断统计的库存
        if (invId !=null && !invId.equals("")){
            invIdList=invId.split(",");

            for (String strInvId : invIdList) {
                switch (strInvId){
                    case "1":
                        System.out.println("现金库存");
                        break;
                    case "2":
                        System.out.println("证券库存");
                        System.out.println("证券库存的dateTime"+dateTime);
                        //统计证券库存
                        List<SecuritiesInventoryData> securitiesInventoryList=inventoryStatisticsMapper.selectSecuritiesInventory(dateTime,"289289289");
                        System.out.println("啦啦啦");

                        securitiesInventory = new InventoryStatistics(2,"证券库存","289289289","admain",dateTime,securitiesInventoryList.size(),"已统计");

                        for (SecuritiesInventoryData securitiesInventoryData : securitiesInventoryList) {
                            System.out.println("我是库存统计 我查询到的结果为："+securitiesInventoryData);
                        }


//                        遍历
                        for (SecuritiesInventoryData securities : securitiesInventoryList) {
                            System.out.println("证券库存数据为："+securities);
                            //删除证券库存信息
                            securitiesInventoryService.deleteSecuritiesInventoryDate(dateTime);
                            //增加证券库存数据
                            SecuritiesInventory securitiesInventory1=new SecuritiesInventory();
                            //证券库存ID
                            securitiesInventory1.setSecuritiesInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SI));
                            //证券库存日期
                            securitiesInventory1.setDateTime(dateTime);
                            //证券信息表ID
                            securitiesInventory1.setSecuritiesId(securities.getSecuritiesId());
                            //基金表ID
                            securitiesInventory1.setFundId("289289289");
                            //是否导入其他系统数据
                            securitiesInventory1.setSecurityPeriodFlag(0);
                            //证券的数量
                            securitiesInventory1.setSecuritiesNum(securities.getTodayNum());
                            //单位成本
                            securitiesInventory1.setPrice(securities.getUnitPrice());
                            //总金额
                            securitiesInventory1.setTotal(securities.getTodayTotal());
                            //备注
                            securitiesInventory1.setSecuritiesInventoryDesc("证券库存统计");

                            //输出语句
                            System.out.println("证券库存统计"+securitiesInventory1);

                            //调用增加方法
                            securitiesInventoryService.insertSecuritiesInventory(securitiesInventory1);

                        }

                        break;
                    case "3":
                        System.out.println("TA库存");
                        break;
                    case "4":
                        System.out.println("证券应收应付库存");
                        break;
                    case "5":
                        System.out.println("现金应收应付库存");
                        break;
                }
            }
        }
        list.add(cashInventory);
        list.add(securitiesInventory);
        list.add(TaInventory);
        list.add(securitiesClosePayInventory);
        list.add(cashClosePayInventory);
        return list;
    }
}
