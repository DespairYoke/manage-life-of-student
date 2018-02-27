package com.alibaba.controller;

import com.alibaba.Util.InfoCode;
import com.alibaba.Util.RespInfo;
import com.alibaba.domain.Task;
import com.alibaba.domain.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.service.TodayTaskService;
import com.alibaba.service.WeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zwd
 * @date 2018/1/15 10:49
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TodayTaskService todayTaskService;
    @Autowired
    private RespInfo respInfo;
    @Autowired
    private WeekService weekService;
    @RequestMapping(value = "/addTodayTask")
    public String addTodayTask(@RequestBody() Task task){
        System.out.println(task);
        if (todayTaskService.addTodayTask(task)!=0)
        {
            respInfo.setStatus(InfoCode.SUCCESS);
            respInfo.setMesssage("添加成功！");
            return JSON.toJSONString(respInfo);
        };
        respInfo.setStatus(InfoCode.FAIL);
        respInfo.setMesssage("添加失败！");
        return JSON.toJSONString(respInfo);
    }

    @RequestMapping(value = "/queryTodayTask")
    public String queryTodayTask(@RequestBody User user){
        List<Task> taskList=todayTaskService.queryTodayTask(user.getId());
        if (!taskList.isEmpty())
        {
            respInfo.setContent(taskList);
            respInfo.setStatus(InfoCode.SUCCESS);
            respInfo.setMesssage("查询成功！");
            return JSON.toJSONString(respInfo);
        }
        respInfo.setMesssage("id不存在！");
        respInfo.setStatus(InfoCode.FAIL);
        return JSON.toJSONString(respInfo);
    }

    @RequestMapping(value = "/deleteTodayTask")
    public String deleteTodayTask(@RequestBody Task task){
        if (todayTaskService.deleteTodayTask(task.getId())!=0)
        {
            respInfo.setMesssage("删除成功！");
            respInfo.setStatus(InfoCode.SUCCESS);
            return JSON.toJSONString(respInfo);
        }

        respInfo.setMesssage("id不存在！");
        respInfo.setStatus(InfoCode.FAIL);
        return JSON.toJSONString(respInfo);
    }

    @RequestMapping(value = "/finishTodayTask")
    public String finishTask(@RequestBody Task task){
        if (todayTaskService.finishTask(task.getId())!=0)
        {
            List<Task> taskList=todayTaskService.queryTodayTask(task.getUserid());
            if (!taskList.isEmpty())
            {
                double count = taskList.size();
                int sum =0;
                for (Task object:taskList)
                {
                    sum+= (int)object.getType();
                }
                    weekService.updateWeek(task,sum/count);
            }
            respInfo.setMesssage("完成成功！");
            respInfo.setStatus(InfoCode.SUCCESS);
            return JSON.toJSONString(respInfo);
        }
        respInfo.setMesssage("id不存在！");
        respInfo.setStatus(InfoCode.FAIL);
        return JSON.toJSONString(respInfo);
    }

    @RequestMapping(value = "/queryCompletion")
    public String queryCompletion(@RequestBody User user){
        List<Task> taskList=todayTaskService.queryTodayTask(user.getId());
        if (!taskList.isEmpty())
        {
             double count = taskList.size();
             int sum =0;
            for (Task object:taskList)
            {
                sum+= (int)object.getType();
            }
            System.out.println(sum+" "+count+" "+sum/count);
            return JSON.toJSONString(sum/count);
        }
        respInfo.setMesssage("id不存在！");
        respInfo.setStatus(InfoCode.FAIL);
        return JSON.toJSONString(respInfo);
    }
}
