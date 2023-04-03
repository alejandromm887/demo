package com.example.demo.dto;

public class UsuarioRegistroDTO {
	private int id;
	private String nombre;
	private String clave;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public UsuarioRegistroDTO(int id, String nombre, String clave) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
	}
	public UsuarioRegistroDTO(String nombre, String clave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
	}
	public UsuarioRegistroDTO() {
		
	}
	
}
