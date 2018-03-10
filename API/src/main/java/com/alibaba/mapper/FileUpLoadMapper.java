package com.alibaba.mapper;

import com.alibaba.domain.FileUpLoad;
import com.alibaba.domain.FileUpLoadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUpLoadMapper {
    long countByExample(FileUpLoadExample example);

    int deleteByExample(FileUpLoadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FileUpLoad record);

    int insertSelective(FileUpLoad record);

    List<FileUpLoad> selectByExample(FileUpLoadExample example);

    FileUpLoad selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FileUpLoad record, @Param("example") FileUpLoadExample example);

    int updateByExample(@Param("record") FileUpLoad record, @Param("example") FileUpLoadExample example);

    int updateByPrimaryKeySelective(FileUpLoad record);

    int updateByPrimaryKey(FileUpLoad record);
}