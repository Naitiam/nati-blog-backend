package com.mine.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mine.entity.Article;
import com.mine.entity.Tags;
import com.mine.mapper.ArticleMapper;
import com.mine.service.ArticleService;
import com.mine.service.TagsService;
import com.mine.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private TagsService tagsService;
//    @RequestMapping("/artmag")
//    public List<Article> queryAllArticle(){
//        return articleService.queryAllArticle();
//    }
    @GetMapping("/count")
    public Result<Map<String,Integer>> articlecount(){
        Map<String,Integer> data = new HashMap<>();
        data.put("articleall",articleService.articleall());
        data.put("artgoodall",articleService.artgoodall());
        data.put("artwatchall",articleService.artwatchall());
        return  new Result<Map<String,Integer>>(2000,"管理界面首页需要的数据",data);
    }

    //-----------------------------某文章界面-----------------------------
    @GetMapping("/{artnum}")
    public Result<Article> fingByArtnum(@PathVariable Integer artnum){
        Article article = articleService.findByArtnum(artnum);
            if(article.getArttags()== null||article.getArttags().isEmpty()||article.getArttags()==""){
                System.out.println(article.getArtnum()+"的tags是空的");
            }else {
                List<String> tagsList = new ArrayList<>();
                String[] strtags = article.getArttags().split(",");
                for (String strtag :strtags){
                    tagsList.add(strtag);
                }
                article.setTagsList(tagsList);
            }
        article.setArtwatch(article.getArtwatch()+1);
        return new Result<Article>(2000,"博客文章页面",article);
    }
    //-----------------------------监听转跳点赞数和浏览数-----------------------------
    @PostMapping("/watchgood")
    public Result<Void> updateWatchAndGood(@RequestBody Article article){
//        System.out.println(article+"--------------------");
        articleService.updateWatchAndGood(article);
        return new Result<>(2000,"更新成功",null);
    }


    //-----------------------------返回添加界面tag们-----------------------------
    @RequestMapping("/alltags")
    public List<Tags> queryTags(Article article)  {
        return tagsService.queryAlltags();
    }

    //----------------------------------添加更改----------------------------------
    @PostMapping("/artadd")
    public Integer savetArticle(@RequestBody Article article)  {
        //去掉[]
        String arttags = article.getTagsList().toString().replaceAll("(?:\\[|null|\\]| +)", "");
        article.setArtreltime(new Date());
        article.setArttags(arttags);
        //添加吧
        return articleService.saveArticle(article);
//        return 1;
    }

    //----------------------------------删除----------------------------------
    @DeleteMapping("/{artnum}")
    public Integer deleteArticle(@PathVariable Integer artnum){
        return articleService.deleteArticleByNum(artnum);
    }

    //----------------------------------分页查询----------------------------------
//    @GetMapping("/page")
//    public  Map<String,Object> articleFindPage(@RequestParam Integer pageNum,
//                                               @RequestParam Integer pageSize){
//        pageNum=(pageNum-1)*pageSize;
//        Integer total = articleMapper.selectTotal();
//        List<Article> data = articleMapper.selectPage(pageNum,pageSize);
////        System.out.println(data);
//        Map<String,Object> res= new HashMap<>();
//        res.put("data",data);
//        res.put("total",total);
//        return res;
//    }
    @GetMapping("/mag")
    public IPage<Article> articleFindPage(@RequestParam Integer pageNum,
                                          @RequestParam Integer pageSize,
                                          @RequestParam String articlename,
                                          @RequestParam String articletag){
        IPage<Article> page = new Page<Article>(pageNum,pageSize);
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("arttitle",articlename);
        queryWrapper.like("arttags",articletag);
        IPage<Article> artpage = articleService.page(page,queryWrapper.select().orderByDesc("artnum"));
//        System.out.println("artpage.getRecords()"+artpage.getRecords());
        List<Article> artlist = artpage.getRecords();
//        System.out.println(artlist.get(5)+"这里是打印");
        for(Article article : artlist){
            if(article.getArttags()== null||article.getArttags().isEmpty()||article.getArttags()==""){
                System.out.println(article.getArtnum()+"的tags是空的");
            }else {
//                System.out.println("1");
                List<String> tagsList = new ArrayList<>();
                String[] strtags = article.getArttags().split(",");
                for (String strtag :strtags){
                tagsList.add(strtag);
             }
            article.setTagsList(tagsList);
            }
        }
        artpage.setRecords(artlist);
        return artpage;
    }

}
