package com.ssaw.BusinessDescription.controller;

import com.ssaw.BusinessDescription.entity.Securities;
import com.ssaw.BusinessDescription.entity.Stock;
import com.ssaw.BusinessDescription.service.SecuritiesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 债券参数
 * @type 控制层
 * @author fusaiying
 * @date 2020-09-01
 * @version 1.0
 */
@RestController
public class SecuritiesController {
    @Resource
    SecuritiesService securitiesService;

    @RequestMapping(value = "/selectSecurities")
    private HashMap selectSecurities(){
        List<Securities> SecuritiesList= securitiesService.selectSecurities();
        HashMap securitiesMap = new HashMap();
        securitiesMap.put("count",10);
        securitiesMap.put("code",0);
        securitiesMap.put("msg","");
        securitiesMap.put("data",SecuritiesList);
        return securitiesMap;
    }
}
