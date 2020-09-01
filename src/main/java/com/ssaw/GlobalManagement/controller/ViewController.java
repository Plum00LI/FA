package com.ssaw.GlobalManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图访问控制层
 * @type: controller
 * @version: v1.0
 * @author: plum
 * @date: 2020/09/02
 */
@Controller
@RequestMapping("getPage")
public class ViewController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("userInfoTable")
    public String userInfoTable(){
        return "GlobalManagement/userInfoTable";
    }
}
