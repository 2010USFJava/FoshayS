package com.revature.service;

import java.util.Scanner;

import com.revature.beans.Accounts;
import com.revature.beans.Customers;
import com.revature.beans.PendingAccts;
import com.revature.data.AcctRecords;
import com.revature.data.CustRecords;
import com.revature.data.PendingRecords;
import com.revature.menu.AdminMenu;
import com.revature.menu.CustMenu;
import com.revature.menu.MainMenu;
import com.revature.util.Log;

public class AcctInfo {
	
	static Integer acctNum = null;
	static Scanner sc = new Scanner(System.in);
	static int counter = 0;
	public static Customers x = null;
	
	public static void accountInfo(int count) {
		counter = count;
		System.out.println("Which would you like to see?");
		System.out.println("\t[A]ctive Accounts");
		System.out.println("\t[P]ending Accounts");
		System.out.println("\t[E]xit Accounts");
		
		String acctOpt = sc.nextLine();
		switch(acctOpt.toLowerCase()) {
		case "a":
			System.out.println("Please enter the number of the account you would like to see?");
			acctNum = Integer.parseInt(sc.nextLine());
			if(CustRecords.selectCustomer(acctNum) != null) {
				viewAccts(acctNum, counter);
			}
			else {
				System.out.println("Account doesn't exist.");
			}
			accountInfo(counter);
			break;
		case "p":
			pendingAccts();
			break;
		case "e":
			System.out.println("You are leaving accounts.");
			if(count != 0) {
				AdminMenu.adminMenu(x);
			}
			else {
				MainMenu.startMenu();
			}
			break;
		default:
			System.out.println("Invalid Input. Please try again.");
			accountInfo(counter);
			break;
		}
	}
	
	public static void viewAccts(Integer num, int count) {
		Customers x = CustRecords.selectCustomer(num);
		Accounts y = AcctRecords.acctMap.get(num);
		System.out.println(x);
		System.out.println(y);
		if(counter == 0) {
			CustMenu.custAccount(x, counter);
		}
		else {
			AdminMenu.adminMenu(x);
		}
	}
	
	public static void pendingAccts() {
		PendingAccts x = PendingRecords.pendingRecs.peek();
		double balance = 0;
		Customers cust = null;
		
		System.out.println("Please Approve or Deny the following Account:");
		if(x != null) {
			System.out.println(x);
			acctNum = x.getAcctNum();
			balance = x.getBalance();
			cust = CustRecords.selectCustomer(acctNum);
		}
		else {
			System.out.println("There are no pending accounts at this time.");
			accountInfo(counter);
		}
		System.out.println("\t[A]pprove");
		System.out.println("\t[D]eny");
		String acctAction = sc.nextLine();
		switch(acctAction.toLowerCase()) {
		case "a":		
			new Accounts(acctNum, balance);
			cust.setAcctApproval(true);
			Log.logging("info", acctNum + " has been approved.");
			PendingRecords.pendingRecs.remove();
			new PendingAccts();
			accountInfo(counter);
			break;
		case "d":
			cust.setAcctApproval(false);
			Log.logging("info", acctNum + " has been denied.");
			PendingRecords.pendingRecs.remove();
			new PendingAccts();
			accountInfo(counter);
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			pendingAccts();
			break;
		}
		
	}

}
