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
@Table(name = "Entrada")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Entrada;

    @Column(name = "Fecha")
    private String Fecha;

    @Column(name = "Cantidad")
    private String Cantidad;

    @ManyToOne
    @JoinColumn(name = "id_Producto_FK")
    private Producto producto;

    public Long getId_Entrada() {
        return id_Entrada;
    }

    public void setId_Entrada(Long id_Entrada) {
        this.id_Entrada = id_Entrada;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Entrada(Long id_Entrada, String fecha, String cantidad, Producto producto) {
        this.id_Entrada = id_Entrada;
        Fecha = fecha;
        Cantidad = cantidad;
        this.producto = producto;
    }

    public Entrada(String fecha, String cantidad, Producto producto) {
        Fecha = fecha;
        Cantidad = cantidad;
        this.producto = producto;
    }

    public Entrada() {
    }

}
