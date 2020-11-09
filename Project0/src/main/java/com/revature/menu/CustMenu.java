package com.revature.menu;

import java.util.Random;
import java.util.Scanner;

import com.revature.beans.Customers;
import com.revature.beans.PendingAccts;
import com.revature.data.CustRecords;
import com.revature.data.PendingRecords;
import com.revature.service.AcctInfo;
import com.revature.service.Transactions;
import com.revature.util.Log;

public class CustMenu {
	
	public static Boolean jointAcct = null;
	public static Boolean acctApproval = null;
	public static Integer acctNum;
	public static String custUserName;
	public static String custPassword;
	public static Customers x = null;
	public static int counter = 0;
	
	static Scanner sc = new Scanner(System.in);
	
	protected static void jointAccountChoice() {
		String jointChoice = sc.nextLine();
		if(jointChoice.equalsIgnoreCase("y")) {
			jointAcct = true;
			System.out.println("Enter Joint Customer's First and Last Name:");
			String jointName = sc.nextLine();
			
			System.out.println("Enter Joint Customer's Address:");
			String jointAddress = sc.nextLine();
			
			System.out.println("Enter Joint Customer's Phone #:");
			String jointPhone = sc.nextLine();
			new Customers(jointName, jointAddress, jointPhone, custUserName, custPassword, jointAcct, acctNum, acctApproval);
		}
		else if (jointChoice.equalsIgnoreCase("n")) {
			jointAcct = false;
		}
		else {
			System.out.println("Invalid Input. Please choose (y/n).");
			jointAccountChoice();
		}
	}
	
    protected static Integer getRandomNumberInRange(Integer min, Integer max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
	
	public static void customerMenu() {
		
		System.out.println("Do you need to Login or Register as a New Customer?");
		System.out.println("\t[L]ogin");
		System.out.println("\t[R]egister");
		
		String loginOpt = sc.nextLine();
		switch(loginOpt.toLowerCase()) {
		case "l":
			customerLogin();
			break;
		case "r":
			customerReg();
			break;
		default:
			System.out.println("Invalid Input. Redirecting to Customer Menu.");
			customerMenu();
			break;
		}
	}
	
	public static void custAccount(Customers y, int count) {
		x = y;
		counter = count;
		System.out.println("You are now logged into " + x.getAcctNum());
		System.out.println("\t[V]iew account details");
		System.out.println("\t[M]ake a transaction");
		System.out.println("\t[E]xit Account");
		String userOpt = sc.nextLine();
		switch(userOpt.toLowerCase()) {
		case "v":
			AcctInfo.viewAccts(x.getAcctNum(), counter);
			break;
		case "m":
			Transactions.transactions(x, 0);
			break;
		case "e":
			if(counter == 0) {
				MainMenu.startMenu();
			}
			else {
				AdminMenu.adminMenu(x);
			}
			break;
		default:
			System.out.println("Invalid Input. Please try again.");
			custAccount(x, counter);
			break;
			
		}
	}
	
	public static void customerLogin() {
		String passTemp = null;
		System.out.println("Enter Username:");
		custUserName = sc.nextLine();
		x = CustRecords.loginCustomer(custUserName);
		passTemp = x.getCustPassword();
		if(x == null) {
			System.out.println("Invalid UserName. Please try again.");
			customerLogin();
		}
		System.out.println("Enter Password:");
		String passLogin = sc.nextLine();
		
		if(passTemp.equals(passLogin)) {
			custAccount(x, 0);
		}
		else {
			System.out.println("Invalid Password. Please try again.");
			customerLogin();
		}
	}
	
	public static void customerReg() {
		
		System.out.println("Enter Customer First and Last Name:");
		String custName = sc.nextLine();
		
		System.out.println("Enter Customer Address:");
		String custAddress = sc.nextLine();
		
		System.out.println("Enter Customer Phone #:");
		String custPhone = sc.nextLine();
		
		System.out.println("Enter a User Name:");
		custUserName = sc.nextLine();
		
		System.out.println("Enter a Password:");
		custPassword = sc.nextLine();
		
		System.out.println("Please enter the amount of your initial deposit:");
		double deposit = Double.parseDouble(sc.nextLine());
		
		System.out.println("Will you be sharing this account with another Customer? (y/n)");
		acctNum = getRandomNumberInRange(0, 30000);
		jointAccountChoice();
		new Customers(custName, custAddress, custPhone, custUserName, custPassword, jointAcct, acctNum, acctApproval);
		new PendingAccts(acctNum, deposit);
		Log.logging("info", "Your account with us has been created is currently pending.");
		System.out.println("Please return in 2 - 3 business days to check and see if your account with us was approved.");
		System.out.println("Please have a great day, you will now be redirected to the main menu.");
		System.out.println(CustRecords.custSet.toString());
		System.out.println(PendingRecords.pendingRecs.toString());
		MainMenu.startMenu();
	}
}
