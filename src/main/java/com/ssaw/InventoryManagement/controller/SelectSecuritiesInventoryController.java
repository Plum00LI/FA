package com.ssaw.InventoryManagement.controller;

import com.ssaw.BusinessData.entity.Market;
import com.ssaw.InventoryManagement.entity.SecuritiesInventory;
import com.ssaw.InventoryManagement.service.SecuritiesInventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
*@program: TescComment
*@Description:证券库存控制器,处理器
*@author: 瞿平
*@version:1.0
*@create: 2020-09-01
*/
@Controller
@RequestMapping("/selectSecuritiesInventory")
public class SelectSecuritiesInventoryController {
    //调用用户Biz对象
    //自动装配 按照类型自动装配
    @Resource
    SecuritiesInventoryService securitiesInventoryService;

    @RequestMapping("/selectSecuritiesInventory")
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

    @RequestMapping(value = "/insertSecuritiesInventory",method = {RequestMethod.GET,RequestMethod.POST})
    public int insertSecuritiesInventory(@ModelAttribute SecuritiesInventory securitiesInventory){
        int i = securitiesInventoryService.insertSecuritiesInventory(securitiesInventory);
        return i;
    }

    @RequestMapping(value = "/updateSecuritiesInventory",method = {RequestMethod.GET,RequestMethod.POST})
    public int updateSecuritiesInventory(@ModelAttribute SecuritiesInventory securitiesInventory){
        int i = securitiesInventoryService.updateSecuritiesInventory(securitiesInventory);
        return i;
    }

    @RequestMapping("/deleteSecuritiesInventory")
    public int deleteSecuritiesInventory(int securitiesInventoryId){
        int i = securitiesInventoryService.deleteSecuritiesInventory(securitiesInventoryId);
        return i;
    }
}
