package com.ssaw.DayEndProcessing.service;

import com.ssaw.DayEndProcessing.entity.AssetValuation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: TescComment
 * @Description:资产估值Biz类
 * @author: 瞿平
 * @version:1.0
 * @create: 2020-09-01
 */
@Service
@Transactional
public interface AssetValuationService {
    /**
     * 查询当日行情数据
     * @param assetValuation 查询所需条件  资产估值实体对象
     * @return
     */
    public List<AssetValuation> selectAssetValuation(AssetValuation assetValuation);

    /**
     * 查询TA交易清算款数据
     * @param assetValuation 查询所需条件  资产估值实体对象
     * @return
     */
    public List<AssetValuation> selectTaTransaction(AssetValuation assetValuation);

    /**
     * 通过估值日期查询是否当日是否证券以估值和已清算
     * @param today 估值日期
     * @return 证券估值增值 和清算款的状态
     */
    public List<Integer> selectSecuritiesType(String today);
}
