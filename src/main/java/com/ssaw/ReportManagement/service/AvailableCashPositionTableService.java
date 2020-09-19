package com.ssaw.ReportManagement.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ClassName:    AvailableCashPositionTableService
 * Package:    com.ssaw.ReportManagement.Service
 * Description: 可用现金头寸表
 * Version:     1.0
 * Datetime:    2020/9/18 14:51
 * Author:   阙魁
 */
@Service
public interface AvailableCashPositionTableService {
        public Map<String,Object> selectAvailable(String pageSize, String page,String dateTime);
        //select  ACCOUNTNAME,SECURITIESNUM from CASHINVENTORY c join ACCOUNT A2 on c.ACCOUNTID = A2.ACCOUNTID where DATETIME=''
    //union
    //select '申购赎回合计',nvl(sum(TOTALMONEY*BUSINESSSTATUS),0) from CASHCLOSEDPAYINVENTORY WHERE BUSINESSTYPE=4 and BUSINESSDATE=''
    //union
    //select '清算款合计',nvl(sum(TOTALPRICE*FLAG),0) from SECURITIESCLOSEDPAYINVENTORY WHERE SECURITIESTYPE=2 and DATETIME='';
}
