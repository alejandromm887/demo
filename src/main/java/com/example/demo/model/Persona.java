package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import io.swagger.v3.oas.annotations.media.Schema;


@Entity
@Schema(name="Persona", description="Caracteristica de persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description="Identificacion unica de persona", maxLength=50)
	private Long id;
	
	@Column
	@NonNull
	@Schema(description="Nombre de la persona", maxLength=50)
	private String nombre;
	
	@Column
	@NonNull
	@Schema(description="Apellido de la persona", maxLength=50)
	private String apellido;
	
	@Column
	@NonNull
	@Schema(description="Direccion de la persona", maxLength=50)
	private String direccion;
	
	@Column
	@NonNull
	@Schema(description="Telefono de la persona", maxLength=50)
	private String telefono;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
