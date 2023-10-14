package com.erysa.system.erysasystem.dto;

import javax.persistence.Column;

import lombok.Data;

@Data
public class DtoRegistro {

	private String nombre;

	private String apellido;

	private String numero_celular;

	private String direccion;

	private String email;
	
	private String password;

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNumero_celular() {
		return numero_celular;
	}

	public void setNumero_celular(String numero_celular) {
		this.numero_celular = numero_celular;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
