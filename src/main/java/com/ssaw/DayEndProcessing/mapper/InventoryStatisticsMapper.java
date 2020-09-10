package com.ssaw.DayEndProcessing.mapper;



import com.ssaw.DayEndProcessing.entity.SecuritiesInventoryData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
     * 查询证券库存方法
     * @param dateTime
     * @param fundId
     * @return
     */
    public List<SecuritiesInventoryData> selectSecuritiesInventory(String dateTime, String fundId);
}
