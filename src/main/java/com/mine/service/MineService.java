package com.mine.service;

import com.mine.entity.MineInfo;


public interface MineService {
    MineInfo findMineInfo(String admname);
    int updateMineInfo(MineInfo mineInfo);
}
