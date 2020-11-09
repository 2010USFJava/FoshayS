package com.revature.data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.revature.beans.Customers;

public class CustRecords {
	
	public static Set<Customers> custSet = new HashSet<Customers>();
	
	public static Customers selectCustomer(Integer acctNum) {
		Iterator<Customers> i = custSet.iterator();
		System.out.println(acctNum);
		for(Customers i1: custSet)
			return i1;
		System.out.println("This customer account does not exist.");
		return null;
	}
	
	public static Customers loginCustomer(String userName) {
		Iterator<Customers> log = custSet.iterator();
		for(Customers log1: custSet)
			return log1;
		System.out.println("Invalid username");
		return null;
	}
	
}
