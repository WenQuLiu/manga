package com.baizhi.cmfz.cmfzadmin.entity;

import java.io.Serializable;
import java.util.List;

public class RichTextResult implements Serializable {
    private Integer errno;
    private List<String> data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
