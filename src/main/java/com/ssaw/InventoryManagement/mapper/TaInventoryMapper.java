package com.ssaw.InventoryManagement.mapper;

import com.ssaw.InventoryManagement.entity.TaInventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:    TaInventoryMapper
 * Package:    com.ssaw.InventoryManagement.mapper
 * Description:TA库存Mapper类
 * Version:   1.0
 * Datetime:    2020/9/1   9:21
 * Author:   SYT
 */
@Mapper
public interface TaInventoryMapper {
    public List<TaInventory> selectTaInventory();
    public int insertTaInventory(TaInventory taInventory);
    public int updateTaInventory(TaInventory taInventory);
    public int deleteTaInventory(int taInventoryId);
}
