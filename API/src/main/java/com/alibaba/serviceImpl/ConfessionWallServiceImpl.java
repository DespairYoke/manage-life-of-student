package com.alibaba.serviceImpl;

import com.alibaba.domain.ConfessionWall;
import com.alibaba.mapper.ConfessionWallMapper;
import com.alibaba.service.ConfessionWallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zwd
 * @date 2018/2/27 16:28
 */
@Service
@Transactional
public class ConfessionWallServiceImpl implements ConfessionWallService {

    @Autowired
    private ConfessionWallMapper confessionWallMapper;


    @Override
    public void insertSelective(ConfessionWall confessionWall) {
        confessionWallMapper.insertSelective(confessionWall);
    }
}
