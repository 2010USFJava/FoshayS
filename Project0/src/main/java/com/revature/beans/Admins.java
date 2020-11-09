package com.revature.beans;

import java.io.Serializable;

public class Admins implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4667721750908666358L;
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Admins(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public Admins() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Admins [userName=" + userName + ", password=" + password + "]";
	}
	
	
}
