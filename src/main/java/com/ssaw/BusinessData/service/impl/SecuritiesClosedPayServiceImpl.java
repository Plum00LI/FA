package com.ssaw.BusinessData.service.impl;

import com.ssaw.BusinessData.entity.Market;
import com.ssaw.BusinessData.entity.SecuritiesClosedPay;
import com.ssaw.BusinessData.mapper.SecuritiesClosedPayMapper;
import com.ssaw.BusinessData.service.SecuritiesClosedPayService;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import com.ssaw.InventoryManagement.entity.SecuritiesInventory;
import com.ssaw.InventoryManagement.mapper.SecuritiesInventoryMapper;
import com.ssaw.InventoryManagement.service.SecuritiesInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

/**
 *@program: FA
 *@description: 证券应收应付实现类
 *@author: 瞿平
 *@create: 2020-09-09 10:51
 **/
@Service
public class SecuritiesClosedPayServiceImpl implements SecuritiesClosedPayService {
    @Resource
    SecuritiesClosedPayMapper securitiesClosedPayMapper;

    @Resource
    DbUtil dbUtil;


    @Override
    public Map<String, Object> selectSecuritiesClosedPay(String pageSize, String page) {
        //创建一个结果集Map,用于存放两个结果变量
        Map<String, Object> resultMap = new HashMap<>();
        //定义一个分页条数变量
        int s_pageSize = 0;
        //判断传入的pageSize是否为null
        if (pageSize != null && !pageSize.equals("")) {
            //强转为int类型
            s_pageSize = Integer.parseInt(pageSize);
        }
        //定义一个分页码变量
        int s_page = 0;
        //判断传入的page是否为空
        if (page != null && !page.equals("")) {
            //强转为int类型
            s_page = Integer.parseInt(page);
        }

        //创建一个Map,用来调用存储过程
        Map<String, Object> map = new HashMap<>();
        //传入存储过程要查询的表名
        map.put("p_tableName", "securitiesClosedPay");
        //传入查询条件
        map.put("p_condition", "");
        //传入分页显示条数
        map.put("p_pageSize", s_pageSize);
        //传入分页页码
        map.put("p_page", s_page);
        //创建out参数，返回数据总条数
        map.put("p_count", 0);
        //创建out游标变量，返回查询数据
        map.put("p_cursor", null);
        //调用mapper执行查询
        securitiesClosedPayMapper.selectSecuritiesClosedPay(map);
        List<SecuritiesClosedPay> securitiesClosedPayList = (List<SecuritiesClosedPay>) map.get("p_cursor");
        System.out.println("集合信息"+securitiesClosedPayList.toString());
        //接收返回总条数
        int m_count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("securitiesInventoryList", securitiesClosedPayList);
        resultMap.put("count", m_count);
        //返回结果集Map
        return resultMap;
    }

    @Override
    public int insertSecuritiesClosedPay(SecuritiesClosedPay securitiesClosedPay) {
        return securitiesClosedPayMapper.insertSecuritiesClosedPay(securitiesClosedPay);
    }

    @Override
    public int updateSecuritiesClosedPay(SecuritiesClosedPay securitiesClosedPay) {
        return securitiesClosedPayMapper.updateSecuritiesClosedPay(securitiesClosedPay);
    }

    @Override
    public int deleteSecuritiesClosedPay(String securitiesClosedPayId) {
        //切割字符串
        String[] split = securitiesClosedPayId.split(",");
        ArrayList<Object> list=new ArrayList<>();
        for (String id : split) {
            list.add(id);
        }
        return securitiesClosedPayMapper.deleteSecuritiesClosedPay(list);
    }
}
