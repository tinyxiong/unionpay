package com.xuebang.platform.unionpay.web.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * File name: 用于分页和排序的 request
 * User: Robin
 * Date: 2017/5/29  15:08
 * description: 用于 分页 和 排序的request
 */
public class PageReq extends Request{

    /**
     * 第几页， 从 1 开始算起， antl 的 list 是从1 开始算起的
     * */
    Integer page;
    /**
     * 每一页有几条数据
     * */
    Integer pageSize;

    public PageReq(){
        this.page = 1;
        this.pageSize = 10;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * 构造出一个可以给到 spring data 使用的 page request
     * @return
     */
    public Pageable buildPageRequest() {
        Pageable pageable = new PageRequest( this.getPage() - 1, this.getPageSize());  /* spring data 从0 开始算为第一页 */
        return pageable;
    }
}
