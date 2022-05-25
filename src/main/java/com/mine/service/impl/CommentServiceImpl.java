package com.mine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mine.entity.Comment;
import com.mine.mapper.CommentMapper;
import com.mine.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper,Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> queryAllComment() {
        return commentMapper.queryAllComment();
    }

    @Override
    public List<Comment> fingByArtnum(Integer artnum) {
        return commentMapper.fingByArtnum(artnum);
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public int addreply(Comment comment) {
        return commentMapper.addreply(comment);
    }

    @Override
    public int deleteComByComnum(Integer comnum) {
        return commentMapper.deleteComByComnum(comnum);
    }
}
