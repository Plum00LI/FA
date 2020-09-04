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

    //查询
    @RequestMapping("selectSecurities")
    public Map<String,Object> selectSecurities(String page, String limit){
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
    //删除
    /**
     * ajax请求以securitiesId删除securities的控制层方法
     * @param securitiesId 请求数据中的要删除securities的securitiesId
     * @return 执行信息
     */
    @RequestMapping("deleteSecuritiesId")
    public Map<String,Object> deleteUserInfoByUserId(String securitiesId){
        //调用Service层执行删除方法，并接收返回结果
        boolean result = securitiesService.deleteSecurities(securitiesId);
        //判断结果，响应数据
        Map<String, Object> json = new HashMap<>();
        if (result){
            //成功返回msg信息success
            json.put("msg","success");
        }else {
            //失败返回msg信息fail
            json.put("msg","fail");
        }
        //返回数据
        return json;
    }
}
