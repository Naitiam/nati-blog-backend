package com.mine;

import com.mine.entity.Article;
import com.mine.entity.MineInfo;
import com.mine.mapper.MineMapper;
import com.mine.service.ArticleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@SpringBootApplication
public class BlogsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogsysApplication.class, args);
    }

}
