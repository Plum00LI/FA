package com.ssaw.BusinessDescription.controller;

import com.ssaw.BusinessDescription.entity.Bond;
import com.ssaw.BusinessDescription.mapper.BondMapper;
import com.ssaw.BusinessDescription.service.BondService;
import com.ssaw.GlobalManagement.util.DbUtil;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program:TescComment
 * @Description:实体类
 * @authod:洪彬峰
 * @create:2020-09-01
 */
@RestController
public class BondController implements BondMapper {
    @Resource
    BondService bondService;
    @Resource
    DbUtil dbUtil;

    @Override
    public void selectBond(Map map) {

    }

    @Override
    public int insertBond(Bond bond) {
        return 0;
    }

    @Override
    public void deleteBond(int securitiesId) {

    }

    @Override
    public int updateBond(Bond bond) {
        return 0;
    }
}
