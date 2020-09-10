package com.ssaw.InventoryManagement.service.impl;/**
 * @program: TescComment
 * @Description:实体类
 * @author: 瞿平
 * @create: 2020-09-01
 */

import com.ssaw.BusinessData.entity.Market;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import com.ssaw.InventoryManagement.entity.SecuritiesInventory;
import com.ssaw.InventoryManagement.mapper.SecuritiesInventoryMapper;
import com.ssaw.InventoryManagement.service.SecuritiesInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*@program: TescComment
*@Description:证券库存实现类
*@author: 瞿平
*@version:1.0
*@create: 2020-09-01
*/
@Service
public class SecuritiesInventoryServiceImpl implements SecuritiesInventoryService {
    @Resource
    SecuritiesInventoryMapper securitiesInventoryMapper;

    @Resource
    DbUtil dbUtil;

    @Override
    public List<SecuritiesInventory> selectSecuritiesInventory() {
        return securitiesInventoryMapper.selectSecuritiesInventory();
    }

    @Override
    public int insertSecuritiesInventory(SecuritiesInventory securitiesInventory) {
        securitiesInventory.setFundId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.F));
    return securitiesInventoryMapper.insertSecuritiesInventory(securitiesInventory);
    }

    @Override
    public int deleteSecuritiesInventory(String securitiesInventoryId) {
        return securitiesInventoryMapper.deleteSecuritiesInventory(securitiesInventoryId);
    }

    @Override
    public int updateSecuritiesInventory(SecuritiesInventory securitiesInventory) {
        return securitiesInventoryMapper.updateSecuritiesInventory(securitiesInventory);
    }

    @Override
    public Map<String, Object> selectSecuritiesInventoryInfo(String pageSize, String page,String securitiesId,String securitiesName,String fundId) {
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

        StringBuffer sqlWhere = new StringBuffer();
        if (securitiesId!=null && !securitiesId.equals("")){
            sqlWhere.append(" and securitiesId like '%"+securitiesId+"%'");
        }

        if (securitiesName!=null && !securitiesName.equals("")){
            sqlWhere.append(" and securitiesName like '%"+securitiesName+"%'");
        }

        if (fundId!=null && !fundId.equals("")){
            sqlWhere.append(" and fundId like '%"+fundId+"%'");
        }
        String tableName="(select * from " + SysTableNameListUtil.SI +" s join (select securitiesName，securitiesId from "+SysTableNameListUtil.SE+" )  e on s.securitiesId=e.securitiesId "
                +"join (select fundId from "+SysTableNameListUtil.F+" )  f on s.fundId=f.fundId)";
        System.out.println("语句"+tableName);

        //创建一个Map,用来调用存储过程
        Map<String, Object> map = new HashMap<>();
        //传入存储过程要查询的表名
        map.put("p_tableName", tableName);
        //传入查询条件
        map.put("p_condition", sqlWhere.toString());
        //传入分页显示条数
        map.put("p_pageSize", s_pageSize);
        //传入分页页码
        map.put("p_page", s_page);
        //创建out参数，返回数据总条数
        map.put("p_count", 0);
        //创建out游标变量，返回查询数据
        map.put("p_cursor", null);
        //调用mapper执行查询
        securitiesInventoryMapper.selectSecuritiesInventoryInfo(map);
        List<SecuritiesInventory> securitiesInventoryList = (List<SecuritiesInventory>) map.get("p_cursor");
        System.out.println("集合信息"+securitiesInventoryList.toString());
        //接收返回总条数
        int m_count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("securitiesInventoryList", securitiesInventoryList);
        resultMap.put("count", m_count);
        //返回结果集Map
        return resultMap;
    }
}

