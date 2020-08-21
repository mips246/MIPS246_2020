package com.tongji.config;

import com.tongji.component.interceptor.AdminHandlerInterceptor;
import com.tongji.component.interceptor.LoginHandlerInterceptor;
import com.tongji.component.interceptor.TeacherHandlerInterceptor;
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
        registry.addViewController("/admin/admin.html").setViewName("admin/admin");

        //templates/teacher文件夹下html文件映射
        registry.addViewController("/teacher/teacher.html").setViewName("teacher/teacher");
        registry.addViewController("/teacher/index.html").setViewName("teacher/index");
        registry.addViewController("/teacher/updatePassword.html").setViewName("teacher/updatepw");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器的添加顺序就是执行顺序
        //登陆拦截器
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/login");

        //教师访问拦截器，阻止教师访问管理员与学生相关页面
        registry.addInterceptor(new TeacherHandlerInterceptor()).addPathPatterns("/admin/**","/student/**");

        //管理员访问拦截器，阻止管理员访问教师与学生相关页面
        registry.addInterceptor(new AdminHandlerInterceptor()).addPathPatterns("/teacher/**","/student/**");
    }
}
