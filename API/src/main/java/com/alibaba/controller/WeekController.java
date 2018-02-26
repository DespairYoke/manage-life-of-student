package com.alibaba.controller;

import com.alibaba.Util.InfoCode;
import com.alibaba.Util.RespInfo;
import com.alibaba.domain.UserTask;
import com.alibaba.fastjson.JSON;
import com.alibaba.service.WeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwd
 * @date 2018/1/16 15:52
 */
@RestController
@RequestMapping("/week")
public class WeekController {

    @Autowired
    private WeekService weekService;

    @Autowired
    private RespInfo respInfo;

    @RequestMapping(value = "queryWeekCompletion")
    public String queryWeekCompletion(@RequestBody UserTask userTask){
       userTask=weekService.queryWeekCompletion(userTask.getUser_id());
       if (userTask!=null)
       {
           respInfo.setContent(userTask);
           respInfo.setMesssage("查询成功！");
           respInfo.setStatus(InfoCode.SUCCESS);
           return JSON.toJSONString(respInfo);
       }
       respInfo.setMesssage("此id不存在");
       respInfo.setStatus(InfoCode.FAIL);
        return JSON.toJSONString(respInfo);
    }
}
