package com.revature.beans;

import com.revature.data.PendingRecords;
import com.revature.util.Log;

public class PendingAccts implements Comparable<PendingAccts>{
	
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
		
		PendingRecords.pendingRecs.add(this);
		Log.logging("info", "Your account has been added to our pending account queue.");
		
	}
	
	public PendingAccts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "PendingAccts [acctNum=" + acctNum + ", balance=" + balance + "]";
	}
	@Override
	public int compareTo(PendingAccts arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
	
}
