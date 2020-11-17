package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.TransactionLog;
import com.revature.dao.TransactionsDAO;
import com.revature.util.ConnFactory;

public class TransactionDAOimpl implements TransactionsDAO{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	public static List<TransactionLog> actionLog = new ArrayList<TransactionLog>();
	
	public List<TransactionLog> getActions() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from bank.transactions");
		TransactionLog t = null;
		while (rs.next()) {
			t = new TransactionLog(rs.getInt(1), rs.getInt(2));
			actionLog.add(t);
		}
		
		return actionLog;
	}
}
