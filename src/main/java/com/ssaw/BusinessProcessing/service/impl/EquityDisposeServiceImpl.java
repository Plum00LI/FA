package com.ssaw.BusinessProcessing.service.impl;

import com.ssaw.BusinessData.entity.EquityData;
import com.ssaw.BusinessData.mapper.EquityDataMapper;
import com.ssaw.BusinessProcessing.entity.EquityDispose;
import com.ssaw.BusinessProcessing.mapper.EquityDisposeMapper;
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

    @Override
    public Map<String, Object> selectEquityDispose(String pageSize, String page, String equityDataId2, String disposeStatus) {
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
        int v_disposeStatus = 0;
        if (disposeStatus!=null&&!disposeStatus.equals("")){
            v_disposeStatus=Integer.parseInt(disposeStatus);
            sqlWhere.append(" and disposeStatus like '%"+v_disposeStatus+"%'" );
        }



        //多表查询
        String p_tableName="(select * from "+SysTableNameListUtil.SI+" s "+
                "join (select * from "+SysTableNameListUtil.ED+") e "+
                "on s.securitiesId=e.securityId)";



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
            int disposeStatus = equityDispose2.getDisposeStatus();
            String equityDataId = equityDispose2.getEquityDataId();
            if (disposeStatus==0){
                equityDisposeMapper.updateEquityDispose(equityDataId,1);
            }else if (disposeStatus==1){
                equityDisposeMapper.updateEquityDispose(equityDataId,0);
            }
        }
        return 1;
    }

}
