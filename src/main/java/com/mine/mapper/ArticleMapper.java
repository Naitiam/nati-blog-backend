package com.mine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mine.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
    //查找全部文章
    List<Article> queryAllArticle();
    Article findByArtnum(Integer artnum);

    //文章总数
    int articleall();
    //点赞总数
    int artgoodall();
    //浏览总数
    int artwatchall();

    //添加文章
    int addArticle(Article article);
    //修该文章
    int updateArticle(Article article);
    //删除文章
    int deleteArticleByNum(Integer artnum);

    //分页查询
    //这里不使用@Param注解会报错Parameter 'pageNum' not found. Available parameters are [arg1, arg0, param1, param2]
//    List<Article> selectPage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
//    Integer selectTotal();

}
