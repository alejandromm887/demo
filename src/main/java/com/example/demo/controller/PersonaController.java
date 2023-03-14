package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Persona;
import com.example.demo.service.api.PersonaServiceAPI;

import io.swagger.v3.oas.annotations.tags.Tag;

//import io.swagger.v3.oas.annotations.Operation;


@Controller
@Tag(name="Creacion de Personas", description = "API creada con el fin de poder crear, visualizar, modificar y eliminar personas.")
@RequestMapping("/home")

public class PersonaController {

	@Autowired
	private PersonaServiceAPI personaServiceAPI;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", personaServiceAPI.getAll());
		return "index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("persona", new Persona());
		return "save";
	}

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("persona", personaServiceAPI.get(id));
		} else {
			model.addAttribute("persona", new Persona());
		}
		return "save";
	}

	@PostMapping("/save")
	public String save(Persona persona, Model model) {
		personaServiceAPI.save(persona);
		return "redirect:/home/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		personaServiceAPI.delete(id);

		return "redirect:/home/";
	}

}
