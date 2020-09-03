package com.ssaw.BusinessDescription.service;

import com.ssaw.BusinessDescription.entity.Bond;
import com.ssaw.TAManagement.entity.TaTransaction;
import org.springframework.stereotype.Service;

import java.util.List;

/**债券信息设置service
 * @program:TescComment
 * @version:v1.0
 * @Description:实体类
 * @authod:洪彬峰
 * @date:2020-09-01
 */
@Service
public interface BondService {
    //查询
    public List<TaTransaction> selectBond();
    //增加
    public int insertBond(Bond bond);
    //删除
    public void  deleteBond(int securitiesId);
    //修改
    public int updateBond(Bond bond);
}
