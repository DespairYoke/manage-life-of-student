package com.suyu.api.serviceImpl;


import com.suyu.api.domain.Task;
import com.suyu.api.mapper.TaskMapper;
import com.suyu.api.service.TodayTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zwd
 * @date 2018/1/15 10:59
 */
@Service
@Transactional
public class TodayTaskServiceImpl implements TodayTaskService {

    @Autowired
    private TaskMapper taskMapper;
    @Override
    public int addTodayTask(Task task) {
        return taskMapper.insertSelective(task);
    }

    @Override
    public List<Task> queryTodayTask(int userid) {
        return taskMapper.queryTodayTask(userid);
    }

    @Override
    public int deleteTodayTask(int id) {
        return taskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int finishTask(int id) {
        return taskMapper.finishTask(id);
    }

    @Override
    public List<Task> queryTaskbyNumber(String number) {
        return taskMapper.queryTaskbyNumber(number);
    }
}
