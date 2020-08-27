package com.tongji.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("courseteachernew")
public class CourseTeacher {

    @TableId(type = IdType.AUTO)
    private int id;
    private String courseid;
    private String teacherid;
    private String coursename;
    private String teachername;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    @Override
    public String toString() {
        return "CourseTeacher{" +
                "id=" + id +
                ", courseid='" + courseid + '\'' +
                ", teacherid='" + teacherid + '\'' +
                ", coursename='" + coursename + '\'' +
                ", teachername='" + teachername + '\'' +
                '}';
    }
}
