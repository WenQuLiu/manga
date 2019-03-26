package com.baizhi.cmfz.cmfzadmin.service.Impl;

import com.baizhi.cmfz.cmfzadmin.dao.ArticleDao;
import com.baizhi.cmfz.cmfzadmin.entity.Article;
import com.baizhi.cmfz.cmfzadmin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Override
    public int add(Article article) {
        return articleDao.insert(article);
    }
    @Override
    public List<Article> selectAllArticle(){
        List<Article> articles = articleDao.selectAllArticle();
        return  articles;
    }

}
