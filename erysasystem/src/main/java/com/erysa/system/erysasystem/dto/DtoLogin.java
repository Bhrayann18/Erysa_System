package com.erysa.system.erysasystem.dto;

import lombok.Data;

@Data
public class DtoLogin {
    private String nombre;
    private String password;
	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
