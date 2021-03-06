package com.ssaw.GlobalManagement.controller;

import com.ssaw.GlobalManagement.entity.Fun;
import com.ssaw.GlobalManagement.entity.FunTest;
import com.ssaw.GlobalManagement.service.FunService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by: 佘高鹏
 * description: TODO
 * 角色功能控制层
 * create time: 2020/9/8 16:46
 * version number 1.0
  * @Param: null
 * @return
 */
@RestController
@RequestMapping("Fun")
public class FunController {
    @Resource
    FunService funService;

    @RequestMapping("SelectFun")
    @ResponseBody
    public List<Fun> selectFun(int roleId){
        List<Fun> fun = funService.selectFun(0, roleId);
        for (Fun fun1 : fun) {
            System.out.println(fun1);
        }
        return fun;
    }
}
