package com.mine.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mine.entity.Article;
import com.mine.entity.EchartsData;
import com.mine.entity.Tags;
import com.mine.mapper.ArticleMapper;
import com.mine.service.ArticleService;
import com.mine.service.TagsService;
import com.mine.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EchartsController {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private TagsService tagsService;

    @GetMapping("/echarts")
    public Result<List<EchartsData>> get() {
        List<Tags> list = tagsService.queryAlltags();
        List<String> tagsList = new ArrayList<>();
        for(Tags i:list){
            tagsList.add(i.getTagname());
        }
//        System.out.println("得到的"+tagsList);
        List<EchartsData> data = new ArrayList<>();
        for (String tag:tagsList){
            QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("arttags",tag);
            Long count =articleMapper.selectCount(queryWrapper);
            EchartsData a = new EchartsData();
            a.setName(tag);
            a.setValue(count.intValue());
            data.add(a);
        }
//        System.out.println("让我康康"+data);
        return new Result<List<EchartsData>>(2000,"这是数据",data);
    }
}
