package com.alibaba.service;

import com.alibaba.domain.Task;
import com.alibaba.domain.User;

import java.util.List;

/**
 * @author zwd
 * @date 2018/1/15 10:57
 */
public interface TodayTaskService {

    int addTodayTask(Task task);

    List<Task> queryTodayTask(int userid);

    int deleteTodayTask(int id);

    int finishTask(int id);

    List<Task> queryTaskbyNumber(String number);
}
