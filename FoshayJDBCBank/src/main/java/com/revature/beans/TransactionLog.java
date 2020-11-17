package com.revature.beans;

public class TransactionLog {

	private int userid;
	private int actionid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getActionid() {
		return actionid;
	}
	public void setActionid(int actionid) {
		this.actionid = actionid;
	}
	public TransactionLog(int userid, int actionid) {
		super();
		this.userid = userid;
		this.actionid = actionid;
	}
	public TransactionLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TransactionLog [userid=" + userid + ", actionid=" + actionid + "]";
	}
	

	
	
	
	
}
