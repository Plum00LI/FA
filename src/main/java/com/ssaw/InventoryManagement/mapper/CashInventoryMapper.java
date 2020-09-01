package com.ssaw.InventoryManagement.mapper;

import com.ssaw.InventoryManagement.entity.CashInventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:    CashInventoryMapper
 * Package:    com.ssaw.InventoryManagement.mapper
 * Description:     现金库存增删改查
 * Version:   1.0
 * Datetime:    2020/9/1   9:26
 * Author:   SYT
 */
@Mapper
public interface CashInventoryMapper {
    public List<CashInventory> selectCashInventory();

    public int insertCashInventory(CashInventory cashInventory);

    public int updateCashInventory(CashInventory cashInventory);

    public int deleteCashInventory(int cashInventoryId);
}