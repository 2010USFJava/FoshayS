package com.revature.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Users;
import com.revature.dao.UsersDAO;
import com.revature.daoimpl.UsersDAOimpl;

public class RegistrationMenu {
	
	public static int acctNum;
	static Scanner sc = new Scanner(System.in);
	
	public static void startReg() {
		UsersDAO ud = new UsersDAOimpl();
		System.out.println("To begin registering a new user. Please enter a username.");
		//search usernames including admin and add if else or custom exception
		String userName = sc.nextLine();
		
		
		System.out.println("Enter a password.");
		//search password in database and add validations
		String userPass = sc.nextLine();
		try {
			ud.insertUser(new Users(userName, userPass));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("You have created a new user.");
	}

}
