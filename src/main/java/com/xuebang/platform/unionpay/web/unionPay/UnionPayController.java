package com.xuebang.platform.unionpay.web.unionPay;

import com.xuebang.platform.unionpay.shell.constants.PaidStatus;
import com.xuebang.platform.unionpay.shell.domain.FundsChangeRecord;
import com.xuebang.platform.unionpay.shell.repository.FundsChangeRecordRep;
import com.xuebang.platform.unionpay.shell.service.FundsChangeRecordShellAddCmd;
import com.xuebang.platform.unionpay.shell.service.UnionPayService;
import com.xuebang.platform.unionpay.web.common.Response;
import com.xuebang.platform.unionpay.web.common.SortablePageReq;
import com.xuebang.platform.unionpay.web.common.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * author: xyb
 * Date: 2017/11/24 17:32
 * desc: 后台支付主入口
 */
@RestController
@RequestMapping("/UnionPayController")
public class UnionPayController {

    @Autowired
    private FundsChangeRecordRep fundsChangeRecordRep;

    @Autowired
    private UnionPayService unionPayService;

    /**
     * 生成一条待支付的收款记录
     *
     * @param addCmd 收款信息
     */
    @PostMapping("/add")
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(@RequestBody FundsChangeRecordAddCmd addCmd) {
        FundsChangeRecordShellAddCmd shellAddCmd = addCmd.toShellAddCmd();
        unionPayService.add(shellAddCmd);
    }

    /**
     * 返回一个待收款的列表
     * @param pageReq
     * @return
     */
    @GetMapping("/page")
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Response page(SortablePageReq pageReq,@ModelAttribute ListQo listQo) {

        Pageable pageable = WebUtil.pageRequest(pageReq);

        Page<FundsChangeRecord> records = fundsChangeRecordRep.findAll((root, cq, cb) ->
                        cb.and(cb.equal(root.get("paidStatus"), PaidStatus.UNPAID)
                        , cb.equal(root.get("blCampusId"), listQo.getBlCampusId())
                        , cb.equal(root.get("institutionId"), listQo.getInstitutionId())
                        , cb.equal(root.get("terminalNumber"), listQo.getTerminalNumber())
                        ), pageable);

        Page<FundsChangeRecordDto> dtos = records.map(FundsChangeRecordDto::fromFundsChangeRecord);
        return Response.newDataResponse(dtos);
    }

    /**
     * 确认一条支付记录
     * @param id
     */
    @GetMapping("/confirm/{id}")
    @Transactional(propagation = Propagation.REQUIRED)
    public Response confirm(@PathVariable Long id) {
        try {
            unionPayService.confirm(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.newErrorResponse("收款记录已被锁定");
        }
        return Response.newNormalResponse();
    }

    /**
     * 支付成功
     * @param id
     */
    @GetMapping("/success/{id}")
    @Transactional(propagation = Propagation.REQUIRED)
    public Response success(@PathVariable Long id) {
        FundsChangeRecord fundsChangeRecord = fundsChangeRecordRep.findOne((root, cq, cb) -> cb.equal(root.get("id"), id));
        fundsChangeRecord.success();//支付成功
        return Response.newNormalResponse();
    }

    /**
     * 支付失败
     * @param id
     */
    @GetMapping("/failed/{id}")
    @Transactional(propagation = Propagation.REQUIRED)
    public Response failed(@PathVariable Long id) {
        FundsChangeRecord fundsChangeRecord = fundsChangeRecordRep.findOne((root, cq, cb) -> cb.equal(root.get("id"), id));
        fundsChangeRecord.failed();//支付失败
        return Response.newNormalResponse();
    }

    private static class ListQo {

        private Long blCampusId;
        private Long institutionId;
        private String terminalNumber;

        public Long getBlCampusId() {
            return blCampusId;
        }

        public void setBlCampusId(Long blCampusId) {
            this.blCampusId = blCampusId;
        }

        public Long getInstitutionId() {
            return institutionId;
        }

        public void setInstitutionId(Long institutionId) {
            this.institutionId = institutionId;
        }

        public String getTerminalNumber() {
            return terminalNumber;
        }

        public void setTerminalNumber(String terminalNumber) {
            this.terminalNumber = terminalNumber;
        }
    }
}
