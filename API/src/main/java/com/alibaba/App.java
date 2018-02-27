package com.alibaba;

import com.alibaba.domain.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zwd
 * @date 2018/1/13 15:31
 */
@SpringBootApplication(scanBasePackages = {"com.alibaba"})
@MapperScan(basePackages = {"com.alibaba.mapper"})
@EnableScheduling
@Import(value = {com.neo.Application.class})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

}
