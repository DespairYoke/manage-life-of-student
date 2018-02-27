package com.alibaba.service;

import com.alibaba.domain.ConfessionWall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zwd
 * @date 2018/2/27 16:28
 */

public interface ConfessionWallService {
    void insertSelective(ConfessionWall confessionWall);
}
