package com.revature.beans;

public class TransactionLog {

	private String log;

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public TransactionLog(String log) {
		super();
		this.log = log;
	}

	public TransactionLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TransactionLog [log=" + log + "]";
	}
	
	
}
