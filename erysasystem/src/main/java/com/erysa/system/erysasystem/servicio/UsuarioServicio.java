package com.erysa.system.erysasystem.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.erysa.system.erysasystem.controlador.dto.UsuarioRegistroDTO;
import com.erysa.system.erysasystem.modelo.Orden;
import com.erysa.system.erysasystem.modelo.Producto;
import com.erysa.system.erysasystem.modelo.Usuario;

public interface UsuarioServicio {

	List<Usuario> findAll();

	Optional<Usuario> findById(Integer id);

	Usuario save(Usuario usuario);

	Optional<Usuario> findByEmail(String email);

}