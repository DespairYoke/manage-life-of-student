package com.alibaba.exception;

import com.alibaba.Util.InfoCode;
import com.alibaba.Util.RespInfo;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwd
 * @date 2018/1/15 11:10
 */
@RestController
@ControllerAdvice
public class Global extends Exception{

    @ExceptionHandler(Exception.class)
    public String error(Exception e){
        RespInfo respInfo = new RespInfo();
        respInfo.setStatus(InfoCode.FAIL);
        respInfo.setMesssage("请求不合法");
        e.printStackTrace();
        return JSON.toJSONString(respInfo);
    }
}
