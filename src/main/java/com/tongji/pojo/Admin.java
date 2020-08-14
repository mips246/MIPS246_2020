package com.tongji.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("admin")
public class Admin {
	@TableId(type= IdType.INPUT)
	private String userid;
	private String username;
	private String password;


	public Admin() {
	}

	public Admin(String userid, String username, String password) {
		this.userid = userid;
		this.username = username;
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
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
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
		return "Admin{userid = " + userid + ", username = " + username + ", password = " + password + "}";
	}
}
