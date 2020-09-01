package com.ssaw.InventoryManagement.service;

import com.ssaw.InventoryManagement.entity.TaInventory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:    TaInventoryService
 * Package:    com.ssaw.InventoryManagement.service
 * Description:
 * Version:   1.0
 * Datetime:    2020/9/1   9:31
 * Author:   SYT
 */
@Service
public interface TaInventoryService {
    public List<TaInventory> selectTaInventory();
    public int insertTaInventory(TaInventory taInventory);
    public int updateTaInventory(TaInventory taInventory);
    public int deleteTaInventory(int taInventoryId);
}
