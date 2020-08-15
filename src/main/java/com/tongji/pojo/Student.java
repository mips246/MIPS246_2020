package com.tongji.pojo;

/**
 * @author Ryan
 * @date 2020/8/15 15:46
 */
public class Student {
    private String userid;
    private String name;
    private String password;

    public Student() {
    }

    public Student(String userid, String name, String password) {
        this.userid = userid;
        this.name = name;
        this.password = password;
    }

    /**
     * 获取
     * @return userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Student{userid = " + userid + ", name = " + name + ", password = " + password + "}";
    }
}
