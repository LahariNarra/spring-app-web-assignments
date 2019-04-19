package com.capgemini.spring.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.spring.mvc.model.dao.PersonDao;
import com.capgemini.spring.mvc.model.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao dao;
	
	public void addNew(Person person) {
		dao.addNew(person);
	}

	public List<Person> getAll() {
		return null;
	}

	public void update(Person person) {

	}

	public void delete(int personId) {

	}

	public Person getPerson(int personId) {
		return null;
	}

}
