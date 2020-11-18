package com.revature.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Accounts;
import com.revature.dao.AccountsDAO;
import com.revature.daoimpl.AccountsDAOimpl;
import com.revature.menu.AccountMenu;
import com.revature.menu.UserMenu;

public class Transactions extends AccountMenu{
	
	static Scanner sc = new Scanner(System.in);
	public static Accounts a;
	public static double balance;
	public static AccountsDAO ad = new AccountsDAOimpl();
	
	public static void transactionStart(int userId) {
		id = userId;
		acctArrayList(id);
		accountMenu(id);
	}

	public static void makeTransaction() {
		System.out.println("What type of transaction would you like to make?");
		System.out.println("\t[D]eposit");
		System.out.println("\t[W]ithdrawal");
		System.out.println("\t[E]xit");
		
		String choice = sc.nextLine();
		switch(choice.toLowerCase()) {
		case "d":
			deposit(acct);
			break;
		case "w":
			withdrawal(acct);
			break;
		case "e":
			UserMenu.startUser(id);
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			makeTransaction();
			break;
		}
	}
	
	public static void deposit(int acctNum) {
		acct = acctNum;
		System.out.println("You can now make a deposit");
		System.out.println("Please enter the amount of your deposit.");
		int dep = Integer.parseInt(sc.nextLine());
		try {
			a = ad.getOneAcct(acct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		balance = a.getBalance() + dep;
		try {
			ad.updateAcct(balance, acct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your ending balance for account #" + acct + " is " + balance);
		System.out.println("Would you like to make any other transactions on this account?");
		makeTransaction();
	}
	
	public static void withdrawal(int acctNum) {
		System.out.println("You can now make a withdrawal");
		System.out.println("Please enter the amount of your withdrawal.");
		int with = Integer.parseInt(sc.nextLine());
		try {
			a = ad.getOneAcct(acctNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		balance = a.getBalance() - with;
		try {
			ad.updateAcct(balance, acctNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your ending balance for account #" + acctNum + " is " + balance);
		System.out.println("Would you like to make any other transactions on this account?");
		makeTransaction();
	}
	
	public static void transactionLog(int userId) {
		id = userId;
		System.out.println("You can see all of your transactions");
		// order them by account #
		UserMenu.startUser(userId);
	}
}
