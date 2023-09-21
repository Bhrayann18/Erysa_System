package com.erysa.system.erysasystem.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Nombre", nullable = false, length = 50)
	private String Nombre;

	private String imagen;

	@Column(name = "Precio", nullable = false, length = 50)
	private String Precio;

	@Column(name = "Stock", nullable = false, length = 50)
	private String Stock;

	@Column(name = "Descripcion", nullable = false, length = 50)
	private String Descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@OneToMany(mappedBy = "producto")
	private List<Compra> compra;

	@OneToMany(mappedBy = "producto")
	private List<Entrada> entrada;

	@OneToMany(mappedBy = "producto")
	private List<Carrito> carrito;

	public Producto() {
	}

	public Producto(Integer id, String nombre, String imagen, String precio, String stock, String descripcion,
			Categoria categoria) {
		this.id = id;
		Nombre = nombre;
		this.imagen = imagen;
		Precio = precio;
		Stock = stock;
		Descripcion = descripcion;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPrecio() {
		return Precio;
	}

	public void setPrecio(String precio) {
		Precio = precio;
	}

	public String getStock() {
		return Stock;
	}

	public void setStock(String stock) {
		Stock = stock;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", Nombre=" + Nombre + ", imagen=" + imagen + ", Precio=" + Precio + ", Stock="
				+ Stock + ", Descripcion=" + Descripcion + ", categoria=" + categoria + "]";
	}

}
