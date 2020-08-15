package com.tongji.controller;

import com.tongji.pojo.Teacher;
import com.tongji.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers")
    public String findAll(Model model){
        System.out.println("< Find All Teachers>");
        List<Teacher> teachers = teacherService.findAll();
        for(Teacher teacher : teachers) System.out.println(teacher);
        model.addAttribute("teachers",teachers);
        return "teacher/test";
    }
}
