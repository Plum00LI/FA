package com.ssaw.BusinessData.service.impl;

import com.ssaw.BusinessData.entity.Deposit;
import com.ssaw.BusinessData.mapper.DepositMapper;
import com.ssaw.BusinessData.service.DepositService;
import com.ssaw.BusinessDescription.entity.Account;
import com.ssaw.CashManagement.entity.BankTreasurer;
import com.ssaw.CashManagement.mapper.BankTreasurerMapper;
import com.ssaw.CashManagement.service.BankTreasurerService;
import com.ssaw.GlobalManagement.util.DateTimeUtil;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*@program:TescComment
*@Eescription:存款业务
*@author:黄庆
*@Version:1.0
*@create:2020-09-01
*/
@Service
@Transactional
public class DepositServiceImpl implements DepositService {
   @Resource
   DepositMapper depositMapper;
   @Resource
    BankTreasurerMapper bankTreasurerMapper;
   @Resource
    DbUtil dbUtil;

    @Override
    public Map<String, Object> selectDeposit(String pageSize, String page,String businessType,String endDate) {
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

        map.put("p_tableName","(select deposit.*,account.accountName outAccountName, (select accountName from account where accountId=deposit.inAccountId) inAccountName from deposit join account on deposit.outAccountId = account.accountId)");
        //传入查询的条件
        StringBuffer sqlWhere=new StringBuffer();
        if (businessType!=null && !businessType.equals("")){
            sqlWhere.append(" and businessType="+businessType);
        }
        if (endDate!=null && !endDate.equals("")){
            sqlWhere.append(" and endDate='"+endDate+"'");
        }
        map.put("p_condition",sqlWhere.toString());
        //传入分页显示条数
        map.put("p_pageSize",v_pageSize);
        //传入分页页码
        map.put("p_page",v_page);
        //创建out参数，返回数据总条数
        map.put("p_count",0);
        //创建out游标变量，返回查询数据
        map.put("p_cursor",null);
        //调用Mapper执行查询
        depositMapper.selectDeposit(map);
        //接收返回数据
        List<Deposit> depositList= (List<Deposit>) map.get("p_cursor");

        //接收返回总条数
        int v_count= (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("depositList",depositList);
        resultMap.put("count",v_count);
        System.out.println(resultMap.get("depositList"));
        return resultMap;
    }

    @Override
    public int insertDeposit(Deposit deposit) {
        deposit.setDepositId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.DE));
        BankTreasurer bankTreasurer=new BankTreasurer();
        //流出账户
        bankTreasurer.setBankTreasurerId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.BT));
        bankTreasurer.setFundId(deposit.getFundId());
        bankTreasurer.setTotalPrice(deposit.getMoney());
        bankTreasurer.setAccountId(deposit.getOutAccountId());
        bankTreasurer.setAccountName(deposit.getOutAccountName());
        //调拨日期为存款业务的业务时间
        bankTreasurer.setDbTime(deposit.getBusinessDate());
        //业务日期为当天的日期
        String date=DateTimeUtil.getSystemDateTime("yyyy-MM-dd");
        bankTreasurer.setDateTime(date);
        bankTreasurer.setAllocatingType(5);
        bankTreasurer.setBusinessId(deposit.getDepositId());
        bankTreasurer.setBankTreasurerDesc("");
        bankTreasurer.setFlag(-1);
        bankTreasurerMapper.insertBankTreasurer(bankTreasurer);
        //流入账户
        bankTreasurer.setAccountId(deposit.getInAccountId());
        bankTreasurer.setAccountName(deposit.getInAccountName());
        bankTreasurer.setFlag(1);
        bankTreasurerMapper.insertBankTreasurer(bankTreasurer);
        System.out.println(bankTreasurer);
        return depositMapper.insertDeposit(deposit);
    }

    @Override
    public int updateDeposit(Deposit deposit) {
        System.out.println("deposit进去了===========");
        System.out.println(deposit);
        //存款业务的处理状态变为
        deposit.setFlag(1);
        //存款业务的到期处理 产生资金调拨 流入遍流出 流出变流入
        BankTreasurer bankTreasurer=new BankTreasurer();
        //流出账户
        bankTreasurer.setBankTreasurerId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.BT));
        bankTreasurer.setFundId(deposit.getFundId());
        bankTreasurer.setTotalPrice(deposit.getMoney());
        bankTreasurer.setAccountId(deposit.getOutAccountId());
        bankTreasurer.setAccountName(deposit.getOutAccountName());
        //调拨日期为存款业务的业务时间
        bankTreasurer.setDbTime(deposit.getBusinessDate());
        //业务日期为当天的日期
        String date=DateTimeUtil.getSystemDateTime("yyyy-MM-dd");
        bankTreasurer.setDateTime(date);
        bankTreasurer.setAllocatingType(5);
        bankTreasurer.setBusinessId(deposit.getDepositId());
        bankTreasurer.setBankTreasurerDesc("");
        bankTreasurer.setFlag(1);
        bankTreasurerMapper.insertBankTreasurer(bankTreasurer);
        //流入账户
        bankTreasurer.setAccountId(deposit.getInAccountId());
        bankTreasurer.setAccountName(deposit.getInAccountName());
        bankTreasurer.setFlag(-1);
        bankTreasurerMapper.insertBankTreasurer(bankTreasurer);
        return depositMapper.updateDeposit(deposit);
    }


    @Override
    public int deleteDeposit(String depositId) {
        bankTreasurerMapper.deleteBankTreasurerByDepositId(depositId);
        return depositMapper.deleteDeposit(depositId);
    }
}
