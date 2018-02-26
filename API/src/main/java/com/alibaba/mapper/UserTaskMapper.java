package com.alibaba.mapper;

import com.alibaba.domain.UserTask;
import com.alibaba.domain.UserTaskExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTaskMapper {
    long countByExample(UserTaskExample example);

    int deleteByExample(UserTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTask record);

    int insertSelective(UserTask record);

    List<UserTask> selectByExample(UserTaskExample example);

    UserTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserTask record, @Param("example") UserTaskExample example);

    int updateByExample(@Param("record") UserTask record, @Param("example") UserTaskExample example);

    int updateByPrimaryKeySelective(UserTask record);

    int updateByPrimaryKey(UserTask record);
}