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
@Table(name = "Compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Compra;

    @Column(name = "Total_Producto")
    private String Total_Producto;

    @Column(name = "Total_Venta")
    private String Total_Venta;

    @Column(name = "Cantidad_Videos")
    private String Cantidad_Videos;
    /** Clave foranea de muchos a uno */
    @ManyToOne
    @JoinColumn(name = "id_Producto_FK")
    private Producto producto;

    public Long getId_Compra() {
        return id_Compra;
    }

    public void setId_Compra(Long id_Compra) {
        this.id_Compra = id_Compra;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Compra(Long id_Compra, String total_Producto, String total_Venta, String cantidad_Videos,
            Producto producto) {
        this.id_Compra = id_Compra;
        Total_Producto = total_Producto;
        Total_Venta = total_Venta;
        Cantidad_Videos = cantidad_Videos;
        this.producto = producto;
    }

    public Compra(String total_Producto, String total_Venta, String cantidad_Videos, Producto producto) {
        Total_Producto = total_Producto;
        Total_Venta = total_Venta;
        Cantidad_Videos = cantidad_Videos;
        this.producto = producto;
    }

    public Compra() {
    }

}
