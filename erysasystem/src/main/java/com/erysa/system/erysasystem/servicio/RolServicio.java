package com.erysa.system.erysasystem.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.erysa.system.erysasystem.modelo.Usuario;

public interface RolServicio {

	@Autowired
	List<Usuario> findAll();

	Optional<Usuario> findById(Integer id);

	Usuario save(Usuario usuario);

	Optional<Usuario> findByEmail(String email);

}
