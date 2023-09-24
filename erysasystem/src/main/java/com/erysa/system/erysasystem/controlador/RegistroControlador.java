package com.erysa.system.erysasystem.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.erysa.system.erysasystem.servicio.UsuarioServicio;

@Controller
public class RegistroControlador {
	/**
	 * Se importa de servicio para determinar el metodo segun corresponda
	 */
	@Autowired
	private UsuarioServicio servicio;

	/**
	 * Se retorna login
	 */
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}

	/**
	 * Aqui una vez se realice el login retornara la pagina de inicio
	 */
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "index";
	}
}
