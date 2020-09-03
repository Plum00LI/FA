package com.ssaw.InventoryManagement.controller;

import com.ssaw.InventoryManagement.entity.CashInventory;
import com.ssaw.InventoryManagement.service.CashInventoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:    CashInventoryController
 * Package:    com.ssaw.InventoryManagement.controller
 * Description:
 * Datetime:    2020/9/1   9:45
 * Author:   SYT
 */
@RestController
@RequestMapping("/cashInventory")
public class CashInventoryController {
    @Resource
    CashInventoryService cashInventoryService;

    /**
     * 分页查询
     * @return
     */
    @RequestMapping("/select")
    public Map<String,Object> selectCashInventory(String page, String limit){
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map =  cashInventoryService.selectCashInventory(limit,page);
        //从结果集中拿出结果
        List<CashInventory> cashInventoryList = (List<CashInventory>) map.get("cashInventory");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",cashInventoryList);
        //返回数据
        return json;
    }

   /* *//**
     * 查询所有
     * @return
     *//*
    @RequestMapping("/selectAll")
    public List<CashInventory> selectCashInventoryAll(){
        List<CashInventory> cashInventoryList=cashInventoryService.selectCashInventoryAll();
        return cashInventoryList;
    }*/

    /**
     * 增加现金库存
     * @param datetime
     * @param accountId
     * @param cashBlance
     * @param cashInventoryDesc
     * @return
     */
    @RequestMapping("/insert")
    public int insertCashInventory(String datetime,String accountId,String cashInventoryDesc){
//        double v_cashBlance = 0.0;
//        if (cashBlance!=null&&!cashBlance.equals("")){
//            v_cashBlance=Double.parseDouble(cashBlance);
//        }
//        CashInventory cashInventory = new CashInventory("C202009030001","4",v_cashBlance,accountId,datetime,10000,1,cashInventoryDesc);
//        int i=cashInventoryService.insertCashInventory(cashInventory);

        System.out.println(datetime);

        return 0;
    }

    /**
     * 修改库存信息
     * @param cashInventory  现金库存实体类对象
     * @return
     */
    @RequestMapping("/update")
    public int updateCashInventory(CashInventory cashInventory){
        int i=cashInventoryService.updateCashInventory(cashInventory);
        return i;
    }

    /**
     * 删除库存
     * @param cashInventoryId 库存Id
     * @return
     */
    @RequestMapping("/delete")
    public int deleteCashInventory(int cashInventoryId){
        int i=cashInventoryService.deleteCashInventory(cashInventoryId);
        return i;
    }
}
