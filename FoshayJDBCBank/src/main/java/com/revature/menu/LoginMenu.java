package com.revature.menu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.revature.beans.Users;
import com.revature.dao.UsersDAO;
import com.revature.daoimpl.UsersDAOimpl;

public class LoginMenu {
	
	public static String acctNum;
	public static Users u;
	static Scanner sc = new Scanner(System.in);
	
	
	public static void userLogin() {
		UsersDAO ud = new UsersDAOimpl();
		System.out.println("Please login with your username and password.");
		System.out.println("Enter Username:");
		String userName = sc.nextLine();
		try {
			u = ud.getUserName(userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userName.equals(u.getUserName())) {
			System.out.println("Enter Password:");
			String userPass = sc.nextLine();
			if(userPass.equals(u.getPassword())) {
				UserMenu.startUser(u.getUserid());
			}
			else {
				System.out.println("Incorrect password. Please try again.");
				userLogin();
			}
		}
	}
	
	public static void adminLogin() {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("database.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Please login with your username and password.");
		System.out.println("Enter Username:");
		String name = sc.nextLine();
		if(name.equals(prop.getProperty("adminName"))) {
			System.out.println("Enter Password:");
			String pass = sc.nextLine();	
				if(pass.equals(prop.getProperty("adminPass"))) {
					AdminMenu.startAdmin();
				}
				else {
					System.out.println("Incorrect Password. Please try again.");
					adminLogin();
				}
		}
		else {
				System.out.println("Invalid username.");
				MainMenu.startMenu();
			}
	}
}
