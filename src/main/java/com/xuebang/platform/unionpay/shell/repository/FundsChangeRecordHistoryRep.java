package com.xuebang.platform.unionpay.shell.repository;

import com.xuebang.platform.unionpay.shell.domain.FundsChangeRecord;
import com.xuebang.platform.unionpay.shell.domain.FundsChangeRecordHistory;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

/**
 * author: xyb
 * Date: 2017/11/24 17:52
 * desc: 支付记录备份库
 */
public interface FundsChangeRecordHistoryRep extends Repository<FundsChangeRecordHistory, Long>, JpaSpecificationExecutor<FundsChangeRecordHistory> {

    void save(FundsChangeRecordHistory fundsChangeRecordHistory);
}
