package com.suyu.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author zwd
 * @Date 2018/3/13 下午2:30
 */
@SpringBootApplication
@Import({com.suyu.mail.Application.class})
@MapperScan(basePackages = {"com.suyu.api.mapper"})
@EnableScheduling
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
