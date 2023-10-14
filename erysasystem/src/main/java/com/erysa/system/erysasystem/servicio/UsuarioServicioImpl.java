package com.erysa.system.erysasystem.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erysa.system.erysasystem.modelo.Usuario;
import com.erysa.system.erysasystem.repositorio.UsuarioRepositorio;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioRepositorio usuarioRepository;

	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
}
