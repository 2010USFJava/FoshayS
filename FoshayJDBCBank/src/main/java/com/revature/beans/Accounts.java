package com.revature.beans;

public class Accounts {
	
	private int acctNum;
	private double balance;
	
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
	
	public Accounts(int acctNum, double balance) {
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
