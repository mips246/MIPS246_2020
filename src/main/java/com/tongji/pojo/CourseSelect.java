package com.tongji.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("courseselectnew")
public class CourseSelect {
    @TableId(type = IdType.AUTO)
    private int id;
    private String courseid;
    private String studentid;
    private String teacherid;
    private int grade;

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

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "CourseSelect{" +
                "id=" + id +
                ", courseid='" + courseid + '\'' +
                ", studentid='" + studentid + '\'' +
                ", teacherid='" + teacherid + '\'' +
                ", grade=" + grade +
                '}';
    }
}
