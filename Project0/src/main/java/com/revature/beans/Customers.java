package com.revature.beans;

public class Customers {
	
	private String custName;
	private String custAddress;
	private String custNumber;
	private String custUserName;
	private String custPassword;
	private Integer acctNum;
	
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
	public Integer getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(Integer acctNum) {
		this.acctNum = acctNum;
	}
	
	
	public Customers(String custName, String custAddress, String custNumber, String custUserName, String custPassword,
			Integer acctNum) {
		super();
		this.custName = custName;
		this.custAddress = custAddress;
		this.custNumber = custNumber;
		this.custUserName = custUserName;
		this.custPassword = custPassword;
		this.acctNum = acctNum;
	}
	
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customers [custName=" + custName + ", custAddress=" + custAddress + ", custNumber=" + custNumber
				+ ", custUserName=" + custUserName + ", custPassword=" + custPassword + ", acctNum=" + acctNum + "]";
	}
	


}
