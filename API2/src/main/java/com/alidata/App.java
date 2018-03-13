package com.alidata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zwd
 * @date 2018/1/13 15:31
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.alibaba.mapper"})
@EnableScheduling
@Import(com.alidata.Application.class)
public class App{

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

}
