package com.alibaba.service;

import com.alibaba.domain.Task;
import com.alibaba.domain.UserTask;

/**
 * @author zwd
 * @date 2018/1/16 14:18
 */
public interface WeekService  {

    int updateWeek(Task task,double count);
    UserTask queryWeekCompletion(int userid);
}
