package com.tongji.controller;

import com.tongji.pojo.Admin;
import com.tongji.service.AdminService;
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
@RequestMapping("/MIPS246")
public class LoginController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/login")
    public String login(@RequestParam("userid") String userid,
                        @RequestParam("role") String role,
                        @RequestParam("userpass") String userpass){
        if("admin".equals(role)){
            Admin admin = adminService.findById(userid);
            if(admin.getPassword().equals(userpass)){
                return "success";
            }else{
                return "login";
            }
        }
        return "login";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
//    @GetMapping("/success")
//    public String success(){
//        return "success";
//    }
}
