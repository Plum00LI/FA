package com.ssaw.DayEndProcessing.mapper;

import com.ssaw.BusinessData.entity.CashClosedPay;
import com.ssaw.DayEndProcessing.entity.AssetValuation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: TescComment
 * @Description:资产估值Dao类
 * @author: 瞿平
 * @version:1.0
 * @create: 2020-09-01
 */
@Mapper
public interface AssetValuationMapper {
    /**
     * 查询当日行情数据
     * @param assetValuation 查询所需的条件
     * @return
     */
    public List<AssetValuation> selectAssetValuation(AssetValuation assetValuation);

    /**
     * 通过估值日期查询是否当日是否证券以估值和已清算
     * @param today 估值日期
     * @param securitiesType 证券类型
     * @return 证券估值增值 和清算款的状态
     */
    @Select("select securitiesType form SecuritiesClosedPay where dateTime=#{dateTime} and securitiesType=#{securitiesType} group by securitiestype")
    public Integer selectSecuritiesType(@Param("today")String today,@Param("securitiesType")Integer securitiesType);

    @Select("select * form SecuritiesClosedPay where dateTime=#{dateTime}")
    public List<CashClosedPay> selectCashClosedPay(String today);

    /**
     * 查询先进应收应付库存数据
     * @param today 估值日期
     * @return
     */
    @Select("select securitiesType form SecuritiesClosedPay where dateTime=#{dateTime} and securitiesType in (1,2)" +
            "union"+
            "select businessType from cashClosedPayInventory where businessDate=#{businessDate} and businessType = 4")
    public List<Integer> selectAllSecuritiesType(String today);


    /**
     * 查询交易数据清算款
     * @param assetValuation 估值增值实体对象
     * @return
     */
    @Select("select dateTime,settlementDate,SUM((totalSum*flag)) totalSum,securitiesId,accountId"+
            "from transactionData where fundId=#{fundId} and dateTime<=#{toDay} and transactionDataMode in(1,2,3,4)"+
            "and #{toDay} < settlementDate group by securitiesId,dateTime,settlementDate,accountId")
    public List<AssetValuation> selectTransactionData(AssetValuation assetValuation);


    @Select("select sum(actualMoney) actualMoney,transactionType from taTransaction where dateTime<=#{toDay}"+
            "#{toDay} < settlementDate and fundId=#{fundId} group by fundId,accountId,transactionType")
    public List<AssetValuation> selectTaTransaction(AssetValuation assetValuation);


    /**
     * 删除Ta应收应付库存
     * @param map 多个条件
     * @return 受影响的行数（1：成功；0：失败）
     */
    public int deleteTAReceivables(Map map);
}
