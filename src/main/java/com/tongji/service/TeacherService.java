package com.tongji.service;

import com.tongji.dao.TeacherDao;
import com.tongji.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;

    public List<Teacher> findAll(){
        return teacherDao.selectList(null);
    }

    public Teacher findById(String id){
        return teacherDao.selectById(id);
    }
}
