package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PersonModel;

@Repository
public class PersonRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * 
	 */
	public List<PersonModel> retrieveAll() throws DataAccessException
	{
		String query = "SELECT p.id, p.first_name, p.last_name, p.email, p.phone FROM test.person p";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
		
		List<PersonModel> persons = new ArrayList<PersonModel>();
		for (Map<String, Object> map:list)
		{
			PersonModel person = new PersonModel();
			person.setId(((Integer)map.get("id")).toString());
			person.setFirstName((String)map.get("first_name"));
			person.setLastName((String)map.get("last_name"));
			person.setEmail((String)map.get("email"));
			person.setPhone((String)map.get("phone"));
			
			persons.add(person);
		}
		return persons;
	}
	
	/*
	 * 
	 */
	public PersonModel retrieve(int id)
	{
		String query = "SELECT p.id, p.first_name, p.last_name, p.email, p.phone FROM test.person p WHERE p.id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(query, id);
		
		PersonModel person = new PersonModel();
		person.setId(((Integer)map.get("id")).toString());
		person.setFirstName((String)map.get("first_name"));
		person.setLastName((String)map.get("last_name"));
		person.setEmail((String)map.get("email"));
		person.setPhone((String)map.get("phone"));
		return person;
	}
}