package com.erysa.system.erysasystem.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Carrito;

    @Column(name = "Total_Producto")
    private String Total_Producto;

    @Column(name = "Total_Venta")
    private String Total_Venta;

    @Column(name = "Cantidad_Videos")
    private String Cantidad_Videos;
    /** Clave foranea de muchos a uno */
    @ManyToOne()
    @JoinColumn(name = "id_Usuario_FK")
    private Usuario usuario;
    /** Clave foranea de muchos a uno */
    @ManyToOne()
    @JoinColumn(name = "id_Curso_FK")
    private Curso curso;
    /** Clave foranea de muchos a uno */
    @ManyToOne()
    @JoinColumn(name = "id_Producto_FK")
    private Producto producto;
    /** Clave foranea de muchos a uno */
    @ManyToOne()
    @JoinColumn(name = "id_Entrega_FK")
    private Entrega entrega;

    public Long getId_Carrito() {
        return id_Carrito;
    }

    public void setId_Carrito(Long id_Carrito) {
        this.id_Carrito = id_Carrito;
    }

    public String getTotal_Producto() {
        return Total_Producto;
    }

    public void setTotal_Producto(String total_Producto) {
        Total_Producto = total_Producto;
    }

    public String getTotal_Venta() {
        return Total_Venta;
    }

    public void setTotal_Venta(String total_Venta) {
        Total_Venta = total_Venta;
    }

    public String getCantidad_Videos() {
        return Cantidad_Videos;
    }

    public void setCantidad_Videos(String cantidad_Videos) {
        Cantidad_Videos = cantidad_Videos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Carrito(Long id_Carrito, String total_Producto, String total_Venta, String cantidad_Videos, Usuario usuario,
            Producto producto, Entrega entrega) {
        this.id_Carrito = id_Carrito;
        Total_Producto = total_Producto;
        Total_Venta = total_Venta;
        Cantidad_Videos = cantidad_Videos;
        this.usuario = usuario;
        this.producto = producto;
        this.entrega = entrega;
    }

    public Carrito(String total_Producto, String total_Venta, String cantidad_Videos, Usuario usuario,
            Producto producto, Entrega entrega) {
        Total_Producto = total_Producto;
        Total_Venta = total_Venta;
        Cantidad_Videos = cantidad_Videos;
        this.usuario = usuario;
        this.producto = producto;
        this.entrega = entrega;
    }

    public Carrito() {
    }

}
