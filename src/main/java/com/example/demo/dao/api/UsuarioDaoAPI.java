package com.example.demo.dao.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Usuario;

public interface UsuarioDaoAPI extends JpaRepository<Usuario, Long> {

	Usuario findByNombre(String Nombre);
	
}
