package com.ssaw.InventoryManagement.controller;

import com.ssaw.BusinessData.entity.Market;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import com.ssaw.InventoryManagement.entity.SecuritiesInventory;
import com.ssaw.InventoryManagement.service.SecuritiesInventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*@program: TescComment
*@Description:证券库存控制器,处理器
*@author: 瞿平
*@version:1.0
*@create: 2020-09-01
*/
@RestController
@RequestMapping("securitiesInventory")
public class SecuritiesInventoryController {
    //调用用户Biz对象
    //自动装配 按照类型自动装配
    @Resource
    SecuritiesInventoryService securitiesInventoryService;

    //调用工具类
    @Resource
    DbUtil dbUtil;


    @RequestMapping("selectSecuritiesInventory")
    public HashMap selectSecuritiesInventoryService(){
        System.out.println("证券库存查询控制器");
        HashMap hashMap = new HashMap();
        List<SecuritiesInventory> securitiesInventories = securitiesInventoryService.selectSecuritiesInventory();
        hashMap.put("count",10);
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("data",securitiesInventories);
        System.out.println("信息的大小："+securitiesInventories.size());
        return hashMap;
    }

    /**
     * 分页查询
     * @param page 页码
     * @param limit 每页条数
     * @param accountId 账户ID
     * @param securitiesName 证券名称
     * @return
     */
    @RequestMapping("selectSecuritiesInventoryInfo")
    public Map<String,Object> selectSecuritiesInventoryInfo(String page, String limit,String accountId,String securitiesName){
        System.out.println("行情数据分页查询控制器");
        Map<String,Object> map = securitiesInventoryService.selectSecuritiesInventoryInfo(limit,page,accountId,securitiesName);
        List<SecuritiesInventory> securitiesInventoryList = (List<SecuritiesInventory>) map.get("securitiesInventoryList");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("count",count);
        hashMap.put("data",securitiesInventoryList);
        System.out.println("信息的大小："+securitiesInventoryList.size());
        return hashMap;
    }

    /**
     * 增加
     * @param securitiesInventory 证券库存实体类
     * @return
     */
    @RequestMapping("insertSecuritiesInventory")
    public int insertSecuritiesInventory(SecuritiesInventory securitiesInventory){
        System.out.println("增加的方法");
        securitiesInventory.setSecuritiesInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SI));
        return securitiesInventoryService.insertSecuritiesInventory(securitiesInventory);
    }

    @RequestMapping(value = "updateSecuritiesInventory",method = {RequestMethod.GET,RequestMethod.POST})
    public int updateSecuritiesInventory(@ModelAttribute SecuritiesInventory securitiesInventory){
        System.out.println("修改的方法");
        return securitiesInventoryService.updateSecuritiesInventory(securitiesInventory);
    }

    @RequestMapping("deleteSecuritiesInventory")
    public int deleteSecuritiesInventory(String securitiesInventoryId){
        int i = securitiesInventoryService.deleteSecuritiesInventory(securitiesInventoryId);
        return i;
    }
}
