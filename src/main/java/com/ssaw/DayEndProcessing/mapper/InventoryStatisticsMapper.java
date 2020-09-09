package com.ssaw.DayEndProcessing.mapper;



import com.ssaw.InventoryManagement.entity.SecuritiesInventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * ClassName:    InventoryStatisticsMapper
 * Package:    com.ssaw.DayEndProcessing.mapper
 * Description:
 * Version:
 * Datetime:    2020/9/8   20:12
 * Author:   SYT
 */
@Mapper
public interface InventoryStatisticsMapper {
    /**
     * 统计证券库存
     * @return
     */
    public int countSecuritiesInventory(Map<String,Object> map);
    public List<SecuritiesInventory> selectSecuritiesInventory();
}
