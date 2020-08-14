package com.tongji.controller;

import com.tongji.pojo.Admin;
import com.tongji.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * @author Ryan
 * @date 2020/8/13 18:57
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/findAll")
    public String findAdmin(Model model){
        List<Admin> all = adminService.findAll();
        Admin admin = all.get(0);
        model.addAttribute("admin",admin);
        return "index";
    }
}
