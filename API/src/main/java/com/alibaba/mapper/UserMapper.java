package com.alibaba.mapper;

import com.alibaba.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    User selectByNumAndPwd(User user);

    int insert(User user);

    int updateUser(User user);

    List<User> selectEmail();

    List<User> selectUserBynumber(String number);

    User selectById(User user);

    List<User> selectAllUser();
}