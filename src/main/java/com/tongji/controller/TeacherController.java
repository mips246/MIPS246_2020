package com.tongji.controller;

import com.tongji.pojo.*;
import com.tongji.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @ResponseBody
    @PostMapping("/courses")
    public Map<String,Object> getCourses(@RequestParam("teacherId") String teacherId){
        Map<String,Object> map = new HashMap<>();
        List<CourseTeacher> courses = teacherService.getCourses(teacherId);
        map.put("courses",courses);
        return map;
    }

    @ResponseBody
    @PostMapping("/files")
    public Map<String,Object> getFiles(@RequestParam("teacherId") String teacherId,
                                       @RequestParam("courseId") String courseId){

        Map<String,Object> map = new HashMap<>();
        List<MyFile> files = teacherService.getFiles(teacherId, courseId);
        map.put("files",files);
        return map;
    }

    @ResponseBody
    @PostMapping("/deleteFile")
    public Map<String,Object> deleteFile(@RequestParam("fileNo") int fileNo){
        Map<String,Object> map = new HashMap<>();
        try {
            teacherService.deleteFile(fileNo);
            map.put("msg","成功删除文件!");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            map.put("msg","删除文件失败!");
        }
        return map;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file_type") int fileType,
                             @RequestParam("courseid") String courseId,
                             @RequestParam("course_section") int courseSection,
                             @RequestParam("teacherid") String teacherId,
                             @RequestParam("uploadFile") MultipartFile file,
                             Model model){

        MyFile myFile = new MyFile();
        String filename = file.getOriginalFilename();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //第一个分隔符是否需要考虑去掉？
        myFile.setFile_url(File.separator + "WebRoot" + File.separator +
                courseId + File.separator + teacherId + File.separator + filename);
        myFile.setCourseid(courseId);
        myFile.setTeacherid(teacherId);
        myFile.setFile_type(fileType);
        myFile.setCourse_section(courseSection);
        myFile.setFile_name(filename);
        myFile.setCreate_time(dateFormat.format(new Date()));

        try {
            teacherService.uploadFile(file,myFile);
            model.addAttribute("msg","上传成功!");
        } catch (IOException e) {
            model.addAttribute("msg","上传失败，请重新尝试!");
        }
        return "teacher/teacher_upload";
    }

    @ResponseBody
    @PostMapping("/students")
    public Map<String,Object> findAllStudents(@RequestParam("teacherId") String teacherId,
                                              @RequestParam("courseId") String courseId){
        Map<String,Object> map = new HashMap<>();
        List<CourseSelect> records = teacherService.findAllStuRecords(teacherId, courseId);
        map.put("records",records);
        List<Student> students = new ArrayList<>();
        //从record取得grade以及studentid
        for (CourseSelect record : records){
            String stuId = record.getStudentid();
            //从student中获得name
            Student student = teacherService.findStudentById(stuId);
            students.add(student);
        }
        map.put("students",students);
        return map;
    }

    @ResponseBody
    @PostMapping("/student")
    public Map<String,Object> findAllStudentById(@RequestParam("teacherId") String teacherId,
                                                 @RequestParam("courseId") String courseId,
                                                 @RequestParam("studentId") String studentId){


        List<CourseSelect> records = teacherService.findStuRecordById(teacherId,courseId,studentId);
        Student student = teacherService.findStudentById(studentId);
        List<Student> students = new ArrayList<>();
        students.add(student);
        Map<String,Object> map = new HashMap<>();
        map.put("records",records);
        map.put("students",students);
        return map;
    }

    @ResponseBody
    @PostMapping("/courseGrade")
    public Map<String,Object> courseGrade(@RequestParam("id") int id,
                                          @RequestParam("grade") int grade){

        Map<String,Object> map = new HashMap<>();
        CourseSelect record = new CourseSelect();
        record.setId(id);
        record.setGrade(grade);
        teacherService.updateCourseGrade(record);
        map.put("msg","成绩提交成功");
        return map;
    }
}
