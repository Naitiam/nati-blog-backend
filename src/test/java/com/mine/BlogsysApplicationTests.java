package com.mine;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mine.entity.*;
import com.mine.mapper.ArticleMapper;
import com.mine.mapper.CommentMapper;
import com.mine.mapper.MineMapper;
import com.mine.mapper.TagsMapper;
import com.mine.service.ArticleService;
import com.mine.service.MineService;
import com.mine.util.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.text.ParseException;
import java.util.*;

@SpringBootTest
class BlogsysApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        System.out.println(dataSource);
    }//测试数据库是否连上

    @Resource
    private MineMapper mineMapper;
    @Autowired
    private MineService mineServices;

    @Test
    void  index(){
//        System.out.println(mineServices.findMineInfo("naitiam"));
        MineInfo mineInfo = new MineInfo();
        mineInfo.setAdmnum(1);
        mineInfo.setAdmintroduction("这是介绍");
        mineInfo.setAdmpwd("111111");
        mineInfo.setAdmemail("none");
        System.out.println(mineMapper.updateMineInfo(mineInfo));
    }

//
    @Resource
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleService articleService;

//    @Test
//    public void queryAll(){
//        List<Article> list = articleService.queryAllArticle();
//        list.forEach(System.out::println);
//    }
//    @Test
//    public void addart() throws ParseException {
//        Article aa = new Article();
//        aa.setArttitle("ssssss");
//        aa.setArtauthor("ssss");
//        aa.setArtreltime(new Date());
//        aa.setArtmodtime(null);
//        aa.setArtcontent("aaaa");
//        aa.setArttags("aaaa");
//        aa.setArtphoto("");
//        aa.setArtgood(15);
//        aa.setArtwatch(0);
//       articleMapper.addArticle(aa);
//    }
//    @Test
//    public void updateArt() {
//        Article aa = new Article();
//        aa.setArtnum(6);
//        aa.setArttitle("en");
//        aa.setArtauthor("ssss");
//        aa.setArtmodtime(new Date());
//        aa.setArtcontent("aaaa");
//        aa.setArttags("aaaa");
//        System.out.println(aa);
//        articleMapper.updateArticle(aa);
//    }
//    @Test
//    public void pageArt() {
//        List<Article> list = articleMapper.selectPage(1,2);
//        list.forEach(System.out::println);
//        System.out.println(articleMapper.selectTotal());
//    }

    @Resource
    private TagsMapper tagsMapper;
    @Test
    public void findByTagnum(){
        System.out.println(tagsMapper.findByTagnum(10000));
    }
    @Test
    public void queryAlltags(){
        List<Tags> list = tagsMapper.queryAlltags();
        list.forEach(System.out::println);
    }

    @Test
    void aa(){
        List<Tags> list = tagsMapper.queryAlltags();
        List<String> tagsList = new ArrayList<>();
        for(Tags i:list){
            tagsList.add(i.getTagname());
        }
        System.out.println("得到的"+tagsList);
        List<EchartsData> data = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        for (String tag:tagsList){
            QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("arttags",tag);
            Long count =articleMapper.selectCount(queryWrapper);
            EchartsData a = new EchartsData();
            a.setName(tag);
            a.setValue(count.intValue());
            data.add(a);
            System.out.println(a+"这是");
            map.put(tag, String.valueOf(count));
        }
        System.out.println("让我康康"+data.get(1).getName());
        System.out.println("让我康康"+map);

    }

    @Test
    void aas(){
        System.out.println(articleMapper.articleall());
        System.out.println(articleMapper.artgoodall());
        System.out.println(articleMapper.artwatchall());
    }

    @Resource
    private CommentMapper commentMapper;

    @Test
    void aaaa(){
        Comment com = new Comment();
//        com.setComname("路人A");
//        com.setComcontent("sorry");
//        com.setComtime(new Date());
        com.setComnum(8);
        com.setComreply("这里是回复的内容");
//        System.out.println(commentMapper.addComment(com));
//        List<Comment> list= commentMapper.fingByArtnum(1);
//        System.out.println(list);
//        List<Comment> com = commentMapper.queryAllComment();
//        com.forEach(System.out::println);
        commentMapper.addreply(com);
        commentMapper.deleteComByComnum(8);
    }
    @Test
    public void aaaaa(){
        Article article = new Article();
        article.setArtnum(2);
        article.setArtwatch(2);
        article.setArtgood(5);
        articleMapper.updateWatchAndGood(article);
    }
}
