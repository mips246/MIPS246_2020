package com.tongji.dao;

import com.tongji.pojo.CourseTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CourseTeacherDao {

    @Select("select * from courseteacher where teacherid = #{teacherId}")
    public List<CourseTeacher> findByTeacherId(String teacherId);
}
