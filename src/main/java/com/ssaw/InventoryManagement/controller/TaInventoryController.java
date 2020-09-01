package com.ssaw.InventoryManagement.controller;

import com.ssaw.InventoryManagement.entity.TaInventory;
import com.ssaw.InventoryManagement.service.TaInventoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName:    TaInventoryController
 * Package:    com.ssaw.InventoryManagement.controller
 * Description: TA库存
 * Datetime:    2020/9/1   10:18
 * Author:   SYT
 */
@RestController
@RequestMapping("taInventory")
public class TaInventoryController {
    @Resource
    TaInventoryService taInventoryService;

    /**
     * 分页查询
     * @return
     */
    @RequestMapping("select")
    public HashMap selectTaInventory(){
        List<TaInventory> taInventoryList=taInventoryService.selectTaInventory();
        HashMap taInventoryMap=new HashMap();


        return taInventoryMap;
    }

    /**
     * 增加TA库存
     * @param taInventory
     * @return
     */
    @RequestMapping("insert")
    public int insertTaInventory(TaInventory taInventory){
        int i=taInventoryService.insertTaInventory(taInventory);
        return i;
    }

    /**
     * 修改TA库存信息
     * @param taInventory
     * @return
     */
    @RequestMapping("update")
    public int updateTaInventory(TaInventory taInventory){
        int i=taInventoryService.updateTaInventory(taInventory);
        return i;
    }

    /**
     * 删除库存
     * @param taInventoryId
     * @return
     */
    @RequestMapping("delete")
    public int deleteTaInventory(int taInventoryId){
        int i=taInventoryService.deleteTaInventory(taInventoryId);
        return i;
    }
}
