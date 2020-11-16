package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.PersonModel;
import com.example.demo.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	PersonService service;
	
    @GetMapping("/person/{id}")
    public String getPerson(@PathVariable String id, Model model)
    {
    	PersonModel person = service.retrieve(Integer.parseInt(id));
		model.addAttribute("person", person);
        return "person";
    }

    @GetMapping("/person")
    public String getPersons(Model model)
    {
    	List<PersonModel> persons = service.retrieveAll();
		model.addAttribute("persons", persons);
    	return "persons";
    }
    
}