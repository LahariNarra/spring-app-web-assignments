package com.capgemini.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.spring.mvc.model.entity.Person;
import com.capgemini.spring.mvc.model.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@RequestMapping("/")
	public String inputPage() {
		return "index";
	}

	@RequestMapping("/new")
	public String addNewPerson(@RequestParam("personId") int personId,
					@RequestParam("personName") String personName) {
		
		Person person = new Person(personId,personName);
		service.addNew(person);
		return "success";
		
	}
}
