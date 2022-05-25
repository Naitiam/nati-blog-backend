package com.mine.mapper;

import com.mine.entity.MineInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MineMapper{
//    List<MineMapper> allMineInfo(String);
//    @Select("select * from mine_info where admname='naitiam'")
    //根据名称查找信息
    MineInfo findMineInfo(String admname);
    //修改个人信息
    int updateMineInfo(MineInfo mineInfo);
}
