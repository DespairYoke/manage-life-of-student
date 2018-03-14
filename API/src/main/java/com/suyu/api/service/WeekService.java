package com.suyu.api.service;


import com.suyu.api.domain.Task;
import com.suyu.api.domain.UserTask;

/**
 * @author zwd
 * @date 2018/1/16 14:18
 */
public interface WeekService  {

    int updateWeek(Task task, double count);
    UserTask queryWeekCompletion(int userid);
}
