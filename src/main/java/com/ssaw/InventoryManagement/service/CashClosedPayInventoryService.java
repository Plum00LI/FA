package com.ssaw.InventoryManagement.service;

import com.ssaw.InventoryManagement.entity.CashClosedPayInventory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:现金应收应付库存模块
 * @Description:Biz层接口
 * @author:孙浩
 * @create:2020-09-01
 */
@Service
public interface CashClosedPayInventoryService {
    public int insertCashClosedPayInventory(CashClosedPayInventory cashClosedPayInventory);
    public void deleteCashClosedPayInventory(int crcsId);
    public int updateCashClosedPayInventory(CashClosedPayInventory cashClosedPayInventory);
    public List<CashClosedPayInventory> selectCashClosedPayInventory();
}
