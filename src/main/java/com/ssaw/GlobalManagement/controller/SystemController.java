package com.ssaw.GlobalManagement.controller;

import com.ssaw.GlobalManagement.service.SysMenuService;
import com.ssaw.GlobalManagement.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("system")
public class SystemController {
    //注册UserInfoService服务
    @Resource
    UserInfoService userInfoService;
    //注册SysMenuService服务
    @Resource
    SysMenuService sysMenuService;
    //checkLogin验证登录方法
    @RequestMapping("checkLogin")
    public Map<String,Object> checkLogin(String userName, String userPwd, String fundId, HttpServletRequest req){
        //创建存放回调对象的map
        Map<String, Object> map = new HashMap<>();
        //调用userInfoService服务isLogin方法检查登录
        int status = userInfoService.isLogin(userName, userPwd);
        //判断登录状态，不同操作
        if (status==1){
            //返回正常状态
            map.put("code",1);
            //创建Session对象，存放当此会话登录数据
            HttpSession session = req.getSession();
            //在session中放入当次登录用户信息
            session.setAttribute("userName",userName);
            //在session中放入当次登录基金信息
            session.setAttribute("fundId","608899");
        }else {
            //返回异常状态
            map.put("code",0);
        }
        //返回回调数据
        return map;
    }
    //logoff注销Session，退出登录方法
    @RequestMapping("logoff")
    public Map<String,Object> logoff(HttpServletRequest req){
        //从请求中拿出session对象
        HttpSession session = req.getSession(false);
        //移除session对象userName
        session.removeAttribute("userName");
        //移除session对象fundId
        session.removeAttribute("fundId");
        //创建回调数据map
        Map<String,Object> map = new HashMap<>();
        //存入状态码，1正常
        map.put("code",1);
        //存入回调信息
        map.put("msg","已退出，3秒后将转跳到登录页");
        //返回回调数据
        return map;
    }

    @RequestMapping("menu")
    //请求菜单数据方法
    public Map<String,Object> menu(){
        //返回菜单数据
        return sysMenuService.menu();
    }
}
