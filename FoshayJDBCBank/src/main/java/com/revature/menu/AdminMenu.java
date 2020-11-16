package com.revature.menu;

import java.util.Scanner;

import com.revature.service.UserInfo;

public class AdminMenu extends RegistrationMenu{
	
	public static String id;
	static Scanner sc = new Scanner(System.in);
	
	public static void startAdmin() {
		System.out.println("Welcome to the Admin Menu.");
		System.out.println("What would you like to do?");
		System.out.println("\t[V]iew Users");
		System.out.println("\t[R]egister a User");
		System.out.println("\t[U]pdate a User");
		System.out.println("\t[M]ake a Transaction");
		System.out.println("\t[D]elete a User");
		System.out.println("\t[L]ogout");
		
		String option = sc.nextLine();
		switch(option.toLowerCase()) {
		case "v":
			whichUser();
			break;
		case "r":
			startReg();
			startAdmin();
			break;
		case "u":
			UserInfo.updateUser();
			break;
		case "m":
			UserInfo.viewUser();
			System.out.println(id);
			AccountMenu.accountMenu(id);
			break;
		case "d":
			UserInfo.deleteUser();
			break;
		case "l":
			MainMenu.startMenu();
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			startAdmin();
			break;
		}
		
	}
	
	public static void whichUser() {
		System.out.println("Would you like to view one user, or all users?");
		System.out.println("\t[O]ne User");
		System.out.println("\t[A]ll Users");
		System.out.println("\t[E]xit");
		
		String choice = sc.nextLine();
		switch(choice.toLowerCase()) {
		case "o":
			UserInfo.viewUser();
			startAdmin();
			break;
		case "a":
			//return all user from the database
			whichUser();
			break;
		case "e":
			startAdmin();
			break;
		default:
			System.out.println("Invalid Input. Please try again.");
			whichUser();
			break;
		}
		
	}

}
