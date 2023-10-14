package com.erysa.system.erysasystem.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erysa.system.erysasystem.modelo.DetalleOrden;
import com.erysa.system.erysasystem.modelo.Orden;
import com.erysa.system.erysasystem.modelo.Producto;
import com.erysa.system.erysasystem.modelo.Usuario;
import com.erysa.system.erysasystem.servicio.DetalleOrdenServicio;
import com.erysa.system.erysasystem.servicio.OrdenServicio;
import com.erysa.system.erysasystem.servicio.ProductoServicio;
import com.erysa.system.erysasystem.servicio.UsuarioServicio;

@Controller
@RequestMapping("/")
public class HomeControler {

	private final Logger log = LoggerFactory.getLogger(HomeControler.class);

	@Autowired
	private UsuarioServicio usuarioServicio;
	@Autowired
	private ProductoServicio productoServicio;

	@Autowired
	private OrdenServicio ordenServicio;

	@Autowired
	private DetalleOrdenServicio detalleOrdenServicio;

	List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

	Orden orden = new Orden();

	@GetMapping("")
	public String home(Model model, HttpSession session) {

		log.info("Sesion del usuario: {}", session.getAttribute("idusuario"));

		model.addAttribute("productos", productoServicio.findAll());

		// session
		model.addAttribute("sesion", session.getAttribute("idusuario"));

		return "usuario/home";
	}

	@GetMapping("productohome/{id}")
	public String productoHome(@PathVariable Integer id, Model model) {
		log.info("Id producto enviado como parámetro {}", id);
		Producto producto = new Producto();
		Optional<Producto> productoOptional = productoServicio.get(id);
		producto = productoOptional.get();

		model.addAttribute("producto", producto);

		return "usuario/productohome";
	}

	@PostMapping("/cart")
	public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {
		DetalleOrden detalleOrden = new DetalleOrden();
		Producto producto = new Producto();
		double sumaTotal = 0;

		Optional<Producto> optionalProducto = productoServicio.get(id);
		log.info("Producto añadido: {}", optionalProducto.get());
		log.info("Cantidad: {}", cantidad);
		producto = optionalProducto.get();

		detalleOrden.setCantidad(cantidad);
		detalleOrden.setPrecio(producto.getPrecio());
		detalleOrden.setNombre(producto.getNombre());
		detalleOrden.setTotal(producto.getPrecio()*cantidad);
		detalleOrden.setProducto(producto);

		// validar que le producto no se añada 2 veces
		Integer idProducto = producto.getId();
		boolean ingresado = detalles.stream().anyMatch(p -> p.getProducto().getId() == idProducto);

		if (!ingresado) {
			detalles.add(detalleOrden);
		}

		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

		orden.setTotal(sumaTotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);

		return "usuario/carrito";
	}

	@GetMapping("/delete/cart/{id}")
	public String deleteProductoCart(@PathVariable Integer id, Model model) {

		// lista nueva de prodcutos
		List<DetalleOrden> ordenesNueva = new ArrayList<DetalleOrden>();

		for (DetalleOrden detalleOrden : detalles) {
			if (detalleOrden.getProducto().getId() != id) {
				ordenesNueva.add(detalleOrden);
			}
		}

		// poner la nueva lista con los productos restantes
		detalles = ordenesNueva;

		double sumaTotal = 0;
		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

		orden.setTotal(sumaTotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);

		return "usuario/carrito";
	}

	@GetMapping("/getCart")
	public String getCart(Model model, HttpSession session) {

		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);

		// sesion
		model.addAttribute("sesion", session.getAttribute("id"));
		return "/usuario/carrito";
	}

	@GetMapping("/order")
	public String order(Model model) {

		Usuario usuario = usuarioServicio.findById(1).get();

		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
		model.addAttribute("usuario", usuario);

		return "usuario/resumenorden";
	}

	// guardar la orden
	@GetMapping("/saveOrder")
	public String saveOrder() {
		Date fechaCreacion = new Date();
		orden.setFechaCreacion(fechaCreacion);
		orden.setNumero(ordenServicio.generarNumeroOrden());

		// usuario
		Usuario usuario = usuarioServicio.findById(1).get();

		orden.setUsuario(usuario);
		ordenServicio.save(orden);

		// guardar detalles
		for (DetalleOrden dt : detalles) {
			dt.setOrden(orden);
			detalleOrdenServicio.save(dt);
		}

		/// limpiar lista y orden
		orden = new Orden();
		detalles.clear();

		return "redirect:/";
	}

	@PostMapping("/search")
	public String searchProduct(@RequestParam String nombre, Model model) {
		log.info("Nombre del producto: {}", nombre);
		List<Producto> productos = productoServicio.findAll().stream().filter(p -> p.getNombre().contains(nombre))
				.collect(Collectors.toList());
		model.addAttribute("productos", productos);
		return "usuario/home";
	}

}
