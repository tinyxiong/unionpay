package com.xuebang.platform.unionpay.shell.service;

import com.xuebang.platform.unionpay.shell.domain.FundsChangeRecord;
import com.xuebang.platform.unionpay.shell.repository.FundsChangeRecordRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * author: xyb
 * Date: 2017/11/24 17:41
 * desc: 支付接口服务
 */
@Service
public class UnionPayService {

    @Autowired
    private FundsChangeRecordRep fundsChangeRecordRep;

    /**
     * 新增一条收款记录
     * @param shellAddCmd 收款信息
     */
    public void add(FundsChangeRecordShellAddCmd shellAddCmd) {
        FundsChangeRecord fundsChangeRecord = shellAddCmd.toFundsChangeRecord();
        fundsChangeRecordRep.save(fundsChangeRecord);
    }

    /**
     * 确认订单
     * @param id 订单id
     */
    public void confirm(Long id) throws Exception {
        FundsChangeRecord fundsChangeRecord = fundsChangeRecordRep.findOne((root, cq, cb) -> cb.equal(root.get("id"), id));
        fundsChangeRecord.lock();
    }
}
