package com.ssaw.InventoryManagement.service;

import com.ssaw.InventoryManagement.entity.CashInventory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:    CashInventoryService
 * Package:    com.ssaw.InventoryManagement.service
 * Description:
 * Version:   1.0
 * Datetime:    2020/9/1   9:29
 * Author:   SYT
 */
@Service
public interface CashInventoryService {
    public List<CashInventory> selectCashInventory();

    public int insertCashInventory(CashInventory cashInventory);

    public int updateCashInventory(CashInventory cashInventory);

    public int deleteCashInventory(int cashInventoryId);
}
