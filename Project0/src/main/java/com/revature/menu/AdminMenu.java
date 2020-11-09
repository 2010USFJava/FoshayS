package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.Accounts;
import com.revature.beans.Admins;
import com.revature.beans.Customers;
import com.revature.data.AcctRecords;
import com.revature.data.AdminRecords;
import com.revature.data.CustRecords;
import com.revature.service.AcctInfo;
import com.revature.service.Transactions;
import com.revature.util.Log;

public class AdminMenu {
	
	public static String adminUserName;
	public static String adminPassword;
	public static Customers x = null;
	public static int counter = 1;
	
	static Scanner sc = new Scanner(System.in);
	
	public static void startAdmin() {
		
		System.out.println("Do you need to Login or Register as a New Admin?");
		System.out.println("\t[L]ogin");
		System.out.println("\t[R]egister");
		
		String loginOpt = sc.nextLine();
		switch(loginOpt.toLowerCase()) {
		case "l":
			adminLogin();
			break;
		case "r":
			adminReg();
			break;
		default:
			System.out.println("Invalid Input. Redirecting.");
			startAdmin();
			break;
		}
	}
	
	public static void adminLogin() {
		String loginTemp = null;
		System.out.println("Enter Admin UserName to Login");
		String adminLog = sc.nextLine();
		loginTemp = AdminRecords.adminMap.get(adminLog);
		if(AdminRecords.adminMap.containsKey(adminLog)) {
			System.out.println("Enter Admin Password to Login");
		}
		else {
			System.out.println("That UserName does not exist. Please try again.");
			adminLogin();
		}
		String passLogin = sc.nextLine();
		if(loginTemp.equals(passLogin)) {
			System.out.println("You are now logged in to the Administrator Portal");
			adminMenu(x);
		}
		else {
			System.out.println("Password is incorrect. Please try logging in again.");
			adminLogin();
		}
	}
	
	public static void adminReg() {
		
		System.out.println("Enter Admin UserName");
		String adminUserName = sc.nextLine();
		
		System.out.println("Enter Admin Password");
		String adminPassword = sc.nextLine();
		
		Admins x = new Admins(adminUserName, adminPassword);
		Log.logging("info", "Admin " + x.getUserName() + " has been created");
		startAdmin();
	}
	
	public static void cancel() {
		System.out.println("What bank account do you need to cancel?");
		Integer num = Integer.parseInt(sc.nextLine());
		Accounts acct = AcctRecords.acctMap.remove(num);
		Log.logging("info", acct.getAcctNum() + " has been canceled.");
		x = CustRecords.selectCustomer(num);
		x.setAcctApproval(false);
	}
	
	public static void adminMenu(Customers y) {
		x = y;
		System.out.println("\t[V]iew Accounts");
		System.out.println("\t[T]ransactions");
		System.out.println("\t[C]ancel Account");
		System.out.println("\t[E]xit");
		String adminOpt = sc.nextLine();
		switch(adminOpt.toLowerCase()) {
		case "v":
			AcctInfo.accountInfo(counter);
			break;
		case "t":
			Transactions.transactions(x, counter);
			break;
		case "c":
			cancel();
			break;
		case "e":
			System.out.println("Exit Admin Menu");
			MainMenu.startMenu();
			break;
		default:
			System.out.println("Invalid Input. Redirecting.");
			startAdmin();
			break;
		}
		
	}
}
