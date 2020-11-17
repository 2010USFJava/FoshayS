package com.revature.menu;

import java.util.Scanner;

public class MainMenu extends RegistrationMenu{
	
	static Scanner sc = new Scanner(System.in);
	
	public static void startMenu() {
		System.out.println("Welcome to JDBC Bank");
		System.out.println("Do you need to login or register as a new user?");
		System.out.println("\t[L]ogin Customer");
		System.out.println("\t[R]egister Customer");
		System.out.println("\t[A]dmin Login");
		System.out.println("\t[E]xit");
		
		String option = sc.nextLine();
		switch(option.toLowerCase()) {
		case "l":
			LoginMenu.userLogin();
			break;
		case "r":
			startReg();
			UserMenu.startUser(acctNum);
			break;
		case "a":
			LoginMenu.adminLogin();
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
