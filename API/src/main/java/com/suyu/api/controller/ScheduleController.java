package com.suyu.api.controller;


import com.alibaba.fastjson.JSON;
import com.suyu.api.domain.Task;
import com.suyu.api.domain.User;
import com.suyu.api.entity.UserInfo;
import com.suyu.api.service.LoginService;
import com.suyu.api.service.TodayTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zwd
 * @date 2018/1/17 11:08
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private TodayTaskService taskService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/querySchedule")
    public String queryFriendSchedule(@RequestBody User user){

        List<Task> list=taskService.queryTaskbyNumber(user.getNumber());
        List<User> userList = loginService.selectUserBynumber(user.getNumber());
        List<UserInfo> userInfoList=addUserSchedule(list,userList);
        return JSON.toJSONString(userInfoList);
    }

    public synchronized List<UserInfo> addUserSchedule(List<Task> list,List<User> userList){
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        Set<Integer> set =new HashSet<Integer>();
            for (User user:userList) {
                double sum = 0;
                int count = 0;
                for (Task task:list) {
                    if (user.getId() == task.getUserid()) {
                        sum++;
                        if (task.getType()==1)
                            count++;
                    }
                }
                UserInfo userInfo = new UserInfo();
                userInfo.setUser(user);
                userInfo.setCount(count/sum);
                userInfoList.add(userInfo);
            }

    return userInfoList;
    }

    }
