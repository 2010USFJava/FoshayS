package com.revature.beans;

import java.io.Serializable;

import com.revature.data.PendingRecords;
import com.revature.util.File;
import com.revature.util.Log;

public class PendingAccts implements Comparable<PendingAccts>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7436432886666999142L;
	
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
		File.writePending(PendingRecords.pendingRecs);
		Log.logging("info", "Your account has been added to our pending account queue.");
		
	}
	
	public PendingAccts() {
		super();
		File.writePending(PendingRecords.pendingRecs);
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
