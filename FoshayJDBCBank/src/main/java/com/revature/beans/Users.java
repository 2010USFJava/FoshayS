package com.revature.beans;

public class Users {
	
	private String userName;
	private String password;
	private Integer acctNum;
	
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
	public Integer getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(Integer acctNum) {
		this.acctNum = acctNum;
	}
	
	public Users(String userName, String password, Integer acctNum) {
		super();
		this.userName = userName;
		this.password = password;
		this.acctNum = acctNum;
	}
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Users [userName=" + userName + ", password=" + password + ", acctNum=" + acctNum + "]";
	}
	
	

}
