package com.ssaw.ReportManagement.service;

import com.ssaw.ReportManagement.entity.ClosingDate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program: TescComment
 * @Description:成交清算日报表Biz类
 * @author: 瞿平
 * @version:1.0
 * @create: 2020-09-16
 */
@Service
public interface ClosingDateService {
    /**
     * 查询成交清算数据持久层
     * @param closingDate
     * @return
     */
    Map<String,Object> selectClosingDate(ClosingDate closingDate);
}
