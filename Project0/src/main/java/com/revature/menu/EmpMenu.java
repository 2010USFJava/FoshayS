package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.Employees;
import com.revature.data.EmpRecords;
import com.revature.service.AcctInfo;
import com.revature.util.Log;

public class EmpMenu {
	
	static Scanner sc = new Scanner(System.in);
	public static int counter = 0;

	public static void empMenu() {
		System.out.println("Do you need to Login or Register as a New Employee?");
		System.out.println("\t[L]ogin");
		System.out.println("\t[R]egister");
		
		String loginOpt = sc.nextLine();
		switch(loginOpt.toLowerCase()) {
		case "l":
			empLogin();
			break;
		case "r":
			empReg();
			break;
		default:
			System.out.println("Invalid Input. Redirecting to Employee Menu.");
			empMenu();
			break;
		}
	}
	
	public static void empReg() {
		System.out.println("Enter Employee Name");
		String empName = sc.nextLine();
		
		System.out.println("Enter Employee UserName");
		String empUserName = sc.nextLine();
		
		System.out.println("Enter Employee Password");
		String empPassword = sc.nextLine();
		
		Employees x = new Employees(empUserName, empPassword, empName);
		Log.logging("info", "Employee " + x.getEmpName() + " has been created");
		empMenu();
	}
	
	public static void empLogin() {
		String loginTemp = null;
		System.out.println("Enter Employee UserName to Login");
		String empLogin = sc.nextLine();
		loginTemp = EmpRecords.empMap.get(empLogin);
		if(EmpRecords.empMap.containsKey(empLogin)) {
			System.out.println("Enter Employee Password to Login");
		}
		else {
			System.out.println("That UserName does not exist. Please try again.");
			empLogin();
		}
		String passLogin = sc.nextLine();
		if(loginTemp.equals(passLogin)) {
			System.out.println("You are now logged in to the Employee Portal");
			AcctInfo.accountInfo(counter);
		}
		else {
			System.out.println("Password is incorrect. Please try logging in again.");
			empLogin();
		}
	}
	
	
}
