package com.erysa.system.erysasystem.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.erysa.system.erysasystem.servicio.ProductoServicio;
import com.erysa.system.erysasystem.servicio.UsuarioServicio;

@Controller
public class AdministradorController {

	@Autowired
	private UsuarioServicio usuarioServicio;

	@GetMapping("/administrador/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
		return "usuarios";
	}
}
