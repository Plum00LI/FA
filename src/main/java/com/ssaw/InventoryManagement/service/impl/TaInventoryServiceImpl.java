package com.ssaw.InventoryManagement.service.impl;

import com.ssaw.InventoryManagement.entity.TaInventory;
import com.ssaw.InventoryManagement.service.TaInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:    TaInventoryServiceImpl
 * Package:    com.ssaw.InventoryManagement.service.impl
 * Description:
 * Version:   1.0
 * Datetime:    2020/9/1   9:41
 * Author:   SYT
 */
@Service
public class TaInventoryServiceImpl implements TaInventoryService {
    @Resource
    TaInventoryService taInventoryService;

    public List<TaInventory> selectTaInventory() {
        return taInventoryService.selectTaInventory();
    }


    public int insertTaInventory(TaInventory taInventory) {
        return taInventoryService.insertTaInventory(taInventory);
    }


    public int updateTaInventory(TaInventory taInventory) {
        return taInventoryService.updateTaInventory(taInventory);
    }


    public int deleteTaInventory(int taInventoryId) {
        return taInventoryService.deleteTaInventory(taInventoryId);
    }


}
