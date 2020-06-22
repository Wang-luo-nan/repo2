package com.aaa.wang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: hrms_wangpengcheng
 * @description:
 * @author: Mr.Wang
 * @create: 2020-06-19 09:20
 **/
@SpringBootApplication
@MapperScan("com.aaa.wang.mapper")
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class,args);
    }
}
