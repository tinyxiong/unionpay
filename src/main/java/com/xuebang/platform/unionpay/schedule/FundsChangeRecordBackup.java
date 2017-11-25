package com.xuebang.platform.unionpay.schedule;

import com.xuebang.platform.unionpay.shell.constants.PaidStatus;
import com.xuebang.platform.unionpay.shell.domain.FundsChangeRecord;
import com.xuebang.platform.unionpay.shell.domain.FundsChangeRecordHistory;
import com.xuebang.platform.unionpay.shell.repository.FundsChangeRecordHistoryRep;
import com.xuebang.platform.unionpay.shell.repository.FundsChangeRecordRep;
import com.xuebang.platform.unionpay.web.common.PageReq;
import com.xuebang.platform.unionpay.web.common.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 2017-11-25 1:10
 * FundsChangeRecordBackup
 * description: 转储 支付成功 或者 失败的收款记录
 */
@Component
public class FundsChangeRecordBackup {

    public static final Logger logger = LoggerFactory.getLogger(FundsChangeRecordBackup.class);

    @Value("${backup.size}")
    private int backupSize;

    @Autowired
    private FundsChangeRecordRep fundsChangeRecordRep;

    @Autowired
    private FundsChangeRecordHistoryRep fundsChangeRecordHistoryRep;

    @Scheduled(fixedRate = 60 * 1000)
    @Transactional
    public void backup() {
        logger.info("#############BACKUP BEGIN >> " + backupSize + " records per 1min #######");
        PageReq pageReq = new PageReq();
        pageReq.setPageSize(backupSize);
        Pageable pageable = WebUtil.pageRequest(pageReq);
        LocalDateTime weeksAgo = LocalDateTime.now().minusDays(7);
        Page<FundsChangeRecord> fundsChangeRecords = fundsChangeRecordRep.findAll((root, cq, cb) ->
                cb.and(root.get("paidStatus").in(Arrays.asList(PaidStatus.PAID, PaidStatus.FAILED))
                , cb.greaterThan(root.get("createTime"), weeksAgo)), pageable);

        fundsChangeRecords.forEach(r -> {
            FundsChangeRecordHistory history = FundsChangeRecordHistory.from(r);
            fundsChangeRecordHistoryRep.save(history);
            fundsChangeRecordRep.delete(r);
        });
        logger.info("#############BACKUP END#######");
    }
}
