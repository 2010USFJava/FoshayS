package com.revature.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.revature.beans.Accounts;
import com.revature.dao.AccountsDAO;
import com.revature.daoimpl.AccountsDAOimpl;
import com.revature.menu.AccountMenu;
import com.revature.menu.UserMenu;

public class AcctInfo extends AccountMenu{
	
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
			x.insert(new Accounts(acct, id, 0, acctType));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addAccount(int userId) {
		id = userId;
		AccountsDAO ad = new AccountsDAOimpl();
		System.out.println("What kind of account would you like to add?");
		System.out.println("\t[C]hecking");
		System.out.println("\t[S]avings");
		System.out.println("\t[M]oney Market");
		System.out.println("\t[E]xit");
		
		String choice = sc.nextLine();
		switch(choice.toLowerCase()) {
		case "c":
			acct = getRandomNumberInRange(0, 30000);
			acctType = "Checking";
			newAcct(ad);
			System.out.println("You have successfully added a checking account.");
			addAccount(id);
			break;
		case "s":
			acct = getRandomNumberInRange(0, 30000);
			acctType = "Savings";
			newAcct(ad);
			System.out.println("You have successfully added a saving account.");
			addAccount(id);
			break;
		case "m":
			acct = getRandomNumberInRange(0, 30000);
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
		acctArrayList(id);
		for (Accounts a : acctList)
			System.out.println(a.getAcctNum());
		System.out.println("Would you like to make a transaction on any of these accounts? (y/n)");
		
		String option = sc.nextLine();
		switch(option.toLowerCase()) {
		case "y":
			accountMenu(id);
			Transactions.makeTransaction();
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
	
	public static void deleteAccount(int userid) {
		accountMenu(id);
		//custom exception if balance is not zero then sysout that account cannot be removed.
		AccountsDAO ad = new AccountsDAOimpl();
		try {
			ad.deleteAcct(acct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(acct + " has been deleted.");
		UserMenu.startUser(id);
	}

	
}
