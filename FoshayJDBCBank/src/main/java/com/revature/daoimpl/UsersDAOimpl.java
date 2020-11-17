package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Users;
import com.revature.dao.UsersDAO;
import com.revature.util.ConnFactory;

public class UsersDAOimpl implements UsersDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public List<Users> getAllUsers() throws SQLException {
		List<Users> UserList = new ArrayList<Users>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		//ResultSet rs = stmt.executeQuery(arg0);
		//Users u = null;
		//while (rs.next()) {
			//u = new Users(rs.getString(1), rs.getString(2), rs.getInt(3));
			//UserList.add(u);
		//}
		
		return UserList;
	}
	
	@Override
	public void insertUser(Users u) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into bank.users values (DEFAULT, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, u.getUserName());
		ps.setString(2, u.getPassword());
		ps.executeUpdate();
	}

}
