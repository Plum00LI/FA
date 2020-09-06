package com.ssaw.BusinessDescription.controller;

import com.ssaw.BusinessDescription.entity.Securities;
import com.ssaw.BusinessDescription.entity.SecuritiesAndStock;
import com.ssaw.BusinessDescription.entity.Stock;
import com.ssaw.BusinessDescription.service.SecuritiesService;
import com.ssaw.GlobalManagement.entity.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 债券参数
 * @type 控制层
 * @author fusaiying
 * @date 2020-09-01
 * @version 1.0
 */
@RestController
@RequestMapping("Securities")
public class SecuritiesController {
    @Resource
    SecuritiesService securitiesService;

  /*   'securitiesIds': securitiesIds, 证券id
            'securitiesNames': securitiesNames, 证券名
            'securitiesTypes': securitiesTypes,  交易所名
            'exchanges': exchanges 债券类型
            */
    //查询
    @RequestMapping("selectSecurities")
    public Map<String,Object> selectSecurities(String page, String limit,String securitiesIds,String securitiesNames,int securitiesTypes,int exchanges){
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map = securitiesService.selectSecurities(limit,page);
        System.out.printf(map.toString());
        //从结果集中拿出结果
        List<SecuritiesAndStock> SecuritiesList = (List<SecuritiesAndStock>) map.get("SecuritiesAndStock");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",SecuritiesList);
        //返回数据
        return json;
    }
    /**
     *删除
     */
    @RequestMapping("deleteSecurities")
    public void deleteSecurities(String securitiesId ){
        System.out.println("进入controller了");
        securitiesService.deleteSecurities(securitiesId);
    }
    /**
     * 批量删除
     */
    @RequestMapping("deleteSecurities2")
    public void deleteSecurities2(String securitiesId ){
        System.out.println("进入controller了");
        securitiesService.deleteSecurities(securitiesId);
    }

    /**
     * 增加
     */
    @RequestMapping("insertSecurities")
    public int insertSecurities(Securities securities){
        System.out.println("我是页面数据"+securities);
        /*Securities securities1 = new Securities();
        securities1.setSecuritiesId("2020502");
        securities1.setDelayDate("T+1");
        securities1.setExchange(1);
        securities1.setIssueDate("2020/09/06");
        securities1.setSecuritiesName("光顾国际");
        securities1.setSecuritiesType(1);
        securities1.setStockId("1");
        securities1.setSecuritiesDesc("是得分啊");*/
        int i=securitiesService.insertSecurities(securities);
        System.out.println(i+"进con了");
        return i;
    }
    /**
     * 修改
     */
    @RequestMapping("updateSecurities")
    public int updateSecurities(Securities securities){
        int i=securitiesService.updateSecurities(securities);
        return i;
    }
}
