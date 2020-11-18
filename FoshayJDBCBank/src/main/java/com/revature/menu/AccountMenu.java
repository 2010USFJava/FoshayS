package com.revature.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Accounts;
import com.revature.daoimpl.AccountsDAOimpl;
import com.revature.service.Transactions;

public class AccountMenu {
	
	public static int id;
	public static int acct;
	public static AccountsDAOimpl adi = new AccountsDAOimpl();
	public static List<Accounts> acctList;
	static Scanner sc = new Scanner(System.in);
	
	public static void acctArrayList(int userid) {
		id = userid;
		if(acctList == null) {
			try {
				acctList = (ArrayList<Accounts>)adi.getUserAccts(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void accountMenu(int userId) {
		id = userId;
		acctArrayList(id);
		System.out.println("Please enter an account an available account from the list below.");
			for (int i = 0; i < acctList.size(); i++) {
				System.out.println(acctList.get(i).getAcctNum());
			}
			int option = Integer.parseInt(sc.nextLine());
			acct = option;
			
	}

}
