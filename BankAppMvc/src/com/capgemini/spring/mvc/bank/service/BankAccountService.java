package com.capgemini.spring.mvc.bank.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.capgemini.spring.mvc.bank.exception.BankAccountNotFoundException;
import com.capgemini.spring.mvc.bank.exception.LowBalanceException;
import com.capgemini.spring.mvc.model.BankAccount;

public interface BankAccountService {
	
public boolean addNewBankAccount(BankAccount account);
	
	public boolean deleteBankAccount(long accountId) throws BankAccountNotFoundException;

	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType);

	public List<BankAccount> findAllBankAccountsDetails();

	public BankAccount searchAccountDetails(long accountId) throws BankAccountNotFoundException;

	public double checkBalance(long accountId) throws BankAccountNotFoundException;

	public double withdraw(long accountId, double amount) throws BankAccountNotFoundException, LowBalanceException;

	public double deposit(long accountId, double amount) throws BankAccountNotFoundException;

	public double fundTransfer(long fromAccount, long toAccount, double amount)
			throws BankAccountNotFoundException, LowBalanceException;
}
