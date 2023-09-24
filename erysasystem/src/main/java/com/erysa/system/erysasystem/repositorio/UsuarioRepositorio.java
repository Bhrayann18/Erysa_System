package com.erysa.system.erysasystem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erysa.system.erysasystem.modelo.Usuario;

/** Se determina ese atributo unico*/
/** Se toma la id de la entidad y su tipo que en este caso es Long */

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);
}
