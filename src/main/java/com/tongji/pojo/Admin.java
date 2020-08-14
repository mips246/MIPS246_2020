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
	 * ��ȡ
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ����
	 * @param userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ��ȡ
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * ����
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ��ȡ
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * ����
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "Admin{userid = " + userid + ", username = " + username + ", password = " + password + "}";
	}
}
