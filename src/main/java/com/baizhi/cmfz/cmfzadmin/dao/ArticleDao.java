package com.baizhi.cmfz.cmfzadmin.dao;

import com.baizhi.cmfz.cmfzadmin.entity.Article;

import java.util.List;

/**
 * @Description 文章Dao层功能
 * @Author wumengkai
 * @Time 2018-7-9
 */
public interface ArticleDao {
    /**
     * @Description 添加文章
     * @Author wumengkai
     * @Time 2018-7-9
     * @Param
     * @Exception
     */
    public int insert(Article article);

    List<Article> selectAllArticle();
}
