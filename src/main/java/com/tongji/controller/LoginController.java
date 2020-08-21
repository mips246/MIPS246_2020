package com.tongji.controller;

import com.tongji.pojo.Admin;
import com.tongji.pojo.Teacher;
import com.tongji.service.AdminService;
import com.tongji.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/8/14 11:28
 */
@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private TeacherService teacherService;
    @PostMapping("/login")
    public String login(@RequestParam("userid") String userid,
                        @RequestParam("role") String role,
                        @RequestParam("userpass") String userpass,
                        Map<String,Object> map,HttpSession session){
        //先在session中保存role以及userid，具体username在if分支中取出对应实体类后保存
        session.setAttribute("role",role);
        session.setAttribute("userid",userid);

        if("admin".equals(role)){
            Admin admin = adminService.findById(userid);
            if(admin!=null && admin.getPassword().equals(userpass)){
                String username = admin.getUsername();
                session.setAttribute("username",username);
                System.out.println("< "+username+" 管理员登陆 >");
                return "redirect:/admin";
            }else{
                session.removeAttribute("role");
                session.removeAttribute("userid");
                map.put("msg","用户名或密码错误，请重试！");
                return "login";
            }
        }

        else if("teacher".equals(role)){
            Teacher teacher = teacherService.findById(userid);
            if(teacher!=null && teacher.getPassword().equals(userpass)){
                String username = teacher.getTeachername();
                session.setAttribute("username",username);
                System.out.println("< "+username+" 老师登陆 >");
                return "redirect:/teacher.html";
            }else{
                session.removeAttribute("role");
                session.removeAttribute("userid");
                map.put("msg","用户名或密码错误，请重试！");
                return "login.html";
            }
        }

        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("< "+session.getAttribute("role")+": "+session.getAttribute("username")+" Logout >");
        session.invalidate();
        return "redirect:/login.html";
    }
}
