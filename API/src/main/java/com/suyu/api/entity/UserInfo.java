package com.suyu.api.entity;


import com.suyu.api.domain.User;

/**
 * @author zwd
 * @date 2018/1/17 11:32
 */
public class UserInfo
{
    private String number;

    private User user;

    private double count;

    private String code;

    private String phone;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
