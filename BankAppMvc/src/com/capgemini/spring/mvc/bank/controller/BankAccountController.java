package com.capgemini.spring.mvc.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.spring.mvc.bank.service.BankAccountService;
import com.capgemini.spring.mvc.model.BankAccount;

@Controller
@RequestMapping("/bank")
public class BankAccountController {
	@Autowired
	private BankAccountService service;



	@RequestMapping("/new")
	public String inputPage() {
		return "register";

	}
	
	@RequestMapping("/newaccount")
	public String accountPage(@RequestParam("accountHolderName") String name, @RequestParam("accountType") String type, @RequestParam("accountBalance") double amount) {
	
		BankAccount account = new BankAccount(name, type, amount);
		service.addNewBankAccount(account);
		return "index";

	}
	@RequestMapping("/with")
	public String withdrawPage() {
		return "withdraw";

	}

}
