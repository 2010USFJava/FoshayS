package com.revature.service;

import java.util.Scanner;

import com.revature.beans.Accounts;
import com.revature.beans.Customers;
import com.revature.data.AcctRecords;
import com.revature.exceptions.NegNumException;
import com.revature.menu.CustMenu;
import com.revature.util.Log;

public class Transactions {
	static Integer acctNum = null;
	static Accounts acct;
	static Customers cust;
	static double money;
	static Scanner sc = new Scanner(System.in);
	static int counter = 0;
	static Boolean i = null;
	
	public static void transactions(Customers x, int count) {
		cust = x;
		counter = count;
		System.out.println("What transaction would you like to make?");
		System.out.println("\t[W]ithdrawal");
		System.out.println("\t[D]eposit");
		System.out.println("\t[T]ransfer");
		System.out.println("\t[E]xit Transactions");
		String choice = sc.nextLine();
		switch(choice.toLowerCase()) {
		case "w":
			if(counter == 0) {
			acctNum = x.getAcctNum();
			withdrawBlurb(acctNum, counter);
			}
			else {
			transferBlurb(acctNum, counter);
			i = true;
			}
			break;
		case "d":
			if(counter == 0) {
			acctNum = x.getAcctNum();
			depositBlurb(acctNum, counter);
			}
			else {
			transferBlurb(acctNum, counter);
			i = false;
			}
			break;
		case "t":
			if(counter == 0) {
			acctNum = x.getAcctNum();
			transfer(acctNum, counter);
			}
			else {
			transferBlurb(acctNum, counter);
			}
			break;
		case "e":
			CustMenu.custAccount(cust, counter);
			break;
		default:
			break;
		}
	}
	
	public static void withdraw(Integer num){
		acct = AcctRecords.acctMap.get(num);
		double balance = acct.getBalance();
		acct.setBalance(balance - money);
		Log.logging("info", "You have withdrawn " + money + " from " + acct.getAcctNum());
		Log.logging("info", "The current balance is now " + acct.getBalance());
		
	}
	
	public static void deposit(Integer num){
		acct = AcctRecords.acctMap.get(num);
		double balance = acct.getBalance();
		acct.setBalance(balance + money);
		Log.logging("info", "You have deposited " + money + " into " + acct.getAcctNum());
		Log.logging("info", "The current balance is now " + acct.getBalance());
	}
	
	public static void depositBlurb(Integer num, int count) {
		System.out.println("How much would you like to deposit?");
		money = Double.parseDouble(sc.nextLine());
		deposit(num);
		transactions(cust, counter);
	}
	
	public static void withdrawBlurb(Integer num, int count) {
		System.out.println("How much would you like to withdraw?");
		money = Double.parseDouble(sc.nextLine());
		withdraw(num);
		transactions(cust, counter);
	}
	
	public static void transferBlurb(Integer num, int count) {
		System.out.println("Which account are you making this transaction from?");
		Integer numAcct = Integer.parseInt(sc.nextLine());
		if(i == true) {
		withdraw(numAcct);
		}
		else if (i == false) {
		deposit(numAcct);
		}
		else {
		transfer(numAcct, counter);
		}
	}
	
	public static void transfer(Integer num, int count) {
		acct = AcctRecords.acctMap.get(num);
		System.out.println("What bank account do you want to make your transfer to?");
		Integer num2 = Integer.parseInt(sc.nextLine());
		Accounts acct2 = AcctRecords.acctMap.get(num2);
	
		System.out.println("How much would you like to transfer?");
		money = Double.parseDouble(sc.nextLine());
		System.out.println("transferring...");
		withdraw(acct.getAcctNum());
		deposit(acct2.getAcctNum());
		transactions(cust, counter);
		
	}

}
