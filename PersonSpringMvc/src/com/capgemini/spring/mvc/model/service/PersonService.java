package com.capgemini.spring.mvc.model.service;

import java.util.List;

import com.capgemini.spring.mvc.model.entity.Person;

public interface PersonService {

	public void addNew(Person person);

	public List<Person> getAll();

	public void update(Person person);

	public void delete(int personId);

	public Person getPerson(int personId);
}
