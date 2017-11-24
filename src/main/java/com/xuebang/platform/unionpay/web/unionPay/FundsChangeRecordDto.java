package com.xuebang.platform.unionpay.web.unionPay;

import com.xuebang.platform.unionpay.shell.domain.FundsChangeRecord;

import java.math.BigDecimal;

/**
 * author: xyb
 * Date: 2017/11/24 18:35
 * desc:
 */
public class FundsChangeRecordDto {

    private Long id;

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

    private String paidStatusValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPaidStatusValue() {
        return paidStatusValue;
    }

    public void setPaidStatusValue(String paidStatusValue) {
        this.paidStatusValue = paidStatusValue;
    }

    public static FundsChangeRecordDto fromFundsChangeRecord(FundsChangeRecord fundsChangeRecord) {
        FundsChangeRecordDto fundsChangeRecordDto= new FundsChangeRecordDto();
        fundsChangeRecordDto.setId(fundsChangeRecord.getId());
        fundsChangeRecordDto.setPaidAmount(fundsChangeRecord.getPaidAmount());
        fundsChangeRecordDto.setRemark(fundsChangeRecord.getRemark());
        fundsChangeRecordDto.setBlCampusId(fundsChangeRecord.getBlCampusId());
        fundsChangeRecordDto.setBlCampusName(fundsChangeRecord.getBlCampusName());
        fundsChangeRecordDto.setInstitutionId(fundsChangeRecord.getInstitutionId());
        fundsChangeRecordDto.setCodeNumber(fundsChangeRecord.getCodeNumber());
        fundsChangeRecordDto.setTerminalNumber(fundsChangeRecord.getTerminalNumber());
        fundsChangeRecordDto.setPaidStatusValue(fundsChangeRecord.getPaidStatus().getValue());
        return fundsChangeRecordDto;
    }
}
