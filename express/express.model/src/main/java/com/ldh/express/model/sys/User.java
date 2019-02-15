package com.ldh.express.model.sys;

import com.ldh.express.base.core.BaseModel;

/**
 * 用户
 * @author Li Dehuan
 * @date 2019年2月15日
 *
 */
public class User extends BaseModel {

	private	String	userName;		// 用户名
	private String	gender;			// 性别
	private String	pwd;			// 密码
	private String	phone;			// 手机
	private int		valid;			// 是否可用。0：禁用，1：可用
	private String	name;			//姓名
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
