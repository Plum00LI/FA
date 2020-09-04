package com.ssaw.BusinessDescription.service;

import com.ssaw.BusinessDescription.entity.Bond;
import com.ssaw.TAManagement.entity.TaTransaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**债券信息设置service
 * @program:TescComment
 * @version:v1.0
 * @Description:实体类
 * @authod:洪彬峰
 * @date:2020-09-01
 */
@Service
@Transactional
public interface BondService {
    //查询
        Map<String,Object>selectBond(String pageSize, String page);
    //增加
    int insertBond(Bond bond);
    //删除
     void  deleteBond(int securitiesId);
    //修改
     int updateBond(Bond bond);
}
