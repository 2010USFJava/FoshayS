package com.revature.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Admins;
import com.revature.beans.Users;
import com.revature.daoimpl.UsersDAOimpl;

public class LoginMenu {
	
	public static String acctNum;
	static Scanner sc = new Scanner(System.in);
	

	public static void startLogin() {		
		System.out.println("Please login with your username and password.");
		System.out.println("Enter Username:");
		String userName = sc.nextLine();
		
		if (userName.equals(u.get)){
			System.out.println("Enter Password:");
			String userPass = sc.nextLine();
			if(userPass.equals(tempPass)) {
				//search database for acct #
				//acctNum = acct #
				UserMenu.startUser(acctNum);
			}
			else {
				System.out.println("Incorrect password. Please try again.");
				startLogin();
			}
		}
			else if(userName.equals(Admins.getAdminName())) {
			System.out.println("Enter Password:");
			String adminPass = sc.nextLine();	
				if(adminPass.equals(Admins.getAdminPass())) {
					AdminMenu.startAdmin();
				}
				else {
					System.out.println("Incorrect Password. Please try again.");
					startLogin();
				}
		}
			else {
				System.out.println("Invalid username. Do you need to register?");
				MainMenu.startMenu();
			}
	}
}
