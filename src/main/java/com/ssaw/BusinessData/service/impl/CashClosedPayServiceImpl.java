package com.ssaw.BusinessData.service.impl;


import com.ssaw.BusinessData.entity.CashClosedPay;
import com.ssaw.BusinessData.mapper.CashClosedPayMapper;
import com.ssaw.BusinessData.service.CashClosedPayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName CashClosePayServiceImpl
 * @Description: TODO
 * @Author 阙魁
 * @Date create in 22:53 2020/9/6
 * @Version 1.0
 **/
@Service
@Transactional
public class CashClosedPayServiceImpl implements CashClosedPayService {
    @Resource
    CashClosedPayMapper cashClosedPayMapper;

    @Override
    public int insertCashClosedPay(CashClosedPay cashClosedPay) {
        return cashClosedPayMapper.insertCashClosedPay(cashClosedPay);
    }

    @Override
    public int deleteCashClosedPay(String cashClosedPayId) {
        String[] split = cashClosedPayId.split(",");
        ArrayList<Object> cashClosePayList=new ArrayList<>();
        for (String id : split) {
            cashClosePayList.add(id);
        }
        return cashClosedPayMapper.deleteCashClosedPay(cashClosePayList);
    }

    @Override
    public int updateCashClosedPay(CashClosedPay cashClosedPay) {
        return cashClosedPayMapper.updateCashClosedPay(cashClosedPay);
    }

    @Override
    public Map<String,Object> selectCashClosedPay(String pageSize, String page,String dateTime,String serviceType) {
        //创建一个结果集Map用于存放两个结果变量
        Map<String, Object> resultMap = new HashMap<>();
        //定义一个分页条数变量
        int v_pageSize = 0;
        //判断传入的pageSize是否为null/空
        if (pageSize != null && !pageSize.equals("")) {
            //通过Integer包装类将String类型转换成int基础数据类型
            v_pageSize = Integer.parseInt(pageSize);
        }
        //定义一个分页页码变量
        int v_page = 0;
        //判断传入的page是否为null/空
        if (page != null && !page.equals("")) {
            //通过Integer包装类将String类型转换成int基础数据类型
            v_page = Integer.parseInt(page);
        }

        StringBuffer sqlWhere=new StringBuffer();
        int v_serviceType=0;
        if (serviceType!=null && !serviceType.equals("")){
            v_serviceType=Integer.parseInt(serviceType);
            sqlWhere.append(" and serviceType =" +v_serviceType);
        }

        if (dateTime!=null && !dateTime.equals("")){

                sqlWhere.append(" and dateTime = '" +dateTime+"' ");

        }
//创建一个结果集用于接收数据库存储过程所需条件
        Map<String,Object> map = new HashMap<>();
        String sqlSelect="(select * from cashClosedPay c join fund f on f.fundId=c.fundId join account a on a.accountId=c.accountId ) ";
        map.put("p_tableName",sqlSelect);
        map.put("p_condition",sqlWhere.toString());
        map.put("p_pageSize",v_pageSize);
        map.put("p_page",v_page);
        map.put("p_count",0);
        map.put("p_cursor",null);

        //调用Mapper执行查询
        cashClosedPayMapper.selectCashClosedPay(map);
        //接收返回数据
        List<CashClosedPay> cashClosedPays = (List<CashClosedPay>) map.get("p_cursor");
        //接收返回总条数
        int count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("cashClosedPays",cashClosedPays);
        resultMap.put("count",count);
        return resultMap;
    }
}
