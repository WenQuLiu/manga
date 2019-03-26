package com.baizhi.cmfz.cmfzadmin.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private String logId;
    private String logUser;
    @JSONField(format = "yyy-MM-dd hh:mm:ss")
    private Date logTime;
    private String logSource;
    private String logAction;
    private String logMessage;
    private String logResult;

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogSource() {
        return logSource;
    }

    public void setLogSource(String logSource) {
        this.logSource = logSource;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public Log(String logId, String logUser, Date logTime, String logSource, String logAction, String logMessage, String logResult) {
        this.logId = logId;
        this.logUser = logUser;
        this.logTime = logTime;
        this.logSource = logSource;
        this.logAction = logAction;
        this.logMessage = logMessage;
        this.logResult = logResult;
    }

    public Log() {
    }

}
