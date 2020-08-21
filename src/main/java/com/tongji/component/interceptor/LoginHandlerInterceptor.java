package com.tongji.component.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = (String)request.getSession().getAttribute("username");
        //未登录拦截
        if(username==null){
            request.setAttribute("msg","没有权限请先登录！");
            System.out.println("< 未登录用户已被拦截 >");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
        //登陆放行
        else return true;
    }
}
