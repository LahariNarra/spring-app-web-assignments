package com.capgemini.spring.mvc.bank.exception;

public class LowBalanceException extends Exception {

	public LowBalanceException(String message) {
		super(message);
	}

}
