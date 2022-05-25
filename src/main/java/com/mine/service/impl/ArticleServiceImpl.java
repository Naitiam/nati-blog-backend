package com.mine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mine.entity.Article;
import com.mine.mapper.ArticleMapper;
import com.mine.mapper.TagsMapper;
import com.mine.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService  {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private TagsMapper tagsMapper;

//    @Override
//    public List<Article> queryAllArticle() {
//        List<Article> artlist = articleMapper.queryAllArticle();
////        System.out.println(artlist.get(5)+"这里是打印");
//        for(Article article : artlist){
//            if(article.getArttags()==null){
//                System.out.println(article.getArtnum()+"的tags是空的");
//            }else {
//                System.out.println("1");
//                List<String> tagsList = new ArrayList<>();
//                String[] strtags = article.getArttags().split(",");
//                for (String strtag :strtags){
//                    tagsList.add(strtag);
//                }
////                tagsList.forEach(System.out::println);
////                System.out.println("-------------");
//                article.setTagsList(tagsList);
//            }
//        }
//        return artlist;
//    }

    @Override
    public Article findByArtnum(Integer artnum) {
        return articleMapper.findByArtnum(artnum);
    }

    @Override
    public int saveArticle(Article article) {

        if(article.getArtnum()==null){//没有id就是添加
            return articleMapper.addArticle(article);
        }else{
            article.setArtmodtime(new Date());
            return articleMapper.updateArticle(article);
        }

    }

    @Override
    public int deleteArticleByNum(Integer artnum) {
        return articleMapper.deleteArticleByNum(artnum);
    }

    @Override
    public int articleall() {
        return articleMapper.articleall();
    }

    @Override
    public int artgoodall() {
        return articleMapper.artgoodall();
    }

    @Override
    public int artwatchall() {
        return articleMapper.artwatchall();
    }

}
