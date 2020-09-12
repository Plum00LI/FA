package com.ssaw.DayEndProcessing.controller;

import com.ssaw.DayEndProcessing.entity.InventoryStatistics;
import com.ssaw.DayEndProcessing.service.InventoryStatisticsService;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName:    InventoryStatisticsController
 * Package:    com.ssaw.DayEndProcessing.controller
 * Description:
 * Version:
 * Datetime:    2020/9/9   17:19
 * Author:   SYT
 */
@RestController
public class InventoryStatisticsController {
    @Resource
    InventoryStatisticsService inventoryStatisticsService;

    @RequestMapping("/selectInventory")
    public HashMap selectInventory(String dateTime, String invId){
        //获得基金id
//        String fundId = SysTableNameListUtil.F;
        System.out.println("controller的dateTime"+dateTime);
        List<InventoryStatistics> inventoryEntities = inventoryStatisticsService.selectInventoryStatistics(dateTime,invId);
        HashMap userMap = new HashMap();
        userMap.put("count",10);
        userMap.put("code",0);
        userMap.put("msg","");
        userMap.put("data",inventoryEntities);
        return userMap;
    }

}
