package com.baizhi.cmfz.cmfzadmin.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
public class Guru implements Serializable {
    @Excel(name="上师编号",isImportField = "true_st")
    private String guruId;
    @Excel(name="上师法号",isImportField = "true_st")
    private String guruName;
    @Excel(name="上师头像",isImportField = "true_st")
    private String guruPhoto;
    @Excel(name="上师简介",isImportField = "true_st")
    private String guruContent;

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName;
    }

    public String getGuruPhoto() {
        return guruPhoto;
    }

    public void setGuruPhoto(String guruPhoto) {
        this.guruPhoto = guruPhoto;
    }

    public String getGuruContent() {
        return guruContent;
    }

    public void setGuruContent(String guruContent) {
        this.guruContent = guruContent;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guruId='" + guruId + '\'' +
                ", guruName='" + guruName + '\'' +
                ", guruPhoto='" + guruPhoto + '\'' +
                ", guruContent='" + guruContent + '\'' +
                '}';
    }

    public Guru() {
    }

    public Guru(String guruId, String guruName, String guruPhoto, String guruContent) {
        this.guruId = guruId;
        this.guruName = guruName;
        this.guruPhoto = guruPhoto;
        this.guruContent = guruContent;
    }

    public Guru(String guruId, String guruName, String guruContent) {
        this.guruId = guruId;
        this.guruName = guruName;
        this.guruContent = guruContent;
    }

}
