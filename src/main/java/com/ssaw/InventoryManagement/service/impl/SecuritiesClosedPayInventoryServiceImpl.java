package com.ssaw.InventoryManagement.service.impl;

import com.ssaw.InventoryManagement.entity.SecuritiesClosedPayInventory;
import com.ssaw.InventoryManagement.mapper.SecuritiesClosedPayInventoryMapper;
import com.ssaw.InventoryManagement.service.SecuritiesClosedPayInventoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * ClassName:    SecuritiesClosedPayInventoryServiceImpl
 * Package:    com.ssaw.InventoryManagement.service.impl
 * Description:
 * Version:
 * Datetime:    2020/9/6   21:14
 * Author:   SYT
 */
@Service
@Transactional
public class SecuritiesClosedPayInventoryServiceImpl implements SecuritiesClosedPayInventoryService {
    @Resource
    SecuritiesClosedPayInventoryMapper securitiesClosedPayInventoryMapper;


    @Override
    public void selectSecuritiesClosedPayInventory(Map map) {

    }

    @Override
    public int insertSecuritiesClosedPayInventory(SecuritiesClosedPayInventory securitiesClosedPayInventory) {
        return 0;
    }

    @Override
    public int updateSecuritiesClosedPayInventory(SecuritiesClosedPayInventory securitiesClosedPayInventory) {
        return 0;
    }

    @Override
    public int deleteSecuritiesClosedPayInventory(List securitiesClosedPayInventoryId) {
        return 0;
    }
}
