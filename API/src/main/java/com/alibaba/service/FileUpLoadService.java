package com.alibaba.service;

import com.alibaba.domain.FileUpLoad;

import java.util.List;

/**
 * @author zwd
 * @date 2018/3/9 17:22
 */
public interface FileUpLoadService {
    void insertExample(FileUpLoad file1);

    List<FileUpLoad> selectMyAllFile(Integer id);
}
