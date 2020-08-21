package com.tongji.component.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String role = (String)request.getSession().getAttribute("role");
        //管理员登陆，只允许访问管理员相关功能
        if("admin".equals(role)){
            System.out.println("< 管理员非法访问已被拦截 >");
            request.getRequestDispatcher("/admin/admin.html").forward(request,response);
            return false;
        }
        //正常访问放行
        else return true;
    }
}
