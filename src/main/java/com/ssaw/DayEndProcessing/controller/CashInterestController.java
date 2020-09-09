package com.ssaw.DayEndProcessing.controller;

//import com.ssaw.DayEndProcessing.entity.BondInterest;
//import com.ssaw.DayEndProcessing.entity.CashInterest;
//import com.ssaw.DayEndProcessing.entity.TwoFeeInterest;
import com.ssaw.DayEndProcessing.service.CashInterestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 收益计提
 *
 */
@RestController
@RequestMapping("CashInterest")
public class CashInterestController {
//    @Resource
//    CashInterestService cashInterestService;
//
//    //查询现金计息
//    @RequestMapping("selectCashInterest")
//    public Map<String,Object> selectCashInterest(String dateTime){
//        List<CashInterest> CashInterestList = cashInterestService.selectCashInterest(dateTime);
//        Map<String, Object> json = new HashMap<>();
//        json.put("code",0);
//        json.put("msg","");
//        json.put("count",null);
//        json.put("data",CashInterestList);
//        //返回数据
//        return json;
//    }
//    //查询债券计息
//    @RequestMapping("selectBondInterest")
//    public Map<String,Object> selectBondInterest(String dateTime){
//        List<BondInterest> BondInterestList = cashInterestService.selectBondInterest(dateTime);
//        Map<String, Object> json = new HashMap<>();
//        json.put("code",0);
//        json.put("msg","");
//        json.put("count",null);
//        json.put("data",BondInterestList);
//        //返回数据
//        return json;
//    }
//    //查询两费
//    @RequestMapping("selectTwoFeeInterest")
//    public Map<String,Object> selectTwoFeeInterest(String dateTime){
//        List<TwoFeeInterest> TwoFeeInterestList = cashInterestService.selectTwoFeeInterest(dateTime);
//        Map<String, Object> json = new HashMap<>();
//        json.put("code",0);
//        json.put("msg","");
//        json.put("count",null);
//        json.put("data",TwoFeeInterestList);
//        //返回数据
//        return json;
//    }
}
