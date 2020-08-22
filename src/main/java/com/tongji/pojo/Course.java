package com.tongji.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("course")
public class Course {
    @TableId(type= IdType.INPUT)
    private String courseid;
    private String coursename;
    private int studentcount;
    private String createtime;

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getStudentcount() {
        return studentcount;
    }

    public void setStudentcount(int studentcount) {
        this.studentcount = studentcount;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid='" + courseid + '\'' +
                ", coursename='" + coursename + '\'' +
                ", studentcount=" + studentcount +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
