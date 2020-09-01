package com.ssaw.InventoryManagement.service.impl;

import com.ssaw.InventoryManagement.entity.CashClosedPayInventory;
import com.ssaw.InventoryManagement.mapper.CashClosedPayInventoryMapper;
import com.ssaw.InventoryManagement.service.CashClosedPayInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program:现金应收应付库存模块
 * @Description:实现类
 * @author:孙浩
 * @create:2020-09-01
 */
@Service
public class CashClosedPayInventoryServiceImpl implements CashClosedPayInventoryService {
    @Resource
    CashClosedPayInventoryMapper cashClosedPayInventoryMapper;

    @Override
    public int insertCashClosedPayInventory(CashClosedPayInventory cashClosedPayInventory) {
        return cashClosedPayInventoryMapper.insertCashClosedPayInventory(cashClosedPayInventory);
    }

    @Override
    public void deleteCashClosedPayInventory(int crcsId) {
        cashClosedPayInventoryMapper.deleteCashClosedPayInventory(crcsId);
    }

    @Override
    public int updateCashClosedPayInventory(CashClosedPayInventory cashClosedPayInventory) {
        return cashClosedPayInventoryMapper.updateCashClosedPayInventory(cashClosedPayInventory);
    }

    @Override
    public List<CashClosedPayInventory> selectCashClosedPayInventory() {
        return cashClosedPayInventoryMapper.selectCashClosedPayInventory();
    }
}
