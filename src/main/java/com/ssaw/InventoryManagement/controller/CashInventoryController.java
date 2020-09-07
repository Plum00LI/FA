package com.ssaw.InventoryManagement.controller;

import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
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

    @Resource
    DbUtil dbUtil;

    /**
     * 分页查询
     * @return
     */
    @RequestMapping("/select")
    public Map<String,Object> selectCashInventory(String page, String limit,String accountId,String dateTime){
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map =  cashInventoryService.selectCashInventory(limit,page,accountId,dateTime);

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

    /**
     * 新增现金库存信息
     * @param cashInventory
     * @return
     */
    @RequestMapping("/insert")
    public int insertCashInventory(CashInventory cashInventory){
        //现金库存Id
        cashInventory.setCashInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.CI));
        //基金Id
        cashInventory.setFundId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.F));
        //证券数量 来自证券库存 写死 securitiesNum;
        cashInventory.setSecuritiesNum(1000);
        //是否从其他系统导入的期初数据  0：不是  1：是
        cashInventory.setSecurityPeriodFlag(1);
        System.out.println(cashInventory);
        int i=cashInventoryService.insertCashInventory(cashInventory);
        return i;
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
    public int deleteCashInventory(String cashInventoryId){
        System.out.println(cashInventoryId);
        int i=cashInventoryService.deleteCashInventory(cashInventoryId);
        return i;
    }
}
