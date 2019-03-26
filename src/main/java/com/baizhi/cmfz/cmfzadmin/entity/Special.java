package com.baizhi.cmfz.cmfzadmin.entity;

import java.io.Serializable;
import java.util.Date;

public class Special implements Serializable {
    private String specialId;
    private String specialName;
    private String specialAuthor;
    private String specialVoicepeople;
    private String specialIntro;
    private Date specialTime;
    private String specialVocer;
    private Integer specialGrade;
    private Integer specialNumber;
    private String guruId;

    public String getSpecialId() {
        return specialId;
    }

    public void setSpecialId(String specialId) {
        this.specialId = specialId;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    public String getSpecialAuthor() {
        return specialAuthor;
    }

    public void setSpecialAuthor(String specialAuthor) {
        this.specialAuthor = specialAuthor;
    }

    public String getSpecialVoicepeople() {
        return specialVoicepeople;
    }

    public void setSpecialVoicepeople(String specialVoicepeople) {
        this.specialVoicepeople = specialVoicepeople;
    }

    public String getSpecialIntro() {
        return specialIntro;
    }

    public void setSpecialIntro(String specialIntro) {
        this.specialIntro = specialIntro;
    }

    public Date getSpecialTime() {
        return specialTime;
    }

    public void setSpecialTime(Date specialTime) {
        this.specialTime = specialTime;
    }

    public String getSpecialVocer() {
        return specialVocer;
    }

    public void setSpecialVocer(String specialVocer) {
        this.specialVocer = specialVocer;
    }

    public Integer getSpecialGrade() {
        return specialGrade;
    }

    public void setSpecialGrade(Integer specialGrade) {
        this.specialGrade = specialGrade;
    }

    public Integer getSpecialNumber() {
        return specialNumber;
    }

    public void setSpecialNumber(Integer specialNumber) {
        this.specialNumber = specialNumber;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }
}
