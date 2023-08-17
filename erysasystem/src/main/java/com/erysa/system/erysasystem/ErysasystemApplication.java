package com.erysa.system.erysasystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.erysa.system.erysasystem.modelo.Producto;
import com.erysa.system.erysasystem.repositorio.ProductoRepositorio;

@SpringBootApplication
public class ErysasystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ErysasystemApplication.class, args);
	}

	@Autowired
	private ProductoRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {

	}

}

