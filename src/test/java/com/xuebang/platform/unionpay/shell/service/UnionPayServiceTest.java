package com.xuebang.platform.unionpay.shell.service;

import com.xuebang.platform.common.AbstractServiceTest;
import com.xuebang.platform.unionpay.shell.constants.PaidStatus;
import com.xuebang.platform.unionpay.shell.domain.FundsChangeRecord;
import com.xuebang.platform.unionpay.shell.repository.FundsChangeRecordRep;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Transactional
public class UnionPayServiceTest extends AbstractServiceTest {

    @Autowired
    private UnionPayService unionPayService;

    @Autowired
    private FundsChangeRecordRep fundsChangeRecordRep;

    private FundsChangeRecordShellAddCmd shellAddCmd;

    @Before
    public void setup() {
        shellAddCmd = FundsChangeRecordShellAddCmd.newOne();
        shellAddCmd.setBlCampusId(1L);
        shellAddCmd.setBlCampusName("test校区");
        shellAddCmd.setCodeNumber("123456");
        shellAddCmd.setInstitutionId(11L);
        shellAddCmd.setPaidAmount(BigDecimal.valueOf(240));
        shellAddCmd.setRemark("测试就偶尔服务额");
        shellAddCmd.setTerminalNumber("1234567");
    }

    @Test
    @Rollback
    public void add() throws Exception {
        long before = fundsChangeRecordRep.count(null);

        unionPayService.add(shellAddCmd);

        long after = fundsChangeRecordRep.count(null);
        assertEquals(before + 1, after);

        FundsChangeRecord one = fundsChangeRecordRep.findOne((root, cq, cb) -> cb.equal(root.get("id"), 17L));
        assertEquals("test校区", one.getBlCampusName());
        assertEquals(1, one.getBlCampusId().intValue());
        assertEquals("123456", one.getCodeNumber());
        assertEquals("测试就偶尔服务额", one.getRemark());
        assertEquals("1234567", one.getTerminalNumber());
        assertEquals(11, one.getInstitutionId().intValue());
        assertEquals(240, one.getPaidAmount().intValue());
        assertEquals(PaidStatus.UNPAID, one.getPaidStatus());
    }

    @Rule
    public ExpectedException thrown  = ExpectedException.none();

    @Test
    @Rollback
    public void confirm() throws Exception {
        Long id = 14L;
        unionPayService.confirm(id);
        FundsChangeRecord fundsChangeRecord = fundsChangeRecordRep.findOne((root, cq, cb) -> cb.equal(root.get("id"), id));

        assertEquals(PaidStatus.PAYING, fundsChangeRecord.getPaidStatus());
    }

    @Test
    @Rollback
    public void confirmFailed() throws Exception {
        Long id = 15L;
        thrown.expect(Exception.class);
        thrown.expectMessage("该收款记录已被锁定");
        unionPayService.confirm(id);
    }

}