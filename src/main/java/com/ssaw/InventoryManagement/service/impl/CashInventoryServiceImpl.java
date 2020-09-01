package com.ssaw.InventoryManagement.service.impl;

import com.ssaw.InventoryManagement.entity.CashInventory;
import com.ssaw.InventoryManagement.service.CashInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:    CashInventoryServiceImpl
 * Package:    com.ssaw.InventoryManagement.service.impl
 * Description:
 * Version:   1.0
 * Datetime:    2020/9/1   9:35
 * Author:   SYT
 */
@Service
public class CashInventoryServiceImpl implements CashInventoryService {

    @Resource
    CashInventoryService cashInventoryService;

    public List<CashInventory> selectCashInventory() {
        return cashInventoryService.selectCashInventory();
    }


    public int insertCashInventory(CashInventory cashInventory) {
        return cashInventoryService.insertCashInventory(cashInventory);
    }

    public int updateCashInventory(CashInventory cashInventory) {
        return cashInventoryService.updateCashInventory(cashInventory);
    }


    public int deleteCashInventory(int cashInventoryId) {
        return cashInventoryService.deleteCashInventory(cashInventoryId);
    }

}
