package com.suyu.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author Suyu
 * @Date 2018/3/13 下午2:23
 */
@Configuration
@ComponentScan({"com.suyu"})
//@Import({com.suyu.mail.impl.MailServiceImpl.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
