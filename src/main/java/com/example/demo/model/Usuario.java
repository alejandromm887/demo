package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;



@Entity
public class Usuario {
	
	@Id
	private int id;
	private String nombre;
	private String clave;
	
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "rol",referencedColumnName = "id")
			)
	private int rol;
	

	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
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
	

	public Usuario(int id, String nombre, String clave,int rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		this.rol = rol;
	}

	public Usuario(String nombre, String clave,int rol) {
		super();
		this.nombre = nombre;
		this.clave = clave;
		this.rol = rol;
	}

	public Usuario() {
		
	}
	
	
	
}
