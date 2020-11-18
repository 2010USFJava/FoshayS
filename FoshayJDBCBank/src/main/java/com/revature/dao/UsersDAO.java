package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Users;

public interface UsersDAO {

		public List<Users> getAllUsers() throws SQLException;

		public void insertUser(Users u) throws SQLException;
		
		public Users getUserName(String name) throws SQLException;

		void updateUserName(String newName, String userName) throws SQLException;

		void updatePassword(String password, String userName) throws SQLException;

		void deleteUser(String userName) throws SQLException;
}
