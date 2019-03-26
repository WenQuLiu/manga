package com.baizhi.cmfz.cmfzadmin.entity;

import java.io.Serializable;

public class Frequency implements Serializable {
    private String frequencyId;
    private String frequencyName;
    private String frequencyLarge;
    private String frequencyPosition;
    private Integer frequencyIploads;
    private String specialId;

    public String getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(String frequencyId) {
        this.frequencyId = frequencyId;
    }

    public String getFrequencyName() {
        return frequencyName;
    }

    public void setFrequencyName(String frequencyName) {
        this.frequencyName = frequencyName;
    }

    public String getFrequencyLarge() {
        return frequencyLarge;
    }

    public void setFrequencyLarge(String frequencyLarge) {
        this.frequencyLarge = frequencyLarge;
    }

    public String getFrequencyPosition() {
        return frequencyPosition;
    }

    public void setFrequencyPosition(String frequencyPosition) {
        this.frequencyPosition = frequencyPosition;
    }

    public Integer getFrequencyIploads() {
        return frequencyIploads;
    }

    public void setFrequencyIploads(Integer frequencyIploads) {
        this.frequencyIploads = frequencyIploads;
    }

    public String getSpecialId() {
        return specialId;
    }

    public void setSpecialId(String specialId) {
        this.specialId = specialId;
    }
}
