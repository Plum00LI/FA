package com.ssaw.InventoryManagement.service;

import com.ssaw.InventoryManagement.entity.SecuritiesInventory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@program: TescComment
*@Description:证券库存Biz类
*@author: 瞿平
*@version:1.0
*@create: 2020-09-01
*/
@Service
public interface SecuritiesInventoryService {
    /**
     * 查询
     * @return 返回一个集合
     */
    List<SecuritiesInventory> selectSecuritiesInventory();

    /**
     * 增加
     * @param securitiesInventory 证券库存实体类
     * @return 返回一个int类型参数
     */
    int insertSecuritiesInventory(SecuritiesInventory securitiesInventory);

    /**
     * 删除
     * @param securitiesInventoryId 证券库存Id
     * @return 返回一个int类型参数
     */
    int deleteSecuritiesInventory(int securitiesInventoryId);

    /**
     * 修改
     * @param stock 证券库存实体类
     * @return 返回一个int类型参数
     */
    int updateSecuritiesInventory(SecuritiesInventory stock);
}
