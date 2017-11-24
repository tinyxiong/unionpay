package com.xuebang.platform.unionpay.shell.repository;

import com.xuebang.platform.unionpay.shell.domain.FundsChangeRecord;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * author: xyb
 * Date: 2017/11/24 17:52
 * desc: 支付记录仓库类
 */
public interface FundsChangeRecordRep extends CrudRepository<FundsChangeRecord, Long>, JpaSpecificationExecutor<FundsChangeRecord> {

}
