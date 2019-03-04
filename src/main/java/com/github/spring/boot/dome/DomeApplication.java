package com.github.spring.boot.dome;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: spring-boot-dome
 * @description:
 * @author: Jamie
 * @create: 2019-03-04 11:28
 **/

@SpringBootApplication
@MapperScan(basePackages = "com.github.spring.boot.dome.mapper")
public class DomeApplication {
    public static void main(String[] args) {
        SpringApplication.run(DomeApplication.class,args);
    }
}
