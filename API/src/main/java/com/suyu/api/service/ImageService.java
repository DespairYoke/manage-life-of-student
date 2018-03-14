package com.suyu.api.service;


import com.suyu.api.domain.Image;

import java.util.List;

/**
 * @author zwd
 * @date 2018/3/9 16:08
 */
public interface ImageService {
    void insertExample(Image image);

    List<Image> selectMyAllImage(Integer id);
}
