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
	public static List<Accounts> userAcctList = new ArrayList<Accounts>();
	
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
		ps.setInt(1, a.getAcctNum());
		ps.setInt(2, a.getUserid());
		ps.setDouble(3, a.getBalance());
		ps.setString(4, a.getAcctType());
		ps.executeUpdate();
	}
	
	@Override
	public List<Accounts> getUserAccts(int userid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from bank.accounts where userid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userid);
		ResultSet rs = ps.executeQuery();
		Accounts a = null;
		while(rs.next()) {
			a = new Accounts(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4));
			userAcctList.add(a);
		}
		return userAcctList;
	}
	
	@Override
	public Accounts getOneAcct(int acctNum) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from bank.accounts where acctnum=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, acctNum);
		ResultSet rs = ps.executeQuery();	
		Accounts a = null;
		while (rs.next()) {
		a = new Accounts(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4));
		}
		return a;
		}
	
	@Override
	public void updateAcct(double balance, int acctnum) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update bank.accounts set balance=? where acctnum=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, balance);
		ps.setInt(2, acctnum);
		ps.executeUpdate();
		}
	
	@Override
	public void deleteAcct(int acctNum) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "delete from bank.accounts where acctnum=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, acctNum);
		ps.executeUpdate();
	}

}
