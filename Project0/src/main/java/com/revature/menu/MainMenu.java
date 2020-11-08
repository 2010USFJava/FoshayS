package com.revature.menu;

import java.util.Scanner;

public class MainMenu {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void startMenu() {
		System.out.println("Welcome to Java Banking");
		System.out.println("Are you logging in as a Customer, Employee, or Administrator?");
		System.out.println("\t[C]ustomer");
		System.out.println("\t[E]mployee");
		System.out.println("\t[A]dministrator");
		
		String option = sc.nextLine();
		switch(option.toLowerCase()) {
		case "c":
			CustMenu.customerMenu();
			break;
		case "e":
			//EmpMenu.employeeLogin();
			break;
		case "a":
			//AdminMenu.adminLogin();
			break;
		default:
			System.out.println("Invalid Input. Redirecting to Main Menu.");
			startMenu();
			break;
		}
	}

}
