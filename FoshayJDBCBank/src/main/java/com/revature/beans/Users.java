package com.revature.beans;

public class Users {
	
	private int userid;
	private String userName;
	private String password;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
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
	
	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	public Users(int userid, String userName, String password) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.password = password;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	

}
