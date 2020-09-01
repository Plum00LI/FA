package com.ssaw.InventoryManagement.service.impl;/**
 * @program: TescComment
 * @Description:实体类
 * @author: 瞿平
 * @create: 2020-09-01
 */

import com.ssaw.InventoryManagement.entity.SecuritiesInventory;
import com.ssaw.InventoryManagement.mapper.SecuritiesInventoryMapper;
import com.ssaw.InventoryManagement.service.SecuritiesInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*@program: TescComment
*@Description:证券库存实现类
*@author: 瞿平
*@version:1.0
*@create: 2020-09-01
*/
@Service
public class SecuritiesInventoryServiceImpl implements SecuritiesInventoryService {
    @Resource
    SecuritiesInventoryMapper securitiesInventoryMapper;

    @Override
    public List<SecuritiesInventory> selectSecuritiesInventory() {
        return securitiesInventoryMapper.selectSecuritiesInventory();
    }

    @Override
    public int insertSecuritiesInventory(SecuritiesInventory securitiesInventory) {
        return securitiesInventoryMapper.insertSecuritiesInventory(securitiesInventory);
    }

    @Override
    public int deleteSecuritiesInventory(int securitiesInventoryId) {
        return securitiesInventoryMapper.deleteSecuritiesInventory(securitiesInventoryId);
    }

    @Override
    public int updateSecuritiesInventory(SecuritiesInventory securitiesInventory) {
        return securitiesInventoryMapper.updateSecuritiesInventory(securitiesInventory);
    }
}
