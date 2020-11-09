package com.revature.beans;

import java.io.Serializable;

import com.revature.data.EmpRecords;
import com.revature.util.File;
import com.revature.util.Log;

public class Employees implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2515964391322279590L;
	
	private String userName;
	private String password;
	private String empName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Employees(String userName, String password, String empName) {
		super();
		this.userName = userName;
		this.password = password;
		this.empName = empName;
		EmpRecords.empMap.put(this.userName, this.password);
		File.writeEmp(EmpRecords.empMap);
		Log.logging("info", this.getEmpName() + " has been added to the Employee register.");
	}
	
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Employees [userName=" + userName + ", password=" + password + ", empName=" + empName + "]";
	}
	

	
	

}
