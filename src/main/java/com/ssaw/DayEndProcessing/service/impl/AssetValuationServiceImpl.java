package com.ssaw.DayEndProcessing.service.impl;

import com.ssaw.BusinessData.entity.SecuritiesClosedPay;
import com.ssaw.BusinessData.service.CashClosedPayService;
import com.ssaw.BusinessData.service.SecuritiesClosedPayService;
import com.ssaw.DayEndProcessing.entity.AssetValuation;
import com.ssaw.DayEndProcessing.mapper.AssetValuationMapper;
import com.ssaw.DayEndProcessing.service.AssetValuationService;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import com.ssaw.InventoryManagement.entity.SecuritiesClosedPayInventory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 *@program: FA
 *@description: 资产估值实现类
 *@author: 瞿平
 *@create: 2020-09-11 16:54
 **/
@Service
public class AssetValuationServiceImpl implements AssetValuationService {
    @Resource
    AssetValuationMapper assetValuationMapper;

    @Resource
    SecuritiesClosedPayService securitiesClosedPayService;

    @Resource
    CashClosedPayService cashClosedPayService;

    @Resource
    DbUtil dbUtil;

    @Override
    public List<AssetValuation> selectAssetValuation(AssetValuation assetValuation) {
        //获取基金编号
        assetValuation.setFundId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.F));
        System.out.println("前端传过来的日期："+assetValuation.getToDay());
        //查询估值增值的收据
        List<AssetValuation> assetValuationList = assetValuationMapper.selectAssetValuation(assetValuation);
        //得到增值估值的数据
        for (AssetValuation assetValuation1:assetValuationList){
            //应付-1 应收1 默认是1
            Integer flag = 1;
            //估值增值小于0
            if (assetValuation1.getAssetValuationVal()<0){
                //把估值转成整数
                assetValuation1.setAssetValuationVal(Math.abs(assetValuation1.getAssetValuationVal()));
                //状态为应付
                flag = -1;
            }
            System.out.println("估值增值的值："+assetValuation1.getAssetValuationVal());
            System.out.println("当前状态："+flag);
            //证券应收应付库存
            SecuritiesClosedPayInventory securitiesClosedPayInventory = new SecuritiesClosedPayInventory("",
                    assetValuation1.getFundId(), assetValuation1.getSecuritiesId(),assetValuation.getToDay(),1,flag,
                    new BigDecimal(assetValuation1.getAssetValuationVal()+""),null,1);
        }
        return null;
    }

    @Override
    public List<AssetValuation> selectTaTransaction(AssetValuation assetValuation) {
        return null;
    }

    @Override
    public List<Integer> selectSecuritiesType(String today) {
        return null;
    }
}
