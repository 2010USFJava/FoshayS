package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Accounts;
import com.revature.dao.AccountsDAO;
import com.revature.util.ConnFactory;

public class AccountsDAOimpl implements AccountsDAO{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	public static List<Accounts> AcctList = new ArrayList<Accounts>();
	
	@Override
	public List<Accounts> getAll() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from bank.accounts");
		Accounts a = null;
		while (rs.next()) {
			a = new Accounts(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4));
			AcctList.add(a);
		}
		
		return AcctList;
	}
	

	@Override
	public void insert(Accounts a) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into bank.accounts values (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, a.getUserid());
		ps.setInt(2, a.getAcctNum());
		ps.setDouble(3, a.getBalance());
		ps.setString(4, a.getAcctType());
		ps.executeUpdate();
	}
	
	public Accounts getAcct(int acctNum) throws SQLException {
		
		return null;
	}
	
	public void updateAcct() throws SQLException {
		
	}
	
	public void deleteAcct() throws SQLException {
		
	}

}
