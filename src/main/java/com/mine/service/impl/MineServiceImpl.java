package com.mine.service.impl;


import com.mine.entity.MineInfo;
import com.mine.mapper.MineMapper;
import com.mine.service.MineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MineServiceImpl implements MineService {
    @Resource
    private MineMapper mineMapper;

    @Override
    public MineInfo findMineInfo(String admname) {
        return mineMapper.findMineInfo(admname);
    }

    @Override
    public int updateMineInfo(MineInfo mineInfo) {
        return mineMapper.updateMineInfo(mineInfo);
    }
}
