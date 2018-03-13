package com.alidata.Util;

import org.springframework.stereotype.Component;

/**
 * @author zwd
 * @date 2018/1/15 10:33
 */

@Component
public class RespInfo {

    private String Messsage;

    private Object Content;

    private int status;

    public String getMesssage() {
        return Messsage;
    }

    public void setMesssage(String messsage) {
        Messsage = messsage;
    }

    public Object getContent() {
        return Content;
    }

    public void setContent(Object content) {
        Content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
