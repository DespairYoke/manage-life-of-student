package com.alibaba.controller;

import cc.huluwa.util.MessageSend;
import com.alibaba.Util.InfoCode;
import com.alibaba.Util.MathRand;
import com.alibaba.Util.RespInfo;
import com.alibaba.domain.User;
import com.alibaba.entity.UserInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zwd
 * @date 2018/3/6 16:05
 */
@RestController
@RequestMapping(value = "/user")
public class userController {
    @Autowired
       private StringRedisTemplate template;
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "generCode")
    public String generPhoneCode(@RequestBody User user) {
        RespInfo respInfo = new RespInfo();
        String code = MathRand.getCode();
        if (MessageSend.sendMsg(user.getPhone(), code)){

            respInfo.setMesssage("验证成功!");
            template.opsForValue().set("regist"+user.getPhone(),code,1000, TimeUnit.SECONDS);
            respInfo.setStatus(InfoCode.SUCCESS);
            respInfo.setContent(code);
        }else {
            respInfo.setStatus(InfoCode.FAIL);
            respInfo.setMesssage("验证失败！");
        }
        return JSON.toJSONString(respInfo);

    }
    @RequestMapping(value = "updatephone")
    public String updatePhone(@RequestBody UserInfo userInfo) {
        RespInfo respInfo = new RespInfo();
        System.out.println();
        if (userInfo.getCode().equals("")||userInfo.getCode()==null) {
            respInfo.setMesssage("验证码不能为空");
        }
        else if (!template.opsForValue().get("regist"+userInfo.getPhone()).equals(userInfo.getCode())) {
            respInfo.setStatus(InfoCode.FAIL);
            respInfo.setMesssage("验证码错误");
        } else {
            User user = new User();
            user.setNumber(userInfo.getNumber());
            user.setPhone(userInfo.getPhone());
            loginService.updateUser(user);
            respInfo.setMesssage("更新成功");
            respInfo.setStatus(InfoCode.SUCCESS);

        }
        return JSON.toJSONString(respInfo);
    }

}
