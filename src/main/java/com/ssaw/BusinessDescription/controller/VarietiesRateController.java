package com.ssaw.BusinessDescription.controller;


import com.ssaw.BusinessDescription.entity.VarietiesRate;
import com.ssaw.BusinessDescription.service.VarietiesRateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 交易所品种费率的Controller控制层
 * @type:VarietiesRate
 * @version v1.0
 * @author:阙魁
 * @create:2020-09-02
 */
@RestController
public class VarietiesRateController {

    @Resource
    VarietiesRateService varietiesRateService;

    //查询controller
    @RequestMapping("/selectVarietiesRate")
    public List<VarietiesRate> selectVarietiesRate(){
        System.out.println("进入了查询Controller");
        List<VarietiesRate> varietiesRateList=varietiesRateService.selectVarietiesRate();
//        HashMap hashMap=new HashMap();
//        hashMap.put("count",10);
//        hashMap.put("code",0);
//        hashMap.put("msg","");
//        hashMap.put("data",varietiesRateList);
        return varietiesRateList;
    }

    //删除方法
    @RequestMapping("/deleteVarietiesRate")
    public void deleteVarietiesRate(int exchangeNameId, int rateTypeId){
        System.out.println("进入删除controller了");
        varietiesRateService.deleteVarietiesRate(exchangeNameId,rateTypeId);
    }

    //增加controller
    @RequestMapping("/insertVarietiesRate")
    public int insertVarietiesRate(VarietiesRate varietiesRate){
        System.out.println("进入了增加controller了");
        int i=varietiesRateService.insertVarietiesRate(varietiesRate);
        return i;
    }
    //修改controller
    @RequestMapping("/updateVarietiesRate")
    public int updateVarietiesRate(VarietiesRate varietiesRate){
        System.out.println("进入了修改controller了");
        int i=varietiesRateService.updateVarietiesRate(varietiesRate);
        return i;
    }


}
