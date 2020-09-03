package com.ssaw.BusinessDescription.controller;

import com.ssaw.BusinessDescription.entity.Securities;
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

    @RequestMapping("selectSecurities")
    public Map<String,Object> selectSecurities(String page, String limit){
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map = securitiesService.selectSecurities(limit,page);
        System.out.printf(map.toString());
        //从结果集中拿出结果
        List<Securities> SecuritiesList = (List<Securities>) map.get("Securities");
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
}
