package com.baizhi.cmfz.cmfzadmin.service;

import com.baizhi.cmfz.cmfzadmin.entity.Article;

import java.util.List;

public interface ArticleService {
    public int add(Article article);

    List<Article> selectAllArticle();

}
