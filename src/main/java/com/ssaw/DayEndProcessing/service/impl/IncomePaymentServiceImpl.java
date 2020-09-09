package com.ssaw.DayEndProcessing.service.impl;

import com.ssaw.BusinessData.entity.CashClosedPay;
import com.ssaw.DayEndProcessing.entity.BondInterestIncome;
import com.ssaw.DayEndProcessing.entity.CashInterestIncome;
import com.ssaw.DayEndProcessing.entity.PayTwoFees;
import com.ssaw.DayEndProcessing.mapper.IncomePaymentMapper;
import com.ssaw.DayEndProcessing.service.IncomePaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 收益支付 的impl层
 *
 * @version v1.0
 * @type:IncomePaymentServiceImpl
 * @author:阙魁
 * @create:2020-09-01
 */
@Service
@Transactional
public class IncomePaymentServiceImpl implements IncomePaymentService {

    @Resource
    IncomePaymentMapper incomePaymentMapper;


    @Override
    public Map<String, Object> selectCashInterestIncome(String pageSize, String page) {
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
        //查询表
        String sqlSelect=" (select * from cashClosedPayInventory c join account a on c.accountId=a.accountId ) ";
        //判断条件
        StringBuffer sqlWhere = new StringBuffer();

        sqlWhere.append(" and businessType in (3) ");

        //创建一个Map，用于存储过程的调用传值
        Map<String, Object> map = new HashMap<>();
        //传入存储过程需要查询的表名
        map.put("p_tableName", sqlSelect);
        //传入查询条件
        map.put("p_condition", "");
        //传入分页显示条数
        map.put("p_pageSize", v_pageSize);
        //传入分页页码
        map.put("p_page", v_page);
        //创建out参数，返回数据总条数
        map.put("p_count", 0);
        //创建out游标变量，返回查询数据
        map.put("p_cursor", null);

        incomePaymentMapper.selectCashInterestIncome(map);
        //接收返回数据
        List<CashInterestIncome> cashInterestIncomes = (List<CashInterestIncome>) map.get("p_cursor");
        //接收返回总条数
        int count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("cashInterestIncomes",cashInterestIncomes);
        resultMap.put("count",count);
        System.out.println("实现类："+cashInterestIncomes);
        System.out.println(count);
        return resultMap;
    }

    @Override
    public Map<String, Object> selectBondInterestIncome(String pageSize, String page) {
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
        //查询表
        String sqlSelect=" (select * from SECURITIESCLOSEDPAYINVENTORY s join account a on s.accountId=a.accountId join securities se on se.securitiesId= s.securitiesId ) ";
        //判断条件
        StringBuffer sqlWhere = new StringBuffer();

        sqlWhere.append(" and securitiesType in (3) ");

        //创建一个Map，用于存储过程的调用传值
        Map<String, Object> map = new HashMap<>();
        //传入存储过程需要查询的表名
        map.put("p_tableName", sqlSelect);
        //传入查询条件
        map.put("p_condition", "");
        //传入分页显示条数
        map.put("p_pageSize", v_pageSize);
        //传入分页页码
        map.put("p_page", v_page);
        //创建out参数，返回数据总条数
        map.put("p_count", 0);
        //创建out游标变量，返回查询数据
        map.put("p_cursor", null);

        incomePaymentMapper.selectBondInterestIncome(map);
        //接收返回数据
        List<BondInterestIncome> bondInterestIncomes = (List<BondInterestIncome>) map.get("p_cursor");
        //接收返回总条数
        int count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("bondInterestIncomes",bondInterestIncomes);
        resultMap.put("count",count);
        System.out.println("实现类："+bondInterestIncomes);
        System.out.println(count);
        return resultMap;
    }

    @Override
    public Map<String, Object> selectPayTwoFees(String pageSize, String page) {
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
        //查询表
        String sqlSelect=" (select * from cashClosedPayInventory c join account a on c.accountId=a.accountId ) ";
        //判断条件
        StringBuffer sqlWhere = new StringBuffer();

        sqlWhere.append(" and businessType in (1,2) ");

        //创建一个Map，用于存储过程的调用传值
        Map<String, Object> map = new HashMap<>();
        //传入存储过程需要查询的表名
        map.put("p_tableName", sqlSelect);
        //传入查询条件
        map.put("p_condition", "");
        //传入分页显示条数
        map.put("p_pageSize", v_pageSize);
        //传入分页页码
        map.put("p_page", v_page);
        //创建out参数，返回数据总条数
        map.put("p_count", 0);
        //创建out游标变量，返回查询数据
        map.put("p_cursor", null);

        incomePaymentMapper.selectPayTwoFees(map);
        //接收返回数据
        List<PayTwoFees> payTwoFees = (List<PayTwoFees>) map.get("p_cursor");
        //接收返回总条数
        int count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("payTwoFees",payTwoFees);
        resultMap.put("count",count);
        System.out.println("实现类："+payTwoFees);
        System.out.println(count);
        return resultMap;
    }


}
