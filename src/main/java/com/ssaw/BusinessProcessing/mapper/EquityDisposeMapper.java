package com.ssaw.BusinessProcessing.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @program:TescComment
 * @Description:实体类
 * @author:孙浩
 * @create:2020-09-01
 */
@Mapper
public interface EquityDisposeMapper {
    public void selectEquityDispose(Map map);
}
