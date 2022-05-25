package com.mine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mine.entity.Article;

import java.util.List;

public interface ArticleService extends IService<Article> {
//    List<Article> queryAllArticle();
    Article findByArtnum(Integer artnum);
    int saveArticle(Article article);
    int deleteArticleByNum(Integer artnum);

    int articleall();
    int artgoodall();
    int artwatchall();
    int updateWatchAndGood(Article article);

}
