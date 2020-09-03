package com.ssaw.BusinessDescription.controller;

import com.ssaw.BusinessDescription.entity.Brokers;
import com.ssaw.BusinessDescription.service.BrokersService;
import com.ssaw.GlobalManagement.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:TescComment
 * @Description:实体类
 * @author:邓玺中
 * @create:2020-09-01
 */
@RestController
@RequestMapping("Brokers")
public class BrokersController {
    @Resource
    BrokersService brokersService;

    /**
     * chax 界面请求用户信息数据控制层查询所有用户的方法
     * @param page 当前查询页数
     * @param limit 分页数据条目数
     * @return UI界面要求的数据格式..
     */
    @RequestMapping("selectBrokers")
    public Map<String,Object> selectBrokers(String page,String limit){
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map = brokersService.selectBrokers(limit,page);
        //从结果集中拿出结果
        List<Brokers> brokers = (List<Brokers>) map.get("brokers");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",brokers);
        //返回数据
        return json;
    }

    /**
     * 删除
     *
     * @param brokersId
     * @return
     */
    @RequestMapping("deleteBrokers")
    public int deleteBrokers(String brokersId){
        int deleteBrokers = brokersService.deleteBrokers(brokersId);
        return deleteBrokers;
    }

    /**
     * 添加
     *
     * @param brokers
     * @return
     */
    @RequestMapping("insertBrokers")
    public int insertBrokers(Brokers brokers) {
        int insertBrokers = brokersService.insertBrokers(brokers);
        return insertBrokers;
    }

    /**
     * 修改
     *
     * @param brokersId
     * @return
     */
    @RequestMapping("updateBrokers")
    public int updateBrokers(String brokersId) {
        int updateBrokers = brokersService.updateBrokers(brokersId);
        return updateBrokers;
    }
}
