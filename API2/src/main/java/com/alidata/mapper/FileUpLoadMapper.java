package com.alidata.mapper;


import java.util.List;
import com.alidata.domain.FileUpLoad;
import com.alidata.domain.FileUpLoadExample;
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