package com.ssaw.InventoryManagement.controller;

import com.ssaw.InventoryManagement.entity.CashClosedPayInventory;
import com.ssaw.InventoryManagement.service.CashClosedPayInventoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @program:现金应收应付库存模块
 * @Description:控制类
 * @author:孙浩
 * @create:2020-09-01
 */
@RestController
public class CashClosedPayInventoryController {
    @Resource
    CashClosedPayInventoryService cashClosedPayInventoryService;

    @RequestMapping("/insertCashClosedPayInventory")
    public int insertCashClosedPayInventory(CashClosedPayInventory cashClosedPayInventory){
        int j = cashClosedPayInventoryService.insertCashClosedPayInventory(cashClosedPayInventory);
        return j;
    }

    @RequestMapping("/deleteCashClosedPayInventory")
    public void deleteCashClosedPayInventory(int crcsId){
        cashClosedPayInventoryService.deleteCashClosedPayInventory(crcsId);
    }

    @RequestMapping("/updateCashClosedPayInventory")
    public int updateCashClosedPayInventory(CashClosedPayInventory cashClosedPayInventory){
        int j = cashClosedPayInventoryService.updateCashClosedPayInventory(cashClosedPayInventory);
        return j;
    }

    @RequestMapping("/selectCashClosedPayInventory")
    public HashMap selectCashClosedPayInventory(){
        List<CashClosedPayInventory> cashClosedPayInventoryList = cashClosedPayInventoryService.selectCashClosedPayInventory();
        HashMap cashClosedPayInventoryMap = new HashMap();
        cashClosedPayInventoryMap.put("count",10);
        cashClosedPayInventoryMap.put("code",0);
        cashClosedPayInventoryMap.put("msg","");
        cashClosedPayInventoryMap.put("data",cashClosedPayInventoryList);
        System.out.println("已有"+cashClosedPayInventoryList.size()+"条数据");
        return cashClosedPayInventoryMap;
    }
}
