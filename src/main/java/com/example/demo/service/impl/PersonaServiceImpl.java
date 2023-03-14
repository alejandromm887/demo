package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.commons.GenericServiceImpl;
import com.example.demo.dao.api.PersonaDaoAPI;
import com.example.demo.model.Persona;
import com.example.demo.service.api.PersonaServiceAPI;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaServiceAPI {

	@Autowired
	private PersonaDaoAPI personaDaoAPI;
	
	@Override
	public CrudRepository<Persona, Long> getDao() {
		return personaDaoAPI;
	}

}
