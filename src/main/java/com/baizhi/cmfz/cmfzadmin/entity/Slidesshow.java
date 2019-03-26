package com.baizhi.cmfz.cmfzadmin.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class Slidesshow implements Serializable {
    private String slidesshowId;
    private String slidesshowDescribe;
    private String slidesshowPosition;
    private String slidesshowFlag;
    @JSONField(format = "yyy-MM-dd")
    private Date slidesshowUploadtime;

    public String getSlidesshowId() {
        return slidesshowId;
    }

    public void setSlidesshowId(String slidesshowId) {
        this.slidesshowId = slidesshowId;
    }

    public String getSlidesshowDescribe() {
        return slidesshowDescribe;
    }

    public void setSlidesshowDescribe(String slidesshowDescribe) {
        this.slidesshowDescribe = slidesshowDescribe;
    }

    public String getSlidesshowPosition() {
        return slidesshowPosition;
    }

    public void setSlidesshowPosition(String slidesshowPosition) {
        this.slidesshowPosition = slidesshowPosition;
    }

    public String getSlidesshowFlag() {
        return slidesshowFlag;
    }

    public void setSlidesshowFlag(String slidesshowFlag) {
        this.slidesshowFlag = slidesshowFlag;
    }

    public Date getSlidesshowUploadtime() {
        return slidesshowUploadtime;
    }

    public void setSlidesshowUploadtime(Date slidesshowUploadtime) {
        this.slidesshowUploadtime = slidesshowUploadtime;
    }

    @Override
    public String toString() {
        return "Slidesshow{" +
                "slidesshowId='" + slidesshowId + '\'' +
                ", slidesshowDescribe='" + slidesshowDescribe + '\'' +
                ", slidesshowPosition='" + slidesshowPosition + '\'' +
                ", slidesshowFlag='" + slidesshowFlag + '\'' +
                ", slidesshowUploadtime=" + slidesshowUploadtime +
                '}';
    }

    public Slidesshow(String slidesshowId, String slidesshowDescribe, String slidesshowPosition, String slidesshowFlag, Date slidesshowUploadtime) {
        this.slidesshowId = slidesshowId;
        this.slidesshowDescribe = slidesshowDescribe;
        this.slidesshowPosition = slidesshowPosition;
        this.slidesshowFlag = slidesshowFlag;
        this.slidesshowUploadtime = slidesshowUploadtime;
    }

    public Slidesshow() {
    }
}
