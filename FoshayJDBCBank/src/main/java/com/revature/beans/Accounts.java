package com.revature.beans;

public class Accounts {
	
	private int userid;
	private int acctNum;
	private double balance;
	private String acctType;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public Accounts(int userid, int acctNum, double balance, String acctType) {
		super();
		this.userid = userid;
		this.acctNum = acctNum;
		this.balance = balance;
		this.acctType = acctType;
	}
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Accounts [userid=" + userid + ", acctNum=" + acctNum + ", balance=" + balance + ", acctType=" + acctType
				+ "]";
	}
	
	
	
	
	
	
}
