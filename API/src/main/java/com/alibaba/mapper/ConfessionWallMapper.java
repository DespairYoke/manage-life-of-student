package com.alibaba.mapper;

import com.alibaba.domain.ConfessionWall;
import com.alibaba.domain.ConfessionWallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
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