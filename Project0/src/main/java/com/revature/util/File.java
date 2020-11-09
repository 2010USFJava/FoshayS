package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Set;

import com.revature.beans.Accounts;
import com.revature.beans.Customers;
import com.revature.beans.PendingAccts;
import com.revature.data.AcctRecords;
import com.revature.data.AdminRecords;
import com.revature.data.CustRecords;
import com.revature.data.EmpRecords;
import com.revature.data.PendingRecords;

public class File {
	public static final String custFile = "customers.txt";
	public static final String empFile = "employees.txt";
	public static final String adminFile = "admins.txt";
	public static final String acctFile = "accounts.txt";
	public static final String pendingFile = "pendingaccts.txt";
	
	//Write&Read Customers Information
	
	public static void writeCust(Set<Customers> custSet) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(custFile));
			objOut.writeObject(custSet);
			objOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readCust() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(custFile));
			CustRecords.custSet = (Set<Customers>)objIn.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Write&Read Employees Login Information
	
	public static void writeEmp(HashMap<String, String> empMap) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(empFile));
			objOut.writeObject(empMap);
			objOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readEmp() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(empFile));
			EmpRecords.empMap = (HashMap<String, String>)objIn.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Write&Read Admins Login Information
	
	public static void writeAdmin(HashMap<String, String> adminMap) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(adminFile));
			objOut.writeObject(adminMap);
			objOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readAdmin() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(adminFile));
			AdminRecords.adminMap = (HashMap<String, String>)objIn.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Write&Read Account Information
	
	public static void writeAcct(LinkedHashMap<Integer, Accounts> acctMap) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(acctFile));
			objOut.writeObject(acctMap);
			objOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readAcct() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(acctFile));
			AcctRecords.acctMap = (LinkedHashMap<Integer, Accounts>)objIn.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Write&Read Rejected Accounts from Pending Accounts
	
	public static void writePending(PriorityQueue<PendingAccts> pendingRecs) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(pendingFile, true));
			objOut.writeObject(pendingRecs);
			objOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readPending() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(pendingFile));
			PendingRecords.pendingRecs = (PriorityQueue<PendingAccts>)objIn.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
