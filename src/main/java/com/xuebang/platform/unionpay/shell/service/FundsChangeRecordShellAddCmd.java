package com.xuebang.platform.unionpay.shell.service;
import com.xuebang.platform.unionpay.shell.constants.PaidStatus;

import com.xuebang.platform.unionpay.shell.domain.FundsChangeRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getBlCampusId() {
        return blCampusId;
    }

    public void setBlCampusId(Long blCampusId) {
        this.blCampusId = blCampusId;
    }

    public String getBlCampusName() {
        return blCampusName;
    }

    public void setBlCampusName(String blCampusName) {
        this.blCampusName = blCampusName;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getTerminalNumber() {
        return terminalNumber;
    }

    public void setTerminalNumber(String terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    public FundsChangeRecord toFundsChangeRecord() {
        FundsChangeRecord fundsChangeRecord = FundsChangeRecord.newOne();
        fundsChangeRecord.setPaidStatus(PaidStatus.UNPAID);
        fundsChangeRecord.setPaidAmount(this.paidAmount);
        fundsChangeRecord.setRemark(this.remark);
        fundsChangeRecord.setBlCampusId(this.blCampusId);
        fundsChangeRecord.setBlCampusName(this.blCampusName);
        fundsChangeRecord.setInstitutionId(this.institutionId);
        fundsChangeRecord.setCodeNumber(this.codeNumber);
        fundsChangeRecord.setTerminalNumber(this.terminalNumber);
        fundsChangeRecord.setCreateTime(LocalDateTime.now());
        return fundsChangeRecord;
    }

    public static FundsChangeRecordShellAddCmd newOne() {
        return new FundsChangeRecordShellAddCmd();
    }
}
