package com.erysa.system.erysasystem.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    private Long id;

    @Column(name = "Nombre", nullable = false, length = 50)
    private String Nombre;

    @Column(name = "Imagen", nullable = false, length = 50)
    private String imagen;

    @Column(name = "Precio", nullable = false, length = 50)
    private String Precio;

    @Column(name = "Stock", nullable = false, length = 50)
    private String Stock;

    @Column(name = "Descripcion", nullable = false, length = 50)
    private String Descripcion;

    @ManyToOne
    @JoinColumn(name = "id_Categoria_FK")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compra> compra;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entrada> entrada;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> carrito;

    public Producto() {
    }

	public Producto(Long id, String nombre, String imagen, String precio, String stock, String descripcion) {
		super();
		this.id = id;
		Nombre = nombre;
		this.imagen = imagen;
		Precio = precio;
		Stock = stock;
		Descripcion = descripcion;
	}

	public Producto(String nombre, String imagen, String precio, String stock, String descripcion) {
		super();
		Nombre = nombre;
		this.imagen = imagen;
		Precio = precio;
		Stock = stock;
		Descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
				+ Stock + ", Descripcion=" + Descripcion + "]";
	}

	
}
