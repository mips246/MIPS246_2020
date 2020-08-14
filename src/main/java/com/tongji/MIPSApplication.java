package com.tongji;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Ryan
 * @date 2020/8/13 18:49
 */
@SpringBootApplication
@MapperScan("com.tongji.dao")
public class MIPSApplication {
    public static void main(String[] args) {
        SpringApplication.run(MIPSApplication.class,args);
    }
}
