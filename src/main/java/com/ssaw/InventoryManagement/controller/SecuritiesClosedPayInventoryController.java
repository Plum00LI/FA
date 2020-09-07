package com.ssaw.InventoryManagement.controller;

import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.InventoryManagement.service.SecuritiesClosedPayInventoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ClassName:    SecuritiesClosedPayInventoryController
 * Package:    com.ssaw.InventoryManagement.controller
 * Description:
 * Version:
 * Datetime:    2020/9/6   21:09
 * Author:   SYT
 */
@RestController
@RequestMapping("/securitiesClosedPayInventory")
public class SecuritiesClosedPayInventoryController {
    @Resource
    SecuritiesClosedPayInventoryService securitiesClosedPayInventoryService;

    @Resource
    DbUtil dbUtil;

    @RequestMapping("/select")
    public Map<String,Object> selectSecuritiesClosedPayInventory(String page, String limit,String securitiesType,String dateTime){
         return null;
    }
}
