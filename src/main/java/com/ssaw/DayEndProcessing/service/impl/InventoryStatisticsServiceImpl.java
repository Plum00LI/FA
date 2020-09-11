package com.ssaw.DayEndProcessing.service.impl;

import com.ssaw.DayEndProcessing.entity.CashInventoryData;
import com.ssaw.DayEndProcessing.entity.InventoryStatistics;
import com.ssaw.DayEndProcessing.entity.SecuritiesInventoryData;
import com.ssaw.DayEndProcessing.entity.TaInventoryData;
import com.ssaw.DayEndProcessing.mapper.InventoryStatisticsMapper;
import com.ssaw.DayEndProcessing.service.InventoryStatisticsService;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import com.ssaw.InventoryManagement.entity.CashInventory;
import com.ssaw.InventoryManagement.entity.SecuritiesInventory;

import com.ssaw.InventoryManagement.entity.TaInventory;
import com.ssaw.InventoryManagement.service.*;
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
    //证券库存的Service
    @Resource
     SecuritiesInventoryService securitiesInventoryService;
    //TA库存
    @Resource
    TaInventoryService taInventoryService;
    //现金库存
    @Resource
    CashInventoryService cashInventoryService;
    //现金应收应付库存
    @Resource
    CashClosedPayInventoryService cashClosedPayInventoryService;
    //证券应收应付库存
    @Resource
    SecuritiesClosedPayInventoryService securitiesClosedPayInventoryService;



    @Resource
    DbUtil dbUtil;

    @Override
    public List<InventoryStatistics> selectInventoryStatistics(String dateTime, String invId) {
        //创建List保持库存统计信息
        List<InventoryStatistics>  list=new ArrayList<InventoryStatistics>();
        //库存信息
        InventoryStatistics cashInventory=new InventoryStatistics(1,"现金库存","289289289","admin","",0,"暂无");
        InventoryStatistics securitiesInventory=new InventoryStatistics(2,"证券库存","289289289","admin","",0,"暂无");
        InventoryStatistics taInventory=new InventoryStatistics(3,"TA库存","289289289","admin","",0,"暂无");
        InventoryStatistics securitiesClosePayInventory=new InventoryStatistics(4,"证券应收应付库存","289289289","admin","",0,"暂无");
        InventoryStatistics cashClosePayInventory=new InventoryStatistics(5,"现金应收应付库存","289289289","admin","",0,"暂无");
        System.out.println("serviceImpl的dateTime"+dateTime);

        //判断统计的库存
        if (invId !=null && !invId.equals("")){
            String[] invIdList=null;
            invIdList=invId.split(",");

            for (String strInvId : invIdList) {
                switch (strInvId){
                    case "1":
                        System.out.println("现金库存统计");

                        List<CashInventoryData> cashInventoryDataList=inventoryStatisticsMapper.selectCashInventory(dateTime,"000899");
                        for (CashInventoryData cashInventoryData : cashInventoryDataList) {
                            System.out.println("现金库存统计的数据为："+cashInventoryData);
                            //删除原现金库存信息
                            cashInventoryService.deleteCashInventoryData(dateTime);
                            //增加新数据
                            CashInventory cashInventory1=new CashInventory();
//                        this.cashInventoryId = cashInventoryId;
//                        this.fundId = fundId;
//                        this.cashBlance = cashBlance;
//                        this.accountId = accountId;
//                        this.dateTime = dateTime;
//                        this.securitiesNum = securitiesNum;
//                        this.securityPeriodFlag = securityPeriodFlag;
//                        this.cashInventoryDesc = cashInventoryDesc;
                            cashInventory1.setCashInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.CI));
                            cashInventory1.setFundId("000899");
                            cashInventory1.setCashBlance(cashInventoryData.getCashTotal());
                            cashInventory1.setAccountId("000899001");

                            cashInventory1.setDateTime(dateTime);
                            cashInventory1.setSecuritiesNum(0);
//                            cashInventory1.setSecurityPeriodFlag(0);
                            cashInventory1.setCashInventoryDesc("统计现金库存");

                            //调用增加方法
                            cashInventoryService.insertCashInventory(cashInventory1);
                            System.out.println("统计完毕现金库存的实体类："+cashInventory1);
                        }
                        break;
                    case "2":
                        System.out.println("证券库存");
                        System.out.println("证券库存的dateTime"+dateTime);
                        //统计证券库存
                        List<SecuritiesInventoryData> securitiesInventoryList=inventoryStatisticsMapper.selectSecuritiesInventory(dateTime,"000899");
//                        System.out.println("啦啦啦");

                        securitiesInventory = new InventoryStatistics(2,"证券库存","000899","admain",dateTime,securitiesInventoryList.size(),"已统计");

                        for (SecuritiesInventoryData securitiesInventoryData : securitiesInventoryList) {
                            System.out.println("我是库存统计 我查询到的结果为："+securitiesInventoryData);
                        }


//                        遍历
                        for (SecuritiesInventoryData securities : securitiesInventoryList) {
                            System.out.println("证券库存数据为："+securities);
                            //删除证券库存信息
                            securitiesInventoryService.deleteSecuritiesInventoryDate(dateTime);
//                            #{securitiesInventoryId,jdbcType=VARCHAR},
//                            #{fundId,jdbcType=VARCHAR},#{dateTime,jdbcType=VARCHAR},
//                            #{securitiesId,jdbcType=VARCHAR},
//                            #{securitiesName,jdbcType=VARCHAR},
//                            #{securityPeriodFlag},#{securitiesNum}
//                            ,#{price}
//                            ,#{total}
//                            ,#{securitiesInventoryDesc
                            //增加证券库存数据
                            SecuritiesInventory securitiesInventory1=new SecuritiesInventory();
                            //证券库存ID
                            securitiesInventory1.setSecuritiesInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SI));
                            //证券库存日期
                            securitiesInventory1.setDateTime(dateTime);
                            //证券信息表ID
                            securitiesInventory1.setSecuritiesId(securities.getSecuritiesId());
                            //基金表ID
                            securitiesInventory1.setFundId("000899");
                            //是否导入其他系统数据
//                            securitiesInventory1.setSecurityPeriodFlag(0);
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
                        List<TaInventoryData> taInventoryDataList=inventoryStatisticsMapper.selectTaInventory(dateTime,"000899");
                        taInventory=new InventoryStatistics(3,"TA库存","000899","admin",dateTime,taInventoryDataList.size(),"已统计");
                        for (TaInventoryData taInventoryData : taInventoryDataList) {
                            System.out.println("我是统计TA库存的操作,我统计的数据为："+taInventoryData);
                            //
                            taInventoryService.deleteTaInventoryDate(dateTime);

                            TaInventory taInventory1=new TaInventory();

                            taInventory1.setTaInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TI));
                            taInventory1.setFundId("000899");
                            taInventory1.setTaNum(taInventoryData.getTaNum());
                            taInventory1.setTaTotal(taInventoryData.getTaTotal());
                            taInventory1.setDateTime(dateTime);
                            taInventory1.setSecurityPeriodFlag(0);
                            taInventory1.setTaInventoryDesc("统计Ta库存");
                            System.out.println("ta库存的实体类："+taInventory1);
                            taInventoryService.insertTaInventory(taInventory1);
                        }




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
        list.add(taInventory);
        list.add(securitiesClosePayInventory);
        list.add(cashClosePayInventory);
        return list;
    }

}
