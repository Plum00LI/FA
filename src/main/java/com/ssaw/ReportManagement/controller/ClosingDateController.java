package com.ssaw.ReportManagement.controller;/**
 * @program: TescComment
 * @Description:实体类
 * @author: 瞿平
 * @version:1.0
 * @create: 2020-09-01
 */

import com.ssaw.ReportManagement.entity.ClosingDate;
import com.ssaw.ReportManagement.service.ClosingDateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@program: FA
 *@description: 成交清算日数据控制类
 *@author: 瞿平
 *@create: 2020-09-19 14:53
 **/
@RestController
@RequestMapping("ClosingDateController")
public class ClosingDateController {

    @Resource
    ClosingDateService closingDateService;

    @RequestMapping("selectClosingDate")
    public Object selectClosingDate(ClosingDate closingDate,String fundId){
        return closingDateService.selectClosingDate(closingDate,fundId);
    }

}
