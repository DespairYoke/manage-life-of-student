package com.suyu.api.controller;



import com.alibaba.fastjson.JSON;
import com.suyu.api.domain.ConfessionWall;
import com.suyu.api.service.ConfessionWallService;
import com.suyu.api.util.InfoCode;
import com.suyu.api.util.RespInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author zwd
 * @date 2018/2/27 16:22
 */
@RestController
@RequestMapping("/wall")
public class ConfessionWallController {
    @Autowired
    private ConfessionWallService confessionWallService;
    @RequestMapping(value = "/add")
    public String addWallContent(@RequestBody ConfessionWall confessionWall) {
        confessionWall.setDate(new Date());
        System.out.println("sdddd");
        confessionWallService.insertSelective(confessionWall);
        RespInfo respInfo = new RespInfo();
        respInfo.setStatus(InfoCode.SUCCESS);
        respInfo.setMesssage("添加成功");
        respInfo.setContent(confessionWall);
        return JSON.toJSONString(respInfo);
    }
    @RequestMapping(value = "/findAllWall")
    public String findAllContent() {
        List<ConfessionWall> list = confessionWallService.findAllWall();
        return JSON.toJSONString(list);
    }
}
