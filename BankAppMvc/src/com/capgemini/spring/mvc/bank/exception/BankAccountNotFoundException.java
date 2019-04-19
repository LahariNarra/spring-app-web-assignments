package com.capgemini.spring.mvc.bank.exception;

public class BankAccountNotFoundException extends Exception {

	public BankAccountNotFoundException(String message) {
		super(message);
	}

}
