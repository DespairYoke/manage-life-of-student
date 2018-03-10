package com.alibaba.serviceImpl;

import com.alibaba.domain.Image;
import com.alibaba.mapper.ImageMapper;
import com.alibaba.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zwd
 * @date 2018/3/9 16:08
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageMapper imageMapper;
    @Override
    public void insertExample(Image image) {
        imageMapper.insertSelective(image);
    }
}
