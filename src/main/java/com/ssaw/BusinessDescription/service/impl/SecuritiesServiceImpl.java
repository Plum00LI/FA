package com.ssaw.BusinessDescription.service.impl;

import com.ssaw.BusinessDescription.entity.Securities;
import com.ssaw.BusinessDescription.entity.SecuritiesAndStock;
import com.ssaw.BusinessDescription.entity.Stock;
import com.ssaw.BusinessDescription.mapper.SecuritiesMapper;
import com.ssaw.BusinessDescription.service.SecuritiesService;
import com.ssaw.GlobalManagement.entity.UserInfo;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 债券参数
 * @type Securities的service的实现类
 * @author fusaiying
 * @date 2020-09-01
 * @version 1.0
 */
@Service
public class SecuritiesServiceImpl implements SecuritiesService {
    @Resource
    SecuritiesMapper securitiesMapper;
    //增加
    @Override
    public void insertSecurities(Securities securities) {
        securitiesMapper.insertSecurities(securities);
    }

    /**
     * 通过UserId删除用户的实现类方法
     * @param securitiesId 要删除用户的ID
     * @return 成功与否
     */
    @Override
    public boolean deleteSecurities(String securitiesId) {
        //定义一个用户ID变量
        int i = 0;
        //判断传入的userId是否为null/空
        if (securitiesId!=null&&!securitiesId.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            i=Integer.parseInt(securitiesId);
        }
        //调用Mapper执行删除，并接收影响条目数
        int result = securitiesMapper.deleteSecurities(i);
        //判断影响条目数是否不等于0
        if (result!=0){
            //不为0，返回成功
            return true;
        }
        //为0，返回失败
        return false;
    }

    //修改
    @Override
    public void updateSecurities(Securities securities) {
        securitiesMapper.updateSecurities(securities);
    }

    /**
     * 查询所有用户的实现类方法（带分页，返回数据和总条目数）
     * @param pageSize 当前查询页数
     * @param page 分页数据条目数
     * @return 查询的结果集Map
     */
    @Override
    public Map<String, Object> selectSecurities(String pageSize,String page) {
        //创建一个结果集Map用于存放两个结果变量
        Map<String, Object> resultMap = new HashMap<>();
        //定义一个分页条数变量
        int v_pageSize = 0;
        //判断传入的pageSize是否为null/空
        if (pageSize!=null&&!pageSize.equals("")){
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
        //创建一个Map，用于存储过程的调用传值
        Map<String,Object> map = new HashMap<>();
        //传入存储过程需要查询的表名
        String p_tableName="(select * from "+SysTableNameListUtil.SE+" se join "+SysTableNameListUtil.ST+" st on st.stockId=se.stockId)";
        map.put("p_tableName", p_tableName);
        //传入查询条件
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
        securitiesMapper.selectSecurities(map);
        //接收返回数据
        List<SecuritiesAndStock> Securities = (List<SecuritiesAndStock>) map.get("p_cursor");
        System.out.println("aa"+Securities);
        //接收返回总条数
        int v_count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("SecuritiesAndStock",Securities);
        resultMap.put("count",v_count);
        //返回结果集Map
        System.out.printf(resultMap.toString());
        return resultMap;
    }
}
