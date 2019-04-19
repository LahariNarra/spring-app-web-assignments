package com.capgemini.spring.mvc.bank.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.spring.mvc.bank.dao.BankAccountDao;
import com.capgemini.spring.mvc.model.BankAccount;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public BankAccountDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean addNewBankAccount(BankAccount account) {
		int result = jdbcTemplate.update(
				"INSERT INTO bankaccounts (customer_name,account_type,account_balance) VALUES (?,?,?)",
				new Object[] { account.getAccountHolderName(), account.getAccountType(), account.getAccountBalance() });
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBankAccount(long accountId) {

		int resultSet = jdbcTemplate.update("DELETE FROM bankaccounts WHERE account_id= ? ",
				new Object[] { accountId });
		if (resultSet == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType) {

		int resultSet = jdbcTemplate.update("UPDATE bankaccounts SET customer_name=?,account_type=? WHERE account_id=?",
				new Object[] { accountHolderName, accountType, accountId });
		if (resultSet == 1) {
			return true;
		}

		return false;
	}

	@Override
	public List<BankAccount> findAllBankAccountsDetails() {
		String query1 = "SELECT * FROM bankaccounts";
		List<BankAccount> accounts = jdbcTemplate.query(query1, (resultSet, row) -> {
			BankAccount account = new BankAccount(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getDouble(4));
			return account;
		});
		return accounts;
	}

	@Override
	public BankAccount searchAccountDetails(long accountId) {
		String query1 = "SELECT * FROM bankaccounts WHERE account_id=" + accountId;
		BankAccount account = jdbcTemplate.queryForObject(query1, (resultSet, row) -> {
			BankAccount accounts = new BankAccount(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getDouble(4));
			return accounts;
		});
		return account;
	}

	@Override
	public double getBalance(long accountId) {
		double balance = -1;
		balance = jdbcTemplate.queryForObject("SELECT account_balance FROM bankaccounts WHERE account_id=?",
				new Object[] { accountId }, Double.class);
		return balance;
	}

	@Override
	public void updateBalance(long accountId, double newBalance) {
		jdbcTemplate.update("UPDATE bankaccounts SET account_balance=? WHERE account_id=?",
				new Object[] { newBalance, accountId });
	}

}
