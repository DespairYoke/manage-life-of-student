package com.suyu.api.serviceImpl;


import com.suyu.api.domain.Image;
import com.suyu.api.domain.ImageExample;
import com.suyu.api.mapper.ImageMapper;
import com.suyu.api.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Image> selectMyAllImage(Integer id) {
        ImageExample imageExample = new ImageExample();
        imageExample.createCriteria().andUseridEqualTo(id);
        return imageMapper.selectByExample(imageExample);
    }
}
