package com.mine.service.impl;

import com.mine.entity.Tags;
import com.mine.mapper.TagsMapper;
import com.mine.service.TagsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {
    @Resource
    private TagsMapper tagsMapper;
    @Override
    public List<Tags> queryAlltags() {
        return tagsMapper.queryAlltags();
    }
}
