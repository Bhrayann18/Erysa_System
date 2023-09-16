package com.erysa.system.erysasystem.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.erysa.system.erysasystem.modelo.Categoria;
import com.erysa.system.erysasystem.repositorio.CategoriaRepositorio;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaRepositorio categoriaRepository;
	
	@GetMapping("/categorias")
	public String listarCategoria(Model modelo) {
		List<Categoria> listarCategorias = categoriaRepository.findAll();
		modelo.addAttribute("listarCategorias",  listarCategorias);
		return "categorias";
	}
	
	@GetMapping("/categorias/nuevo")
	public String mostrarFormularioDeNuevaCategoria(Model modelo) {
		modelo.addAttribute("categoria", new Categoria());
		return "categoria_formulario";
	}

	@PostMapping("/categorias/guardar")
	public String guardarCategoria(Categoria categoria){
		categoriaRepository.save(categoria);
		return "redirect:/categorias";

	}

}
