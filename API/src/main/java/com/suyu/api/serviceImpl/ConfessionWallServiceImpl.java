package com.suyu.api.serviceImpl;


import com.suyu.api.domain.ConfessionWall;
import com.suyu.api.domain.ConfessionWallExample;
import com.suyu.api.mapper.ConfessionWallMapper;
import com.suyu.api.service.ConfessionWallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<ConfessionWall> findAllWall() {
        ConfessionWallExample confessionWallExample = new ConfessionWallExample();
        return confessionWallMapper.selectByExample(confessionWallExample);
    }
}
