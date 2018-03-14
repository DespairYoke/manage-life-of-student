package com.suyu.api.serviceImpl;


import com.suyu.api.domain.Task;
import com.suyu.api.domain.UserTask;
import com.suyu.api.domain.UserTaskExample;
import com.suyu.api.mapper.UserTaskMapper;
import com.suyu.api.service.WeekService;
import com.suyu.api.util.EqualWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zwd
 * @date 2018/1/16 14:20
 */
@Service
public class WeekServiceImpl implements WeekService {

    @Autowired
    private UserTaskMapper userTaskMapper;
    @Override
    public int updateWeek(Task task, double count) {
        UserTaskExample example = new UserTaskExample();
        example.createCriteria().andUserIdEqualTo(task.getUserid());
        UserTask userTask = new UserTask();
        userTask.setUserId(task.getUserid());
        EqualWeek.equalWeek(userTask,count);
        return userTaskMapper.updateByExampleSelective(userTask,example);
    }

    public UserTask queryWeekCompletion(int userid){

        UserTaskExample example = new UserTaskExample();
        example.createCriteria().andUserIdEqualTo(userid);
        List<UserTask> list=userTaskMapper.selectByExample(example);
        return list.get(0);
    }

}
