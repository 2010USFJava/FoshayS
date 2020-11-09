package com.revature.beans;

import java.io.Serializable;

import com.revature.data.CustRecords;
import com.revature.util.File;
import com.revature.util.Log;

public class Customers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5837854056587661038L;
	
	private String custName;
	private String custAddress;
	private String custNumber;
	private String custUserName;
	private String custPassword;
	private Boolean jointAcct;
	private Integer acctNum;
	private Boolean acctApproval;
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustNumber() {
		return custNumber;
	}
	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}
	public String getCustUserName() {
		return custUserName;
	}
	public void setCustUserName(String custUserName) {
		this.custUserName = custUserName;
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public Boolean getJointAcct() {
		return jointAcct;
	}
	public void setJointAcct(Boolean jointAcct) {
		this.jointAcct = jointAcct;
	}
	public Integer getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(Integer acctNum) {
		this.acctNum = acctNum;
	}
	public Boolean getAcctApproval() {
		return acctApproval;
	}
	public void setAcctApproval(Boolean acctApproval) {
		this.acctApproval = acctApproval;
	}
	
	public Customers(String custName, String custAddress, String custNumber, String custUserName, String custPassword,
			Boolean jointAcct, Integer acctNum, Boolean acctApproval) {
		super();
		this.custName = custName;
		this.custAddress = custAddress;
		this.custNumber = custNumber;
		this.custUserName = custUserName;
		this.custPassword = custPassword;
		this.jointAcct = jointAcct;
		this.acctNum = acctNum;
		this.acctApproval = acctApproval;
		CustRecords.custSet.add(this);
		File.writeCust(CustRecords.custSet);
		Log.logging("info", this.getCustName() +  " has been added to our system.");
	}
	
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Customers [custName=" + custName + ", custAddress=" + custAddress + ", custNumber=" + custNumber
				+ ", custUserName=" + custUserName + ", custPassword=" + custPassword + ", jointAcct=" + jointAcct
				+ ", acctNum=" + acctNum + ", acctApproval=" + acctApproval + "]";
	}
	
	

}
