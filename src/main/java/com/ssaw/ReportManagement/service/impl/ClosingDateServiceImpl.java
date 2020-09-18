package com.ssaw.ReportManagement.service.impl;

import com.ssaw.BusinessData.entity.Market;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import com.ssaw.ReportManagement.entity.ClosingDate;
import com.ssaw.ReportManagement.mapper.ClosingDateMapper;
import com.ssaw.ReportManagement.service.ClosingDateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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


        return null;
    }
}
