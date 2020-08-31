package com.tongji.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tongji.dao.CourseTeacherDao;
import com.tongji.dao.MyFileDao;
import com.tongji.dao.TeacherDao;
import com.tongji.pojo.CourseTeacher;
import com.tongji.pojo.MyFile;
import com.tongji.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;


@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;

    @Autowired
    CourseTeacherDao courseTeacherDao;

    @Autowired
    MyFileDao myFileDao;

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
        return courseTeacherDao.selectList(new EntityWrapper<CourseTeacher>()
                                                .eq("teacherid",teacherId)
                                            );
    }

    //获得教师指定课程下所有文件
    public List<MyFile> getFiles(String teacherId,String courseId){
        return myFileDao.selectList(new EntityWrapper<MyFile>()
                                        .eq("teacherid",teacherId)
                                        .eq("courseid",courseId)
                                        .isNull("studentid")
                                    );
    }

    public void uploadFile(MultipartFile file, MyFile myFile) throws IOException {

        String path = ResourceUtils.getURL("classpath:").getPath() +
                "WebRoot" + File.separator + myFile.getCourseid() + File.separator + myFile.getTeacherid();
        path = URLDecoder.decode(path,"utf-8");//处理空格变成%20的问题
        System.out.println("< 文件存储路径 "+path+" >");

        File uploadDir = new File(path);
        if(!uploadDir.exists()) {
            uploadDir.mkdirs();
            System.out.println("< 创建文件夹 "+uploadDir.getAbsolutePath()+" >");
        }
        file.transferTo(new File(path,myFile.getFile_name()));

        myFileDao.insert(myFile);
    }

    public void deleteFile(int fileNo) throws FileNotFoundException, UnsupportedEncodingException {
        MyFile myFile = myFileDao.selectById(fileNo);
        String filepath = ResourceUtils.getURL("classpath:").getPath() +
                "WebRoot" + File.separator + myFile.getCourseid() + File.separator + myFile.getTeacherid()
                + File.separator + myFile.getFile_name();
        filepath = URLDecoder.decode(filepath,"utf-8");
        File deleteFile = new File(filepath);
        if(deleteFile.exists() && deleteFile.isFile()){
            deleteFile.delete();
        }
        myFileDao.deleteById(fileNo);
    }
}
