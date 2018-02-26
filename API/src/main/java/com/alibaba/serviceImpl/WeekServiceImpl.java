package com.alibaba.serviceImpl;

import com.alibaba.Util.EqualWeek;
import com.alibaba.domain.Task;
import com.alibaba.domain.UserTask;
import com.alibaba.domain.UserTaskExample;
import com.alibaba.mapper.UserTaskMapper;
import com.alibaba.service.WeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zwd
 * @date 2018/1/16 14:20
 */
@Service
public class WeekServiceImpl implements WeekService{

    @Autowired
    private UserTaskMapper userTaskMapper;
    @Override
    public int updateWeek(Task task,double count) {
        UserTaskExample example = new UserTaskExample();
        example.createCriteria().andUser_idEqualTo(task.getUserid());
        UserTask userTask = new UserTask();
        userTask.setUser_id(task.getUserid());
        EqualWeek.equalWeek(userTask,count);
        return userTaskMapper.updateByExampleSelective(userTask,example);
    }

    public UserTask queryWeekCompletion(int userid){

        UserTaskExample example = new UserTaskExample();
        example.createCriteria().andUser_idEqualTo(userid);
        List<UserTask> list=userTaskMapper.selectByExample(example);
        return list.get(0);
    }

}
