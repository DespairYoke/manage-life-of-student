package com.alibaba.service;

import com.alibaba.domain.ConfessionWall;

import java.util.List;

/**
 * @author zwd
 * @date 2018/2/27 16:28
 */

public interface ConfessionWallService {
    void insertSelective(ConfessionWall confessionWall);

    List<ConfessionWall> findAllWall();
}
