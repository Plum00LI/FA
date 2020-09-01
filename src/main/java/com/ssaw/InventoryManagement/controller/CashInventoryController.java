package com.ssaw.InventoryManagement.controller;

import com.ssaw.InventoryManagement.entity.CashInventory;
import com.ssaw.InventoryManagement.service.CashInventoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName:    CashInventoryController
 * Package:    com.ssaw.InventoryManagement.controller
 * Description:
 * Datetime:    2020/9/1   9:45
 * Author:   SYT
 */
@RestController
@RequestMapping("/cashInventory")
public class CashInventoryController {
    @Resource
    CashInventoryService cashInventoryService;

    /**
     * 分页查询
     * @return
     */
    @RequestMapping("/select")
    public HashMap selectCashInventory(){
        List<CashInventory> cashInventoryList=cashInventoryService.selectCashInventory();
        HashMap cashInventoryMap=new HashMap();
        cashInventoryMap.put("count",10);
        return cashInventoryMap;
    }

    /**
     * 增加现金库存
     * @param cashInventory 现金库存实体类对象
     * @return
     */
    @RequestMapping("/insert")
    public int insertCashInventory(CashInventory cashInventory){
        int i=cashInventoryService.insertCashInventory(cashInventory);
        return i;
    }

    /**
     * 修改库存信息
     * @param cashInventory  现金库存实体类对象
     * @return
     */
    @RequestMapping("/update")
    public int updateCashInventory(CashInventory cashInventory){
        int i=cashInventoryService.updateCashInventory(cashInventory);
        return i;
    }

    /**
     * 删除库存
     * @param cashInventoryId 库存Id
     * @return
     */
    @RequestMapping("/delete")
    public int deleteCashInventory(int cashInventoryId){
        int i=cashInventoryService.deleteCashInventory(cashInventoryId);
        return i;
    }
}
