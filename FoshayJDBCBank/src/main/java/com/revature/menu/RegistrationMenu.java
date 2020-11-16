package com.revature.menu;

import java.util.Scanner;

public class RegistrationMenu {
	
	public static String acctNum;
	static Scanner sc = new Scanner(System.in);
	
	public static void startReg() {
		System.out.println("To begin registering a new user. Please enter a username.");
		//search usernames including admin and add if else or custom exception
		String userName = sc.nextLine();
		
		
		System.out.println("Enter a password.");
		//search password on database and add validations
		String userPass = sc.nextLine();
		//add username and password to the database
		
		System.out.println("You have created a new user.");
	}

}
