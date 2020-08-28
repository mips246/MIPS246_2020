package com.tongji.controller;

import com.tongji.pojo.CourseTeacher;
import com.tongji.pojo.Teacher;
import com.tongji.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @PostMapping("/updatePassword")
    public Map<String,Object> updatePassword(@RequestParam("userID") String userID,
                                 @RequestParam("oldPassword") String oldPassword,
                                 @RequestParam("newPassword") String newPassword){

        System.out.println("< Teacher Modify Password >");
        String[] msg = {"修改成功","修改失败，原密码错误","修改失败，服务器内部错误"};
        int statusCode = teacherService.updatePassword(userID, oldPassword, newPassword);
        Map<String,Object> map = new HashMap<>();
        map.put("statusCode",statusCode);
        map.put("msg",msg[statusCode]);
        return map;
    }

    @GetMapping("/courses/{id}")
    public String getCourses(@PathVariable("id") String teacherId,Model model){
        List<CourseTeacher> courses = teacherService.getCourses(teacherId);
        model.addAttribute("courses",courses);
        return "teacher/teacher_course";
    }

    @GetMapping("/upload/{id}")
    public String getCourses2(@PathVariable("id") String teacherId,Model model){
        List<CourseTeacher> courses = teacherService.getCourses(teacherId);
        model.addAttribute("courses",courses);
        return "teacher/teacher_upload";
    }
}
