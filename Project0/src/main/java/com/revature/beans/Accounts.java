package com.revature.beans;

public class Accounts {
	
	private Integer acctNum;
	private double balance;
	
	public Integer getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(Integer acctNum) {
		this.acctNum = acctNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Accounts(Integer acctNum, double balance) {
		super();
		this.acctNum = acctNum;
		this.balance = balance;
	}
	
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Accounts [acctNum=" + acctNum + ", balance=" + balance + "]";
	}
	

	
	

}
