package com.revature.service;

import java.util.Scanner;

import com.revature.menu.AccountMenu;
import com.revature.menu.UserMenu;

public class Transactions extends AccountMenu{
	
	static Scanner sc = new Scanner(System.in);
	
	public static void transactionStart(String userId) {
		id = userId;
		accountMenu(id);
	}

	public static void makeTransaction(String acctNum) {
		acct = acctNum;
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
			makeTransaction(acct);
			break;
		}
	}
	
	public static void deposit(String acctNum) {
		System.out.println("You can now make a deposit");
		//String dep = sc.nextLine();
		//add money to acctNum in database
		System.out.println("Would you like to make any other transactions on this account?");
		makeTransaction(acct);
	}
	
	public static void withdrawal(String acctNum) {
		System.out.println("You can now make a withdrawal");
		//String with = sc.nextLine();
		//subtract money from acctNum in database
		System.out.println("Would you like to make any other transactions on this account?");
		makeTransaction(acct);
	}
	
	public static void transactionLog(String userId) {
		id = userId;
		System.out.println("You can see all of your transactions");
		// order them by account #
		UserMenu.startUser(userId);
	}
}
