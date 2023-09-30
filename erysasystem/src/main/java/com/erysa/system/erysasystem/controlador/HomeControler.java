package com.erysa.system.erysasystem.controlador;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erysa.system.erysasystem.modelo.Producto;
import com.erysa.system.erysasystem.servicio.ProductoServicio;

@Controller
public class HomeControler {

	@Autowired
	private ProductoServicio productoServicio;

	@GetMapping("/administrador/home")
	public String home(Model model) {

		List<Producto> productos = productoServicio.findAll();
		model.addAttribute("productos", productos);

		return "home";
	}

	@GetMapping("productohome/{id}")
	public String verDetallesDelProducto(@PathVariable(value = "id") Integer id, Map<String, Object> modelo,
			RedirectAttributes flash) {
		Producto producto = productoServicio.findOne(id);
		if (producto == null) {
			flash.addFlashAttribute("error", "El Producto no existe en la base de datos");
			return "redirect:/listar";
		}
		modelo.put("producto", producto);
		modelo.put("titulo", "Detalles del producto " + producto.getNombre());
		return "productohome";
	}

}
