package com.revature.beans;

public class PendingAccts {
	
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
	
	public PendingAccts(Integer acctNum, double balance) {
		super();
		this.acctNum = acctNum;
		this.balance = balance;
	}
	
	public PendingAccts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "PendingAccts [acctNum=" + acctNum + ", balance=" + balance + "]";
	}
	

	
	
}
