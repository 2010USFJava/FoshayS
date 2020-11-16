package com.revature.menu;

import java.util.Scanner;

import com.revature.service.AcctInfo;
import com.revature.service.Transactions;

public class UserMenu {
	
	
	public static String id;
	
	static Scanner sc = new Scanner(System.in);
	
	public static void startUser(String userId){
		id = userId;
		System.out.println("Welcome to the User Menu");
		System.out.println("What would you like to do?");
		System.out.println("\t[A]dd an account");
		System.out.println("\t[V]iew my accounts");
		System.out.println("\t[M]ake a transaction");
		System.out.println("\t[S]ee my transaction history");
		System.out.println("\t[R]emove an empty account");
		System.out.println("\t[L]ogout");
		
		String option = sc.nextLine();
		switch(option.toLowerCase()) {
		case "a":
			AcctInfo.addAccount(id);
			break;
		case "v":
			AcctInfo.viewAccounts(id);
			break;
		case "m":
			Transactions.transactionStart(id);
			break;
		case "s":
			Transactions.transactionLog(id);
			break;
		case "r":
			AcctInfo.deleteAccount(id);
			break;
		case "l":
			id = null;
			MainMenu.startMenu();
			break;
		}
		
		
	}
}
