package com.suyu.api.mapper;

import com.suyu.api.domain.User;
import com.suyu.api.domain.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectByNumAndPwd(User user);

    int insert(User user);

    int updateUser(User user);

    List<User> selectEmail();

    List<User> selectUserBynumber(String number);

    User selectById(User user);

    List<User> selectAllUser();
}