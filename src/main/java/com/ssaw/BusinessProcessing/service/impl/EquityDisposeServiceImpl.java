package com.ssaw.BusinessProcessing.service.impl;

import com.ssaw.BusinessData.entity.EquityData;
import com.ssaw.BusinessData.entity.TransactionData;
import com.ssaw.BusinessData.mapper.EquityDataMapper;
import com.ssaw.BusinessData.mapper.TransactionDataMapper;
import com.ssaw.BusinessProcessing.entity.EquityDispose;
import com.ssaw.BusinessProcessing.entity.Settlement;
import com.ssaw.BusinessProcessing.mapper.EquityDisposeMapper;
import com.ssaw.BusinessProcessing.mapper.SettlementMapper;
import com.ssaw.BusinessProcessing.service.EquityDisposeService;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import com.ssaw.GlobalManagement.util.SysUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ssaw.GlobalManagement.util.SysUtil.jsonToArrayList;

/**
 * @program:TescComment
 * @Description:实体类
 * @author:孙浩
 * @create:2020-09-01
 */
@Service
@Transactional
public class EquityDisposeServiceImpl implements EquityDisposeService {
    @Resource
    EquityDisposeMapper equityDisposeMapper;
    @Resource
    DbUtil dbUtil;
    @Resource
    TransactionDataMapper transactionDataMapper;

    @Override
    public Map<String, Object> selectEquityDispose(String pageSize, String page, String equitiesType,String equitiesExright, String disposeStatus) {
        //创建一个结果集Map用于存放两个结果变量
        Map<String, Object> resultMap = new HashMap<>();
        //定义一个分页条数变量
        int v_pageSize = 0;
        //判断v_pageSize是否为空
        if (pageSize != null && !pageSize.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_pageSize=Integer.parseInt(pageSize);
        }
        //定义一个分页页码变量
        int v_page = 0;
        //判断传入的page是否为null/空
        if (page != null && !page.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_page=Integer.parseInt(page);
        }


        StringBuffer sqlWhere=new StringBuffer();
        int v_equitiesType = 0;
        if(equitiesExright != null && !equitiesExright.equals("")){
            sqlWhere.append(" AND equitiesExright LIKE  '%"+equitiesExright+"%'" );
        }
        if(equitiesType != null && !equitiesType.equals("")){
            v_equitiesType=Integer.parseInt(equitiesType);
            sqlWhere.append(" AND equitiesType LIKE  '%"+v_equitiesType+"%'" );
        }
        int v_disposeStatus = 0;
        if (disposeStatus!=null&&!disposeStatus.equals("")){
            v_disposeStatus=Integer.parseInt(disposeStatus);
            sqlWhere.append(" and disposeStatus like '%"+v_disposeStatus+"%'" );
        }



        //多表查询
        String p_tableName = "(select ((SECURITIESNUM*qysj.PROPORTION)/100) as settlementAmount,SECURITIESID,qysj.EQUITYDATAID,qysj.SECURITIESNAME,qysj.EQUITIESTYPE,qysj.EQUITIESEXRIGHT,qysj.RECEIVEDDATE,qysj.PROPORTION,qysj.DISPOSESTATUS,qysj.SECURITYID,zjkc.SECURITIESNUM " +
                "from (select * from "+SysTableNameListUtil.SI+") zjkc " +
                "full join (select PROPORTION,SECURITYID,EQUITYDATAID,EQUITIESTYPE,EQUITIESEXRIGHT,RECEIVEDDATE,DISPOSESTATUS,s.SECURITIESNAME " +
                "from "+SysTableNameListUtil.ED+" join (select * from "+SysTableNameListUtil.SE+") s on equityData.SECURITYID=s.SECURITIESID) qysj " +
                "on qysj.SECURITYID=zjkc.SECURITIESID)";



        //创建一个Map，用于存储过程的调用传值
        Map<String,Object> map = new HashMap<>();
        //传入存储过程需要的查询的表名
        map.put("p_tableName",p_tableName);
        //传入查询条件
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
        System.out.println("asd"+map.toString());
        equityDisposeMapper.selectEquityDispose(map);
        //接收返回数据
        List<EquityDispose> equityDisposeList = (List<EquityDispose>) map.get("p_cursor");
        //接收返回总条数
        int v_count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("equityDisposeList",equityDisposeList);
        resultMap.put("count",v_count);
        System.out.println(resultMap.get("p_condition"));
        System.out.println(resultMap);
        //返回结果集Map
        return resultMap;
    }

    @Override
    public int updateEquityDispose(String equityDisPose) {
        List<EquityDispose> equityDisposeList = SysUtil.jsonToArrayList(equityDisPose, EquityDispose.class);
        for (EquityDispose equityDispose2 : equityDisposeList) {
            //new 一个交易数据的实体类对象
            TransactionData transactionData = new TransactionData();
            //参数赋值
            transactionData.setTransactionDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TD));//交易数据ID
            transactionData.setDateTime(equityDispose2.getEquitiesExright());//业务日期
            transactionData.setNum(1000.0);//交易数量
            transactionData.setPrice(12.0);//交易单价
            transactionData.setTotalSum(1200.00);//交易总金额
            transactionData.setNetReceipts(12000.0);//实收金额
            transactionData.setSettlementDate(equityDispose2.getReceivedDate());//到账日期
            transactionData.setAccountName(equityDispose2.getAccountName());//账户名称
            transactionData.setSecuritiesName(equityDispose2.getSecuritiesName());//证券名称
            transactionData.setBrokersName("长城证券");//券商名称
            transactionData.setBrokersName("长城证券");
            transactionData.setFundId("000899");//基金代码
            transactionData.setFundName("华宝高端制造股票型证券投资基金");//基金名称
            transactionData.setSecuritiesId("600031");//证券ID
            transactionData.setBrokersId("10050000");//券商ID
            transactionData.setSeateId("10050000001");//席位ID
            transactionData.setSeateName("长城上海");//席位名称
            transactionData.setAccountId("000899001");//账户ID
            transactionData.setBlankName("中国建设银行");//银行名称
            transactionData.setFlag(1);//交易标识
            transactionData.setCommission(0.0);//佣金费用
            transactionData.setTransfer(0.0);//过户费（交易所）
            transactionData.setBrokerage(0.0);//经手费（交易所）
            transactionData.setStamp(0.0);//印花税（上交国家的税）
            transactionData.setManagement(0.0);//征管费（上交国家的税）
            transactionData.setSecurity(0.0);//证券利息
            transactionData.setTransactionDataDesc("");//备注
            transactionData.setTransactionDataMode(equityDispose2.getEquitiesType());//交易方式
            transactionData.setStatus(equityDispose2.getDisposeStatus());//处理状态




            int disposeStatus = equityDispose2.getDisposeStatus();
            String equityDataId = equityDispose2.getEquityDataId();
            if (disposeStatus==0){
                equityDisposeMapper.updateEquityDispose(equityDataId,1);
                transactionDataMapper.insertTransactionData(transactionData);
            }
        }
        return 1;
    }

    @Override
    public int updateEquityDisposeTwo(String equityDisPose) {
        List<EquityDispose> equityDisposeList = SysUtil.jsonToArrayList(equityDisPose, EquityDispose.class);
        for (EquityDispose equityDispose2 : equityDisposeList) {
            int disposeStatus = equityDispose2.getDisposeStatus();
            String equityDataId = equityDispose2.getEquityDataId();
            if (disposeStatus==1){
                equityDisposeMapper.updateEquityDispose(equityDataId,0);
                transactionDataMapper.deleteTransactionData(equityDataId);
            }
        }
        return 1;
    }
}
