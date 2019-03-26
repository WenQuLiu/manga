package com.baizhi.cmfz.cmfzadmin.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private String articleId;
    private String articleTitle;
    private String articleContent;
    //private String articlePosition;
    @JSONField(format = "yyy-MM-dd")
    private Date articleUptime;
    private String guruId;
    private String articleFlag;

    public String getArticleFlag() {
        return articleFlag;
    }

    public void setArticleFlag(String articleFlag) {
        this.articleFlag = articleFlag;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleUptime() {
        return articleUptime;
    }

    public void setArticleUptime(Date articleUptime) {
        this.articleUptime = articleUptime;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public Article(String articleId, String articleTitle, String articleContent, Date articleUptime, String guruId, String articleFlag) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleUptime = articleUptime;
        this.guruId = guruId;
        this.articleFlag = articleFlag;
    }

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleUptime=" + articleUptime +
                ", guruId='" + guruId + '\'' +
                ", articleFlag='" + articleFlag + '\'' +
                '}';
    }
}
