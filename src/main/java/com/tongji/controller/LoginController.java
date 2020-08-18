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
                        @RequestParam("userpass") String userpass){
        if("admin".equals(role)){
            Admin admin = adminService.findById(userid);
            if(admin.getPassword().equals(userpass)){
                return "redirect:/admin";
            }else{
                return "login";
            }
        }

        else if("teacher".equals(role)){
            Teacher teacher = teacherService.findById(userid);
            if(teacher!=null && teacher.getPassword().equals(userpass)){
                return "redirect:/teacher.html";
            }else{
                return "redirect:/login.html";
            }
        }

        return "login";
    }
    /*
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    */
//    @GetMapping("/success")
//    public String success(){
//        return "success";
//    }
}
