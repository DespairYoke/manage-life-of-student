package com.suyu.api.serviceImpl;


import com.suyu.api.domain.User;
import com.suyu.api.mapper.UserMapper;
import com.suyu.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zwd
 * @date 2018/1/13 16:57
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.selectByNumAndPwd(user);
    }

    @Override
    public int updateUser(User user) {
        userMapper.updateUser(user);
        return 0;
    }

    @Override
    public List<User> selectUserBynumber(String number) {
        return userMapper.selectUserBynumber(number);
    }

    @Override
    public User selectById(User user) {

        return userMapper.selectById(user);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.selectAllUser();
    }
}
