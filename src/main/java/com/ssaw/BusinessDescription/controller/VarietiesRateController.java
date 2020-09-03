package com.ssaw.BusinessDescription.controller;


import com.ssaw.BusinessDescription.entity.VarietiesRate;
import com.ssaw.BusinessDescription.service.VarietiesRateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易所品种费率的Controller控制层
 * @type:VarietiesRate
 * @version v1.0
 * @author:阙魁
 * @create:2020-09-02
 */
@RestController
@RequestMapping("varietiesRate")
public class VarietiesRateController {

    @Resource
    VarietiesRateService varietiesRateService;

    //查询controller
    @RequestMapping("selectVarietiesRate")
    public Map<String,Object> selectVarietiesRate(String page,String limit){
        System.out.println("进入了查询Controller");
        //调用Service层 返回结果集map
        Map<String,Object> map =varietiesRateService.selectVarietiesRate(limit,page);
        //从结果集中拿出结果
        //接收返回数据
        List<VarietiesRate> varietiesRates= (List<VarietiesRate>) map.get("varietiesRates");
        //接收返回总条数
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",varietiesRates);
        //返回数据
        return json;
    }

    //删除方法
    @RequestMapping("deleteVarietiesRate")
    public void deleteVarietiesRate(int exchangeName, int rateType){
        System.out.println("进入删除controller了");
        varietiesRateService.deleteVarietiesRate(exchangeName,rateType);
    }

    //增加controller
    @RequestMapping("insertVarietiesRate")
    public int insertVarietiesRate(VarietiesRate varietiesRate){
        System.out.println("进入了增加controller了");
        int i=varietiesRateService.insertVarietiesRate(varietiesRate);
        return i;
    }
    //修改controller
    @RequestMapping("updateVarietiesRate")
    public int updateVarietiesRate(VarietiesRate varietiesRate){
        System.out.println("进入了修改controller了");
        int i=varietiesRateService.updateVarietiesRate(varietiesRate);
        return i;
    }


}
