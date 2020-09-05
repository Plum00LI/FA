package com.ssaw.GlobalManagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("system")
public class SystemController {
    @RequestMapping("checkLogin")
    public Map<String,Object> checkLogin(String userName, String userPwd, String fundId, HttpServletRequest req){
        System.out.println(userName+userPwd+fundId);
        Map<String, Object> map = new HashMap<>();
        map.put("code",1);
        HttpSession session = req.getSession();
        session.setAttribute("userName",userName);
        session.setAttribute("fundId","608899");
        return map;
    }

    @RequestMapping("logoff")
    public Map<String,Object> logoff(HttpServletRequest req){
        HttpSession session = req.getSession(false);
        session.removeAttribute("userName");
        session.removeAttribute("fundId");
        Map<String,Object> map = new HashMap<>();
        map.put("code",1);
        map.put("msg","已退出，3秒后将转跳到登录页");
        return map;
    }
}
