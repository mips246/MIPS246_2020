package com.tongji.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("file")
public class MyFile {
    @TableId(type = IdType.AUTO)
    private int    file_no;
    private String file_url;
    private String studentid;
    private String courseid;
    private String teacherid;
    private int    file_type;
    private int	   grade;
    private int    course_section;
    private String create_time;
    private String file_name;

    public int getFile_no() {
        return file_no;
    }

    public void setFile_no(int file_no) {
        this.file_no = file_no;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
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

    public int getFile_type() {
        return file_type;
    }

    public void setFile_type(int file_type) {
        this.file_type = file_type;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCourse_section() {
        return course_section;
    }

    public void setCourse_section(int course_section) {
        this.course_section = course_section;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "file_no=" + file_no +
                ", file_url='" + file_url + '\'' +
                ", studentid='" + studentid + '\'' +
                ", courseid='" + courseid + '\'' +
                ", teacherid='" + teacherid + '\'' +
                ", file_type=" + file_type +
                ", grade=" + grade +
                ", course_section=" + course_section +
                ", create_time='" + create_time + '\'' +
                ", file_name='" + file_name + '\'' +
                '}';
    }
}
