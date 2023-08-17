package com.erysa.system.erysasystem.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erysa.system.erysasystem.modelo.Producto;
import com.erysa.system.erysasystem.servicio.ProductoServicio;
import com.erysa.system.erysasystem.util.PageRender;
import com.erysa.system.erysasystem.util.reportes.ProductoExporterExcel;
import com.erysa.system.erysasystem.util.reportes.ProductoExporterPDF;
import com.lowagie.text.DocumentException;

@Controller
public class ProductoControlador {

	@Autowired
	private ProductoServicio productoServicio;

	@GetMapping("/ver/{id}")
	public String verDetallesDelProducto(@PathVariable(value = "id") Long id, Map<String, Object> modelo,
			RedirectAttributes flash) {
		Producto producto = productoServicio.findOne(id);
		if (producto == null) {
			flash.addFlashAttribute("error", "El Producto no existe en la base de datos");
			return "redirect:/listar";
		}
		modelo.put("producto", producto);
		modelo.put("titulo", "Detalles del producto " + producto.getNombre());
		return "ver";
	}

	@GetMapping({ "/", "/listar", "" })
	public String listarProductos(@RequestParam(name = "page", defaultValue = "0") int page, Model modelo) {
		Pageable pageRequest = PageRequest.of(page, 4);
		Page<Producto> productos = productoServicio.findAll(pageRequest);
		PageRender<Producto> pageRender = new PageRender<>("/listar", productos);

		modelo.addAttribute("titulo", "Listado de productos");
		modelo.addAttribute("productos", productos);
		modelo.addAttribute("page", pageRender);

		return "listar";
	}

	@GetMapping("/form")
	public String mostrarFormularioDeRegistrarProducto(Map<String, Object> modelo) {
		Producto producto = new Producto();
		modelo.put("producto", producto);
		modelo.put("titulo", "Registro de productos");
		return "form";
	}

	@PostMapping("/form")
	public String guardarProducto(@Valid Producto producto, BindingResult result, Model modelo,
			RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			modelo.addAttribute("titulo", "Registro de producto");
			return "form";
		}

		String mensaje = (producto.getId() != null) ? "El producto ha sido editato con exito"
				: "Producto registrado con exito";

		productoServicio.save(producto);
		status.setComplete();
		flash.addFlashAttribute("success", mensaje);
		return "redirect:/listar";

	}

	@GetMapping("/form/{id}")
	public String editarProducto(@PathVariable(value = "id") Long id, Map<String, Object> modelo,
			RedirectAttributes flash) {
		Producto producto = null;
		if (id > 0) {
			producto = productoServicio.findOne(id);
			if (producto == null) {
				flash.addFlashAttribute("error", "El ID del producto no existe en la base de datos");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del producto no puede ser cero");
			return "redirect:/listar";
		}

		modelo.put("producto", producto);
		modelo.put("titulo", "Edición de producto");
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			productoServicio.delete(id);
			flash.addFlashAttribute("success", "Empleado eliminado con exito");
		}
		return "redirect:/listar";
	}

	@GetMapping("/exportarPDF")
	public void exportarListadoDeProductosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());

		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Empleados_" + fechaActual + ".pdf";

		response.setHeader(cabecera, valor);

		List<Producto> productos = productoServicio.findAll();

		ProductoExporterPDF exporter = new ProductoExporterPDF(productos);
		exporter.exportar(response);
	}

	@GetMapping("/exportarExcel")
	public void exportarListadoDeProductosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());

		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Empleados_" + fechaActual + ".xlsx";

		response.setHeader(cabecera, valor);

		List<Producto> productos = productoServicio.findAll();

		ProductoExporterExcel exporter = new ProductoExporterExcel(productos);
		exporter.exportar(response);
	}

}
