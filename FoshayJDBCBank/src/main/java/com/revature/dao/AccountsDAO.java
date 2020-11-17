package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Accounts;

public interface AccountsDAO {

	List<Accounts> getAll() throws SQLException;

	void insert(Accounts a) throws SQLException;

}
