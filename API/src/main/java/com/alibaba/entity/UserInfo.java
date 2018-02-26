package com.alibaba.entity;

import com.alibaba.domain.User;

/**
 * @author zwd
 * @date 2018/1/17 11:32
 */
public class UserInfo
{
    private User user;

    private double count;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

}
