package com.revature.service;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.revature.beans.Accounts;
import com.revature.dao.AccountsDAO;
import com.revature.daoimpl.AccountsDAOimpl;
import com.revature.menu.AccountMenu;
import com.revature.menu.UserMenu;

public class AcctInfo extends AccountMenu{
	
	public static int acctNum;
	public static String acctType;
	static Scanner sc = new Scanner(System.in);
	
	public static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
	}
	
	public static void newAcct(AccountsDAO x) {
		try {
			x.insert(new Accounts(id, acctNum, 0, acctType));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addAccount(int userId) {
		id = userId;
		acctNum = getRandomNumberInRange(0, 30000);
		AccountsDAO ad = new AccountsDAOimpl();
		System.out.println("What kind of account would you like to add?");
		System.out.println("\t[C]hecking");
		System.out.println("\t[S]avings");
		System.out.println("\t[M]oney Market");
		System.out.println("\t[E]xit");
		
		String choice = sc.nextLine();
		switch(choice.toLowerCase()) {
		case "c":
			acctType = "Checking";
			newAcct(ad);
			System.out.println("You have successfully added a checking account.");
			addAccount(id);
			break;
		case "s":
			acctType = "Savings";
			newAcct(ad);
			System.out.println("You have successfully added a saving account.");
			addAccount(id);
			break;
		case "m":
			acctType = "Money Market";
			newAcct(ad);
			System.out.println("You have successfully added a money market account");
			addAccount(id);
			break;
		case "e":
			UserMenu.startUser(id);
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			addAccount(id);
			break;
		}
		
	
	}
	
	public static void viewAccounts(int userId) {
		id = userId;
		
		System.out.println("These are all of your accounts.");
		//pull all accounts from the database
		System.out.println("Would you like to make a transaction on any of these accounts? (y/n)");
		
		String option = sc.nextLine();
		switch(option.toLowerCase()) {
		case "y":
			Transactions.makeTransaction(id);
			break;
		case "n":
			UserMenu.startUser(id);
			break;
		default:
			System.out.println("Invalid input.");
			viewAccounts(id);
			break;
		}
	}
	
	public static void deleteAccount(int userId) {
		id = userId;
		accountMenu(id);
		//custom exception if balance is not zero then sysout that account cannot be removed.
		//delete acct
		System.out.println(acct + " has been deleted.");
		UserMenu.startUser(id);
	}
}
