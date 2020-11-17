package com.revature.menu;

import com.revature.service.Transactions;

public class AccountMenu {
	
	public static int id;
	public static int acct;

	public static void accountMenu(int userId) {
		id = userId;
		System.out.println("Choose an account.");
		//display all user accounts in a sysout menu with choice options
		//switch statement that assigns the account # to acct based on user choice
		Transactions.makeTransaction(acct);
	}
}
