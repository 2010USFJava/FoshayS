package com.revature.service;

import java.util.Scanner;

import com.revature.menu.AdminMenu;

public class UserInfo extends AdminMenu{
	
	
	static Scanner sc = new Scanner(System.in);
	
	public static void viewUser() {
		System.out.println("Please choose the user you would like to view");
		//display all users in a sysout menu with choice options
	}
	
	public static void updateUser() {
		System.out.println("You are now updating a user.");
		AdminMenu.startAdmin();
	}
	
	public static void deleteUser() {
		System.out.println("You are now deleting a user.");
		AdminMenu.startAdmin();
	}

}
