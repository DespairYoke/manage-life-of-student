package com.alibaba.controller;

import com.alibaba.Util.InfoCode;
import com.alibaba.Util.ParseWeek;
import com.alibaba.Util.RespInfo;
import com.alibaba.domain.Task;
import com.alibaba.domain.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.service.LoginService;
import com.alibaba.service.TodayTaskService;
import com.alibaba.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zwd
 * @date 2018/1/13 16:52
 */
@RestController
@RequestMapping("/index")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserTaskService userTaskService;
    @Autowired
    private RespInfo respInfo;
    @RequestMapping(value = "/login")
    public String login(@RequestBody User user) {
        try {
            MessageDigest sha = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder =new BASE64Encoder();
            String password = base64Encoder.encode(sha.digest(user.getPassword().getBytes()));
            user.setPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User user1 = loginService.login(user);
        if (user1 != null) {
            respInfo.setContent(user1);
            respInfo.setStatus(InfoCode.SUCCESS);
            respInfo.setMesssage("登录成功！");
            return JSON.toJSONString(respInfo);
        }

        respInfo.setMesssage("用户名或密码错误！");
        respInfo.setStatus(InfoCode.FAIL);
        return JSON.toJSONString(respInfo);
    }

    @RequestMapping(value = "/updateUser")
    public String updateUser(@RequestBody User user) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder =new BASE64Encoder();
        String password = base64Encoder.encode(sha.digest(user.getPassword().getBytes()));
        user.setPassword(password);
        if (loginService.updateUser(user)!=0)
        {
            respInfo.setStatus(InfoCode.SUCCESS);
            respInfo.setMesssage("更新成功！");
            return JSON.toJSONString(respInfo);
        }
        respInfo.setMesssage("此联系人不存在");
        respInfo.setStatus(InfoCode.FAIL);
        return JSON.toJSONString(respInfo);
    }
    @RequestMapping(value = "/findUserInfo")
    public String lookUserInfo(@RequestBody User user) {
        User user1=loginService.selectById(user);
        respInfo.setContent(user1);
        respInfo.setStatus(InfoCode.SUCCESS);
        respInfo.setMesssage("查询成功");
        return JSON.toJSONString(respInfo);
    }

    @RequestMapping(value = "/findAllUser")
    public String findAllUser() {
        String day= ParseWeek.ParseDayofWeek();
        List<Map> list=userTaskService.selectByDay(day);
        RespInfo respInfo = new RespInfo();
        respInfo.setContent(list);
        respInfo.setStatus(InfoCode.SUCCESS);
        respInfo.setMesssage("查询成功");
        return JSON.toJSONString(respInfo);//JSON.toJSONString(respInfo);
    }
    }
