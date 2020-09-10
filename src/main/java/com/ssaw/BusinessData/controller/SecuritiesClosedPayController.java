package com.ssaw.BusinessData.controller;

import com.ssaw.BusinessData.entity.Market;
import com.ssaw.BusinessData.entity.SecuritiesClosedPay;
import com.ssaw.BusinessData.service.MarketService;
import com.ssaw.BusinessData.service.SecuritiesClosedPayService;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

/**
 *@program: FA
 *@description: 证券应收应付控制类
 *@author: 瞿平
 *@create: 2020-09-09 15:45
 **/
@RequestMapping("securitiesClosedPay")
@RestController
public class SecuritiesClosedPayController {
    //调用用户Biz对象
    //自动装配 按照类型自动装配
    @Resource
    SecuritiesClosedPayService securitiesClosedPayService;

    //调用工具类
    @Resource
    DbUtil dbUtil;

    @RequestMapping("selectSecuritiesClosedPay")
    public Map<String,Object> selectSecuritiesClosedPay(String page, String limit,String securitiesName,String securitiesId){
        System.out.println("证券应收应付分页查询控制器");
        Map<String,Object> map = securitiesClosedPayService.selectSecuritiesClosedPay(limit,page,securitiesName,securitiesId);
        List<SecuritiesClosedPay> securitiesClosedPayList = (List<SecuritiesClosedPay>) map.get("securitiesClosedPayList");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("count",count);
        hashMap.put("data",securitiesClosedPayList);
        System.out.println("信息的大小："+securitiesClosedPayList.size());
        return hashMap;
    }

    @RequestMapping("insertSecuritiesClosedPay")
    public int insertSecuritiesClosedPay(SecuritiesClosedPay securitiesClosedPay){
        System.out.println("新增的控制类");
        securitiesClosedPay.setSecuritiesClosedPayId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCP));
        System.out.println("添加"+securitiesClosedPay);
        int i = securitiesClosedPayService.insertSecuritiesClosedPay(securitiesClosedPay);
        System.out.println("证券应收应付新增的条数为"+i);
        return i;
    }


    @RequestMapping("updateSecuritiesClosedPay")
    public int updateSecuritiesClosedPay(SecuritiesClosedPay securitiesClosedPay){
        System.out.println("进入了修改的control");
        int i =securitiesClosedPayService.updateSecuritiesClosedPay(securitiesClosedPay);
        System.out.println("修改："+i);
        return i;
    }



    /**
     * 单行删除多行删除
     * @param securitiesClosedPayId
     * @return
     */
    @RequestMapping("deleteSecuritiesClosedPay")
    public int deleteSecuritiesClosedPay(@RequestParam("securitiesClosedPayId")String securitiesClosedPayId) {
        return securitiesClosedPayService.deleteSecuritiesClosedPay(securitiesClosedPayId);
    }
}
