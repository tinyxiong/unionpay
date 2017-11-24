package com.xuebang.platform.unionpay.web.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * File name: WebUtil
 * User: Robin
 * Date: 2017/5/29  15:12
 * description: 用户web端的工具类
 */
public class WebUtil {

    /**
     * 用户装换 内部的 pageRest 到 Spring data 的 PageRequest
     * @param pageReq
     * @return
     */
    public static Pageable pageRequest(PageReq pageReq) {

        if(pageReq == null) {
            pageReq = new PageReq();
        }
        Pageable pageable = pageReq.buildPageRequest();
        return  pageable;
    }
    /**
     * 用户装换 内部的 pageRest 到 Spring data 的 PageRequest
     * @param pageReq
     * @return
     */
    public static Pageable pageRequest(PageReq pageReq, Sort sort) {
        if(pageReq == null) {
            pageReq = new PageReq();
        }
        Pageable pageable = new PageRequest( pageReq.getPage() - 1, pageReq.getPageSize(),sort);
        return  pageable;
    }
}
