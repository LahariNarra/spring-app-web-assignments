package com.capgemini.spring.mvc.bank.dao;

import java.util.List;

import com.capgemini.spring.mvc.model.BankAccount;

public interface BankAccountDao {

	public boolean addNewBankAccount(BankAccount account);
	
	public boolean deleteBankAccount(long accountId);

	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType);
	
	public List<BankAccount> findAllBankAccountsDetails();
	
	public double getBalance(long accountId);

	public void updateBalance(long accountId, double newBalance);

	public BankAccount searchAccountDetails(long accountId) ;

}
