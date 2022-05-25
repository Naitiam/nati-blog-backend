package com.mine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mine.entity.Comment;

import java.util.List;

public interface CommentService extends IService<Comment> {

    List<Comment> queryAllComment();
    List<Comment> fingByArtnum(Integer artnum);
    int addComment(Comment comment);
    int addreply(Comment comment);
    int deleteComByComnum(Integer comnum);

}
