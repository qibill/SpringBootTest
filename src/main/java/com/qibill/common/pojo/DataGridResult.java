package com.qibill.common.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 表格的返回类型
 *
 * @author qiminghui
 * @date 2017年7月4日 下午5:28:20
 */
public class DataGridResult {
    private long total;
    private int page;
    private List<?> rows;

    @JsonProperty("Total")
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @JsonProperty("Rows")
    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    @JsonProperty("page")
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
