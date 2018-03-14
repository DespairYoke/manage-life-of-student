package com.suyu.api.mapper;

import com.suyu.api.domain.ConfessionWall;
import com.suyu.api.domain.ConfessionWallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfessionWallMapper {
    long countByExample(ConfessionWallExample example);

    int deleteByExample(ConfessionWallExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConfessionWall record);

    int insertSelective(ConfessionWall record);

    List<ConfessionWall> selectByExample(ConfessionWallExample example);

    ConfessionWall selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConfessionWall record, @Param("example") ConfessionWallExample example);

    int updateByExample(@Param("record") ConfessionWall record, @Param("example") ConfessionWallExample example);

    int updateByPrimaryKeySelective(ConfessionWall record);

    int updateByPrimaryKey(ConfessionWall record);
}