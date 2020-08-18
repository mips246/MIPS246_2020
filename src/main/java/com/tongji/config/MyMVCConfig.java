package com.tongji.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Ryan
 * @date 2020/8/13 20:09
 */
@Configuration
public class MyMVCConfig implements WebMvcConfigurer{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/admin").setViewName("admin/admin");
        registry.addViewController("/teacher.html").setViewName("teacher/teacher");
        registry.addViewController("/teacherIndex").setViewName("teacher/index");
        registry.addViewController("/teacherUpdatePassword").setViewName("teacher/updatepw");
    }
}
