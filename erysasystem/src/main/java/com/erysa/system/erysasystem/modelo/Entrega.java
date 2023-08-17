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
@Table(name = "Entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Entrega;

    @Column(name = "Direccion")
    private String Direccion;

    @Column(name = "Ciudad")
    private String Ciudad;

    @Column(name = "Barrio")
    private String Barrio;

    @ManyToOne()
    @JoinColumn(name = "id_Venta_FK")
    private Venta venta;

    @ManyToOne()
    @JoinColumn(name = "id_Usuario_FK")
    private Usuario usuario;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> carrito;

    public Long getId_Entrega() {
        return id_Entrega;
    }

    public void setId_Entrega(Long id_Entrega) {
        this.id_Entrega = id_Entrega;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getBarrio() {
        return Barrio;
    }

    public void setBarrio(String barrio) {
        Barrio = barrio;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Carrito> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Carrito> carrito) {
        this.carrito = carrito;
    }

    public Entrega(Long id_Entrega, String direccion, String ciudad, String barrio, Venta venta, Usuario usuario,
            List<Carrito> carrito) {
        this.id_Entrega = id_Entrega;
        Direccion = direccion;
        Ciudad = ciudad;
        Barrio = barrio;
        this.venta = venta;
        this.usuario = usuario;
        this.carrito = carrito;
    }

    public Entrega(String direccion, String ciudad, String barrio, Venta venta, Usuario usuario,
            List<Carrito> carrito) {
        Direccion = direccion;
        Ciudad = ciudad;
        Barrio = barrio;
        this.venta = venta;
        this.usuario = usuario;
        this.carrito = carrito;
    }

    public Entrega() {
    }

}
