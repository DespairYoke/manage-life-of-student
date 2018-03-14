package com.suyu.api.serviceImpl;


import com.suyu.api.domain.FileUpLoad;
import com.suyu.api.domain.FileUpLoadExample;
import com.suyu.api.mapper.FileUpLoadMapper;
import com.suyu.api.service.FileUpLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zwd
 * @date 2018/3/9 17:22
 */
@Service
@Transactional
public class FIleUpLoadServiceImpl implements FileUpLoadService {

    @Autowired
    private FileUpLoadMapper fileUpLoadMapper;
    @Override
    public void insertExample(FileUpLoad file1) {
        fileUpLoadMapper.insertSelective(file1);
    }

    @Override
    public List<FileUpLoad> selectMyAllFile(Integer id) {
        FileUpLoadExample fileUpLoadExample = new FileUpLoadExample();
        fileUpLoadExample.createCriteria().andUseridEqualTo(id);
        return fileUpLoadMapper.selectByExample(fileUpLoadExample);
    }
}
