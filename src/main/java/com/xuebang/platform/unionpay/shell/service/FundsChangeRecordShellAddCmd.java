package com.xuebang.platform.unionpay.shell.service;

import com.xuebang.platform.unionpay.shell.domain.FundsChangeRecord;

import java.math.BigDecimal;

/**
 * author: xyb
 * Date: 2017/11/24 18:00
 * desc: shellAddCmd
 */
public class FundsChangeRecordShellAddCmd {

    //支付金额
    private BigDecimal paidAmount = BigDecimal.ZERO;

    //备注
    private String remark;

    //校区
    private Long blCampusId;

    private String blCampusName;

    //机构id
    private Long institutionId;

    //商户编号
    private String codeNumber;

    //终端编号
    private String terminalNumber;

    public FundsChangeRecord toFundsChangeRecord() {//todo 字段待补充
        FundsChangeRecord fundsChangeRecord = FundsChangeRecord.newOne();

        return fundsChangeRecord;
    }

    public static FundsChangeRecordShellAddCmd newOne() {
        return new FundsChangeRecordShellAddCmd();
    }
}
