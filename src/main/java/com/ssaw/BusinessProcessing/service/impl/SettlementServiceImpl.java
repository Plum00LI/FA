package com.ssaw.BusinessProcessing.service.impl;

import com.ssaw.BusinessProcessing.entity.Settlement;
import com.ssaw.BusinessProcessing.mapper.SettlementMapper;
import com.ssaw.BusinessProcessing.service.SettlementService;
import com.ssaw.CashManagement.entity.BankTreasurer;
import com.ssaw.CashManagement.mapper.BankTreasurerMapper;
import com.ssaw.GlobalManagement.util.DbUtil;
import com.ssaw.GlobalManagement.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
/**
 * create by: 曾钦辉
 * description: 交易结算Service实现类
 * create time: 2020/9/10 9:31
 *
  * @Param: null
 * @return
 */

@Service
@Transactional
public class SettlementServiceImpl implements SettlementService {
    @Resource
    SettlementMapper settlementMapper;
    @Resource
    BankTreasurerMapper bankTreasurerMapper;
    @Resource
    DbUtil dbUtil;
    @Override
    public HashMap selectSettlement(int page, int limit, String dateTime, String transactionDataMode,String status) {
        StringBuffer sqlWhere=new StringBuffer();
        if(dateTime!=null && !dateTime.equals("")){
            sqlWhere.append(" AND dateTime LIKE  '%"+dateTime+"%'" );
        }
        int v_transactionDataMode=0;
        if(transactionDataMode!=null && !transactionDataMode.equals("")){
            v_transactionDataMode=Integer.parseInt(transactionDataMode);
            sqlWhere.append(" AND transactionDataMode LIKE '%"+v_transactionDataMode+"%'");
        }
        int v_status=-1;//结算状态 结算1 or 未结算0
        if(status!=null && !status.equals("")){
            v_status=Integer.parseInt(status);
            sqlWhere.append(" AND status ="+v_status);
        }

        HashMap tranMap = new HashMap();
        String transactionData=" (select * from transactionData tr left join securities se on tr.securitiesId=se.securitiesId left join account ac on tr.accountId=ac.accountId left join seate se on tr.seateId=se.seateId left join brokers br on tr.brokersId=br.brokersId left join fund f on tr.fundId = f.fundId) ";
        tranMap.put("p_tableName", transactionData);
        tranMap.put("p_condition",sqlWhere.toString());
        tranMap.put("p_pageSize",limit);
        tranMap.put("p_page",page);
        tranMap.put("p_count",0);
        tranMap.put("p_cursor",null);
        settlementMapper.selectSettlement(tranMap);
        return tranMap;
    }

    @Override
    public int updateSettlement(Settlement settlement) {
        BankTreasurer bankTreasurer=new BankTreasurer();
        bankTreasurer.setBankTreasurerId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.BT));
        bankTreasurer.setFundId(settlement.getFundId());
        bankTreasurer.setTotalPrice(settlement.getTotalSum());
        bankTreasurer.setAccountId(settlement.getAccountId());
        bankTreasurer.setFlag(settlement.getFlag());
        bankTreasurer.setDbTime(settlement.getSettlementDate());
        bankTreasurer.setDateTime(settlement.getDateTime());
        bankTreasurer.setBusinessId(settlement.getTransactionDataId());
        bankTreasurer.setAllocatingType(4);//申购赎回款
        bankTreasurer.setBankTreasurerDesc(settlement.getTransactionDataDesc());
        bankTreasurer.setAccountName(settlement.getAccountName());



        String transactionDataId = settlement.getTransactionDataId();
        String[] split=new String[0];
        if (transactionDataId!=null&&!transactionDataId.equals("")){
            split= transactionDataId.split(",");

        }
        for(int i=0;i<split.length;i++){
            settlement.setTransactionDataId(split[i]);
            //交易状态 0==未结算 1==已结算
            if(settlement.getStatus()==0){
                settlement.setStatus(1);

            }
            else if(settlement.getStatus()==1){
                bankTreasurerMapper.insertBankTreasurer(bankTreasurer);
            }
        }
        return settlementMapper.updateSettlement(settlement);
    }

}
