package com.ssaw.BusinessDescription.service.impl;

import com.ssaw.BusinessDescription.entity.Bond;
import com.ssaw.BusinessDescription.mapper.BondMapper;
import com.ssaw.BusinessDescription.service.BondService;
import com.ssaw.TAManagement.entity.TaTransaction;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**债券信息设置实现类
 * @program:TescComment
 * @version:v1.0
 * @Description:实体类
 * @authod:洪彬峰
 * @adte:2020-09-01
 */
@Service
public class BondServiceImpl implements BondService {
    @Resource
    BondMapper bondMapper;
    @Override
    public List<TaTransaction> selectBond() {
        return bondMapper.selectBond();
    }

    @Override
    public int insertBond(Bond bond) {
        int msg = bondMapper.insertBond(bond);
        return msg;
    }

    @Override
    public void   deleteBond(int securitiesId) {
       bondMapper.deleteBond(securitiesId);
    }

    @Override
    public int updateBond(Bond bond) {
        int i = bondMapper.updateBond(bond);
        return i;
    }
}
