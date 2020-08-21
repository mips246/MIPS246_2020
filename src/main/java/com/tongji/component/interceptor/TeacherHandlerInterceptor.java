package com.tongji.component.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TeacherHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String role = (String)request.getSession().getAttribute("role");
        //教师登陆，只允许访问教师相关功能
        if("teacher".equals(role)){
            System.out.println("< 教师非法访问已被拦截 >");
            request.getRequestDispatcher("/teacher/teacher.html").forward(request,response);
            return false;
        }
        //正常访问放行
        else return true;
    }
}
