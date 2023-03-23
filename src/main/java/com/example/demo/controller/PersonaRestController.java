package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.service.api.PersonaServiceAPI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;




@RestController
@RequestMapping(value = "/api/v1/home")
@CrossOrigin("*")
@Tag(name="Personas", description = "Metodos CRUD para creación de personas")
public class PersonaRestController {

	@Autowired
	private PersonaServiceAPI personaServiceAPI;

	@GetMapping(value = "/all")
	@Operation(summary = "Obtiene todas personas", description = "Se obtienen todas las personas que se crearon previamente")
	public List<Persona> getAll() {
		return personaServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	@Operation(summary = "Buscar persona por ID", description = "Se obtienen datos de una persona en específico")
	public Persona find(@PathVariable Long id) {
		return personaServiceAPI.get(id);
	}

	@PostMapping(value = "/save")
	@Operation(summary = "Crea una persona", description = "Crea una nueva persona")
	public ResponseEntity<Persona> save(@RequestBody @Validated @Parameter(description = "Objeto que contiene los atributos a ingresar y que son obligatorios.") Persona persona){
		
		Persona obj = personaServiceAPI.save(persona);
		
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	@Operation(summary = "Eliminar persona por ID", description = "Se elimina una persona en específico")
	public ResponseEntity<Persona> delete(@PathVariable Long id) {
		Persona persona = personaServiceAPI.get(id);
		if (persona != null) {
			personaServiceAPI.delete(id);
		} else {
			return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}

}
