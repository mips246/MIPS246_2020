package com.tongji.service;

import com.tongji.dao.CourseTeacherDao;
import com.tongji.dao.TeacherDao;
import com.tongji.pojo.CourseTeacher;
import com.tongji.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;

    @Autowired
    CourseTeacherDao courseTeacherDao;

    public List<Teacher> findAll(){
        return teacherDao.selectList(null);
    }

    public Teacher findById(String id){
        return teacherDao.selectById(id);
    }

    public int updatePassword(String userID,String oldPassword,String newPassword){
        Teacher teacher = teacherDao.selectById(userID);
        String password = teacher.getPassword();
        if(!password.equals(oldPassword)) return 1;//原密码错误
        else {
            teacher.setPassword(newPassword);
            teacherDao.updateById(teacher);
            return 0;//修改成功
        }
    }

    //获取教师所有课程
    public List<CourseTeacher> getCourses(String teacherId){
        return courseTeacherDao.findByTeacherId(teacherId);
    }
}
