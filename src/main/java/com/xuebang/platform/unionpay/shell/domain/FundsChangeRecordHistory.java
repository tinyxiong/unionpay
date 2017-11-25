package com.xuebang.platform.unionpay.shell.domain;

import com.xuebang.platform.unionpay.shell.constants.PaidStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * author: xyb
 * Date: 2017/11/24 17:43
 * desc:
 */
@Entity
public class FundsChangeRecordHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //支付状态
    @Enumerated(EnumType.STRING)
    private PaidStatus paidStatus;

    //支付金额
    private BigDecimal paidAmount;

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

    //创建时间
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaidStatus getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(PaidStatus paidStatus) {
        this.paidStatus = paidStatus;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public static FundsChangeRecordHistory newOne() {
        return new FundsChangeRecordHistory();
    }

    public static FundsChangeRecordHistory from(FundsChangeRecord r) {
        FundsChangeRecordHistory history = FundsChangeRecordHistory.newOne();
        history.setPaidStatus(r.getPaidStatus());
        history.setPaidAmount(r.getPaidAmount());
        history.setRemark(r.getRemark());
        history.setBlCampusId(r.getBlCampusId());
        history.setBlCampusName(r.getBlCampusName());
        history.setInstitutionId(r.getInstitutionId());
        history.setCodeNumber(r.getCodeNumber());
        history.setTerminalNumber(r.getTerminalNumber());
        history.setCreateTime(r.getCreateTime());
        return history;
    }
}
