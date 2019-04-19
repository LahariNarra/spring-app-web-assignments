package com.capgemini.spring.mvc.bank.service.impl;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.spring.mvc.bank.dao.BankAccountDao;
import com.capgemini.spring.mvc.bank.exception.BankAccountNotFoundException;
import com.capgemini.spring.mvc.bank.exception.LowBalanceException;
import com.capgemini.spring.mvc.bank.service.BankAccountService;
import com.capgemini.spring.mvc.model.BankAccount;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	private BankAccountDao bankAccount;

	public BankAccountServiceImpl(BankAccountDao bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Override
	public boolean deleteBankAccount(long accountId) throws BankAccountNotFoundException {
		boolean result = bankAccount.deleteBankAccount(accountId);
		if (result) {
			//bankAccount.commit();
			return result;
		} else {
			throw new BankAccountNotFoundException("BankAccount doesn't exist....");
		}

	}

	@Override
	public boolean addNewBankAccount(BankAccount account) {
		boolean result = bankAccount.addNewBankAccount(account);

		/*if (result) {
			bankAccount.commit();
		}*/

		return result;
	}

	@Override
	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType) {
		boolean result = bankAccount.updateBankAccountDetails(accountId, accountHolderName, accountType);
		/*if (result) {
			bankAccount.commit();
		}*/

		return result;
	}
	
	@Override
	public List<BankAccount> findAllBankAccountsDetails() {
		return bankAccount.findAllBankAccountsDetails();
	}

	@Override
	public BankAccount searchAccountDetails(long accountId) throws BankAccountNotFoundException {
		return bankAccount.searchAccountDetails(accountId);
	}

	@Override
	public double checkBalance(long accountId) throws BankAccountNotFoundException {
		double balance = bankAccount.getBalance(accountId);
		if (balance >= 0) {
			return balance;
		} else {
			throw new BankAccountNotFoundException("BankAccount doesn't exist....");
		}
	}

	@Override
	public double withdraw(long accountId, double amount) throws LowBalanceException, BankAccountNotFoundException {
		double balance = bankAccount.getBalance(accountId);
		if (balance < 0) {
			throw new BankAccountNotFoundException("BankAccount doesn't exist....");
		} else if (balance - amount >= 0) {
			balance = balance - amount;
			bankAccount.updateBalance(accountId, balance);
			//bankAccount.commit();
			return balance;
		} else {
			throw new LowBalanceException("You don't have sufficient fund.");
		}
	}

	@Override
	public double deposit(long accountId, double amount) throws BankAccountNotFoundException {
		double balance = bankAccount.getBalance(accountId);
		if (balance < 0) {
			throw new BankAccountNotFoundException("BankAccount doesn't exist....");
		} else {
			balance = balance + amount;
			bankAccount.updateBalance(accountId, balance);
			//bankAccount.commit();
			return balance;
		}
	}

	

	@Override
	@Transactional(rollbackFor = AccountNotFoundException.class)
	public double fundTransfer(long fromAccountId, long toAccountId, double amount)
			throws LowBalanceException, BankAccountNotFoundException {

		try {
			double newBalance = withdrawForFundTransfer(fromAccountId, amount);
			deposit(toAccountId, amount);
			//bankAccount.commit();
			return newBalance;
		} catch (LowBalanceException | BankAccountNotFoundException e) {

			e.printStackTrace();
			//bankAccount.rollback();
			throw e;
		}
	}

	private double withdrawForFundTransfer(long accountId, double amount)
			throws BankAccountNotFoundException, LowBalanceException {
		double balance = bankAccount.getBalance(accountId);
		if (balance < 0) {
			throw new BankAccountNotFoundException("BankAccount doesn't exist....");
		} else if (balance - amount >= 0) {
			balance = balance - amount;
			bankAccount.updateBalance(accountId, balance);
			return balance;
		} else {
			throw new LowBalanceException("You don't have sufficient fund.");
		}
	}
}
