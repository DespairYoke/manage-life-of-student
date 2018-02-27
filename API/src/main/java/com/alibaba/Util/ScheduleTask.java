package com.alibaba.Util;

import com.alibaba.Config.Config;
import com.alibaba.domain.TaskExample;
import com.alibaba.domain.User;
import com.alibaba.domain.UserTaskExample;
import com.alibaba.mapper.TaskMapper;
import com.alibaba.mapper.UserMapper;
import com.alibaba.mapper.UserTaskMapper;
import com.neo.impl.MailServiceImpl;
import com.neo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zwd
 * @date 2018/1/16 17:24
 */
@Component
public class ScheduleTask {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private UserTaskMapper userTaskMapper;

    @Scheduled(cron ="0 0 00 ? * SUN")
    public void process(){

        TaskExample taskExample = new TaskExample();
        UserTaskExample example = new UserTaskExample();
        taskMapper.deleteByExample(taskExample);
        userTaskMapper.deleteByExample(example);
    }

    @Scheduled(cron ="0 0 18 ? * *")
    public void remind(){
        List<User> list = userMapper.selectEmail();
        MailService mailService = new MailServiceImpl();
        for (User user:list)
        {
            if(user.getType()==1) {
                mailService.sendSimpleMail(user.getEmail(), Config.subject, Config.content);
            }
        }
    }
}
