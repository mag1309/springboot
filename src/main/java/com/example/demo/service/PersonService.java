package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PersonModel;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService { 
	
	@Autowired
	private PersonRepository repository;

	public List<PersonModel> retrieveAll()
	{    
		return (List<PersonModel>) repository.retrieveAll(); 
	}
	
	public PersonModel retrieve(int id)
	{  
	  return (PersonModel) repository.retrieve(id); 
	}
}