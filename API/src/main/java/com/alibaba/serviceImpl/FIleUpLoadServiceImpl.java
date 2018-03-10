package com.alibaba.serviceImpl;

import com.alibaba.domain.FileUpLoad;
import com.alibaba.domain.FileUpLoadExample;
import com.alibaba.mapper.FileUpLoadMapper;
import com.alibaba.service.FileUpLoadService;
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
