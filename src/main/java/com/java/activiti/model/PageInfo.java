package com.java.activiti.model;

import java.util.List;

/*
 * ��ҳ������
 */
public class PageInfo<T> {
    public Integer pageSize = 5;
    private Integer count;// �ܼ�¼��
    private List<T> pageList;// ��ǰҳ�ļ�¼����
    private Integer pageIndex;// ��ǰҳ��
    private Integer totalPages;// ��ҳ��

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCount() {
        return count;
    }


    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalPages() {
        this.totalPages = this.count / this.pageSize;
        if (this.count % this.pageSize != 0)
            this.totalPages++;
        return this.totalPages;
    }

}
