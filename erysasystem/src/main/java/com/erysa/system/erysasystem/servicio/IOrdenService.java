package com.erysa.system.erysasystem.servicio;

import java.util.List;
import java.util.Optional;

import com.erysa.system.erysasystem.modelo.Orden;
import com.erysa.system.erysasystem.modelo.Usuario;

public interface IOrdenService {

	List<Orden> findAll();

	Optional<Orden> findById(Integer id);

	Orden save(Orden orden);

	String generarNumeroOrden();

	List<Orden> findByUsuario(Usuario usuario);

}
