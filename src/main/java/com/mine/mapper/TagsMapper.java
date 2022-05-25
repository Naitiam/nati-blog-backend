package com.mine.mapper;

import com.mine.entity.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagsMapper {
    //通过主键查找tags
    String findByTagnum(Integer tagnum);
    //查找全部标签
    List<Tags> queryAlltags();
}
