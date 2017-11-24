package com.xuebang.platform.unionpay.web.unionPay;

import com.xuebang.platform.unionpay.shell.service.FundsChangeRecordShellAddCmd;

import java.math.BigDecimal;

/**
 * author: xyb
 * Date: 2017/11/24 17:33
 * desc: 接受收款记录的cmd
 */
public class FundsChangeRecordAddCmd {

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

    public FundsChangeRecordShellAddCmd toShellAddCmd() {
        FundsChangeRecordShellAddCmd shellAddCmd = FundsChangeRecordShellAddCmd.newOne();
        shellAddCmd.setPaidAmount(this.paidAmount);
        shellAddCmd.setRemark(this.remark);
        shellAddCmd.setBlCampusId(this.blCampusId);
        shellAddCmd.setBlCampusName(this.blCampusName);
        shellAddCmd.setInstitutionId(this.institutionId);
        shellAddCmd.setCodeNumber(this.codeNumber);
        shellAddCmd.setTerminalNumber(this.terminalNumber);
        return shellAddCmd;
    }
}
