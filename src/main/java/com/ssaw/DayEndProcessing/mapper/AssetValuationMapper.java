package com.ssaw.DayEndProcessing.mapper;

import com.ssaw.BusinessData.entity.CashClosedPay;
import com.ssaw.DayEndProcessing.entity.AssetValuation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: TescComment
 * @Description:资产估值Dao类
 * @author: 瞿平
 * @version:1.0
 * @create: 2020-09-01
 */
@Service
public interface AssetValuationMapper {
    /**
     * 查询当日行情数据
     * @param assetValuation 查询所需的条件
     * @return
     */
    /*public List<AssetValuation> selectAssetValuation(AssetValuation assetValuation);*/

    /**
     * 通过估值日期查询是否当日是否证券以估值和已清算
     * @param today 估值日期
     * @param securitiesType 证券类型
     * @return 证券估值增值 和清算款的状态
     */
    @Select("select securitiesType form cashClosedPay where dateTime=#{dateTime} and securitiesType=#{securitiesType} group by securitiestype")
    public Integer selectSecuritiesType(@Param("today")String today,@Param("securitiesType")Integer securitiesType);

    @Select("select * form cashClosedPay where dateTime=#{dateTime}")
    public List<CashClosedPay> selectCashClosedPay(String today);

    @Select("")
    public List<Integer> selectAllSecuritiesType(String today);
}
