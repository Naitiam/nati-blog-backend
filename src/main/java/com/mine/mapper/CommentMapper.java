package com.mine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mine.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    //查群全部评论
    List<Comment> queryAllComment();
    //查询评论通过外键
    List<Comment> fingByArtnum(Integer artnum);
    //添加评论
    int addComment(Comment comment);

    //回复
    int addreply(Comment comment);
    //删除评论
    int deleteComByComnum(Integer comnum);
}
