package com.revature.beans;

public class TransactionLog {

	private int logId;
	private int acctNum;
	
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public int getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}
	public TransactionLog(int logId, int acctNum) {
		super();
		this.logId = logId;
		this.acctNum = acctNum;
	}
	public TransactionLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TransactionLog [logId=" + logId + ", acctNum=" + acctNum + "]";
	}
	
	
	
	
}
