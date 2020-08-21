package com.tongji.config;

import com.tongji.component.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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

        //templates/teacher文件夹下html文件映射
        registry.addViewController("/teacher.html").setViewName("teacher/teacher");
        registry.addViewController("/teacherIndex").setViewName("teacher/index");
        registry.addViewController("/teacherUpdatePassword").setViewName("teacher/updatepw");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器的添加顺序就是执行顺序
        //登陆拦截器
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/login");
    }
}
