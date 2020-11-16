package com.revature.menu;

import java.util.Scanner;

public class MainMenu extends RegistrationMenu{
	
	static Scanner sc = new Scanner(System.in);
	
	public static void startMenu() {
		System.out.println("Welcome to JDBC Bank");
		System.out.println("Do you need to login or register as a new user?");
		System.out.println("\t[L]ogin");
		System.out.println("\t[R]egister");
		System.out.println("\t[E]xit");
		
		String option = sc.nextLine();
		switch(option.toLowerCase()) {
		case "l":
			LoginMenu.startLogin();
			break;
		case "r":
			startReg();
			UserMenu.startUser(acctNum);
			break;
		case "e":
			System.out.println("Thank you for banking with JDBC Bank. Please come back soon.");
			break;
		default:
			System.out.println("Invalid Input. Redirecting to Main Menu.");
			startMenu();
			break;
		}
	}

}
