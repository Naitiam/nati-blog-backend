package com.mine.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mine.entity.Article;
import com.mine.entity.Comment;
import com.mine.service.ArticleService;
import com.mine.service.CommentService;
import com.mine.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(("/comment"))
public class CommentController {
    @Resource
    private CommentService commentService;
    @Resource
    private ArticleService articleService;

    @GetMapping("/{artnum}")
    public Result<List<Comment>> findByArtnum(@PathVariable Integer artnum){
        List<Comment> comlist= commentService.fingByArtnum(artnum);
        return new Result<List<Comment>>(2000,"文章的评论们",comlist);
    }

    @PostMapping("/addcom")
    public Result<Void> addComment(@RequestBody Comment comment){
        if(comment.getComname()!=""&&comment.getComcontent()!=""){
            comment.setComtime(new Date());
            commentService.addComment(comment);
            return  new Result<>(2000,"评论成功",null);
        }
        return  new Result<>(2001,"评论失败",null);
    }

    //----------------------------------管理评论----------------------------------
    @GetMapping("/mag")
    public IPage<Comment> articleFindPage(@RequestParam Integer pageNum,
                                          @RequestParam Integer pageSize){
        IPage<Comment> page = new Page<Comment>(pageNum,pageSize);
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        IPage<Comment> compage = commentService.page(page,queryWrapper.select().orderByDesc("comnum"));
        List<Comment> comlist = compage.getRecords();
        //使用迭代器惊醒删改元素，it.next()一次循环不能重复出现会让迭代器下标加一NoSuchElementException
        Iterator<Comment> it = comlist.iterator();
        while(it.hasNext()){
            Comment com =it.next();
            Article art = articleService.findByArtnum(com.getArtnum());
//            System.out.println(com.getComname());
            if(art != null){
//                System.out.println(art.getArttitle()+com.getArtnum()+"文章存在的");
                com.setArttitle(art.getArttitle());
            }else {
//                System.out.println("该评论文章已被删除"+com.getArtnum());
                commentService.deleteComByComnum(com.getComnum());
                it.remove();

            }
        }
        compage.setRecords(comlist);
        return compage;
    }
    //----------------------------------回复----------------------------------
    @PostMapping("/reply")
    public Result<Void> addreply(@RequestBody Comment comment){
        commentService.addComment(comment);
        return new Result<>(2000,"回复成功",null);
    }

    //----------------------------------删除评论----------------------------------
    @DeleteMapping("/{comnum}")
    public  Result<Void> deleteArticle(@PathVariable Integer comnum){
        commentService.deleteComByComnum(comnum);
        return new Result<>(2000,"删除成功",null);
    }

}
