package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Accounts;

public interface AccountsDAO {

	List<Accounts> getAll() throws SQLException;

	void insert(Accounts a) throws SQLException;

	List<Accounts> getUserAccts(int userid) throws SQLException;

	void deleteAcct(int acct) throws SQLException;

	void updateAcct(double balance, int acctnum) throws SQLException;

	Accounts getOneAcct(int acctNum) throws SQLException;

}
