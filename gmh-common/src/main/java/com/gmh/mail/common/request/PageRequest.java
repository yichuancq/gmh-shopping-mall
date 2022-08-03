package com.gmh.mail.common.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 自定义分页请求Dto
 *
 * @author yichuan
 */

@AllArgsConstructor
@NoArgsConstructor
public class PageRequest implements Serializable {
    /***
     *页索引
     */
    private Integer pageNumber = 0;
    /***
     *每页大小
     */
    private Integer pageSize = 20;

    @Override
    public String toString() {
        return "PageRequest{" + "pageNumber=" + pageNumber + ", pageSize=" + pageSize + '}';
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
