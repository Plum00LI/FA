package com.ssaw.ReportManagement.service.impl;

import com.ssaw.BusinessData.entity.Market;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import com.ssaw.ReportManagement.entity.ClosingDate;
import com.ssaw.ReportManagement.mapper.ClosingDateMapper;
import com.ssaw.ReportManagement.service.ClosingDateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@program: FA
 *@description: 成交清算报表实现类
 *@author: 瞿平
 *@create: 2020-09-16 16:41
 **/
@Service
public class ClosingDateServiceImpl implements ClosingDateService {
    //自动注入成交清算报表Dao层
    @Resource
    ClosingDateMapper closingDateMapper;

    @Override
    public Map<String, Object> selectClosingDate(ClosingDate closingDate,String fundId) {

        Map<String,Object> map = (Map<String, Object>) closingDateMapper.selectClosingDate(closingDate,fundId);
        //如果业务日期为null
        if (closingDate.getDateTime()==null){
            //创建一个Date对象
            Date date = new Date();
            //定义时间格式
            String strDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
            //设置业务日期
            closingDate.setDateTime(strDate);
        }
        List<ClosingDate> closingDates = closingDateMapper.selectClosingDate(closingDate,fundId);
        int count = (int) map.get("count");
        Map<String,Object>  hashMap = new HashMap<>();
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("count",count);
        hashMap.put("data",closingDates);
        System.out.println("信息的大小："+closingDates.size());
        return null;
    }
}
