package com.ssaw.CashManagement.service.impl;

import com.ssaw.CashManagement.entity.BankTreasurer;
import com.ssaw.CashManagement.entity.TransferMoney;
import com.ssaw.CashManagement.mapper.TransferMoneyMapper;
import com.ssaw.CashManagement.service.TransferMoneyService;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*@program:TescComment
*@Eescription:划款指令
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Service
@Transactional
public class TransferMoneyServiceImpl implements TransferMoneyService {
    @Resource
    TransferMoneyMapper transferMoneyMapper;


    @Override
    public Map<String, Object> selectTransferMoney(String pageSize, String page) {
        //创建一个结果集Map用于存放两个结果变量
        Map<String,Object> resultMap=new HashMap<>();
        //定义一个分页条数变量
        int v_pageSize=0;
        //判断传入的pageSize是否为空/null
        if (pageSize!=null && !pageSize.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_pageSize=Integer.parseInt(pageSize);
        }
        //定义一个分页页码变量
        int v_page = 0;
        //判断传入的page是否为null/空
        if (page!=null&&!page.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_page=Integer.parseInt(page);
        }
        //创建一个Map 用于存款过程的调用传值
        Map<String,Object> map=new HashMap<>();
        //传入存储过程需要查询的表名
        map.put("p_tableName","(select transferMoney.*,account.accountName outAccountName, (select accountName from account where accountId=transferMoney.inAccountId) inAccountName from transferMoney join account on transferMoney.outAccount = account.accountId)");
        //传入查询的条件
        map.put("p_condition","");
        //传入分页显示条数
        map.put("p_pageSize",v_pageSize);
        //传入分页页码
        map.put("p_page",v_page);
        //创建out参数，返回数据总条数
        map.put("p_count",0);
        //创建out游标变量，返回查询数据
        map.put("p_cursor",null);
        //调用Mapper执行查询
        transferMoneyMapper.selectTransferMoney(map);
        //接收返回数据
        List<TransferMoney> transferMoneyList= (List<TransferMoney>) map.get("p_cursor");

        //接收返回总条数
        int v_count= (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("transferMoneyList",transferMoneyList);
        resultMap.put("count",v_count);
        System.out.println(resultMap.get("transferMoneyList"));
        return resultMap;
    }

    @Override
    public int insertTransferMoney(TransferMoney transferMoney) {
        return transferMoneyMapper.insertTransferMoney(transferMoney);
    }

    @Override
    public int updateTransferMoney(TransferMoney transferMoney) {
        return transferMoneyMapper.updateTransferMoney(transferMoney);
    }

    @Override
    public int deleteTransferMoney() {
        return transferMoneyMapper.deleteTransferMoney();
    }
}
