package com.revature.menu;

import com.revature.service.Transactions;

public class AccountMenu {
	
	public static String id;
	public static String acct;

	public static void accountMenu(String userId) {
		id = userId;
		System.out.println("Choose an account.");
		//display all user accounts in a sysout menu with choice options
		//switch statement that assigns the account # to acct based on user choice
		Transactions.makeTransaction(acct);
	}
}
