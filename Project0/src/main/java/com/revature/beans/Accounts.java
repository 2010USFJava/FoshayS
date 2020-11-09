package com.revature.beans;

import java.io.Serializable;

import com.revature.data.AcctRecords;
import com.revature.util.File;
import com.revature.util.Log;

public class Accounts implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3346028631221150720L;
	
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
		AcctRecords.acctMap.put(this.acctNum, this);
		File.writeAcct(AcctRecords.acctMap);
		Log.logging("info", this.getAcctNum() + " has been approved.");
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
