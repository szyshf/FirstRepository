package com.bright.estore.user.model;

import java.io.Serializable;

public class UserModel implements Serializable {
	private String userName;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
