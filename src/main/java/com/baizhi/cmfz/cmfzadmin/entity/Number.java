package com.baizhi.cmfz.cmfzadmin.entity;

import java.io.Serializable;
import java.util.Date;

public class Number implements Serializable {
    private String numberId;
    private String numberCount;
    private String numberName;
    private Date numberTime;
    private String classId;
    private String userId;

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getNumberCount() {
        return numberCount;
    }

    public void setNumberCount(String numberCount) {
        this.numberCount = numberCount;
    }

    public String getNumberName() {
        return numberName;
    }

    public void setNumberName(String numberName) {
        this.numberName = numberName;
    }

    public Date getNumberTime() {
        return numberTime;
    }

    public void setNumberTime(Date numberTime) {
        this.numberTime = numberTime;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
