package com.xuebang.platform.unionpay.web.common;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序和分页的Request, 这个分页和排序的request 只能给 spring data 使用
 * Created by Sip- on 2017/7/20.
 */
public class SortablePageReq extends PageReq{

    public SortablePageReq(){}

    /**
     * 排序参数
     */
    private String sortField;

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    /**

     * 排序方式，升序或降序
     */
    private String sortType;


    @Override
    public Pageable buildPageRequest() {
        if (StringUtils.isNotBlank(this.getSortField())) {
            Sort.Direction SortType = Sort.Direction.ASC;
            if (StringUtils.isNotBlank(this.getSortType())) {
                SortType = Sort.Direction.valueOf(this.getSortType());
            }
            String fields[]= this.getSortField().split(",");
            List<Sort.Order> orders=new ArrayList<Sort.Order>();
            for(String field:fields){
                Sort.Order order = new Sort.Order(SortType, field);
                orders.add(order);
            }
            Sort sort= new Sort(orders);
            return WebUtil.pageRequest(this, sort);
        }else{
            return super.buildPageRequest();
        }
    }
}
