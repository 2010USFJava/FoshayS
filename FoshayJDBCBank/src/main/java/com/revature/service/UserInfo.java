package com.revature.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Users;
import com.revature.dao.UsersDAO;
import com.revature.daoimpl.UsersDAOimpl;
import com.revature.menu.AccountMenu;
import com.revature.menu.AdminMenu;

public class UserInfo extends AdminMenu{
	
	
	static Scanner sc = new Scanner(System.in);
	
	public static UsersDAO udi = new UsersDAOimpl();
	public static Users u;
	
	public static void viewUsers() {
		System.out.println("Please enter a user from the list below.");
		if(userList == null) {
			try {
				userList = (ArrayList<Users>)udi.getAllUsers();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i).getUserName());
		}
		String option = sc.nextLine();
		
		username = option;
		try {
			u = udi.getUserName(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id = u.getUserid();
		AccountMenu.accountMenu(id);
		Transactions.makeTransaction();
	}
	
	public static void viewOneUser() {
		try {
			u = udi.getUserName(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u.getUserName());
		System.out.println(u.getPassword());
	}
	
	public static void updateUser() {
		viewUsers();
		
		AdminMenu.startAdmin();
	}
	
	public static void deleteUser() {
		System.out.println("You are now deleting a user.");
		AdminMenu.startAdmin();
	}

}
