package com.erysa.system.erysasystem.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Venta;

    @Column(name = "Fecha")
    private String Fecha;

    @Column(name = "Precio_Total")
    private String Precio_Total;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entrega> entrega;

    public Long getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(Long id_Venta) {
        this.id_Venta = id_Venta;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getPrecio_Total() {
        return Precio_Total;
    }

    public void setPrecio_Total(String precio_Total) {
        Precio_Total = precio_Total;
    }

    public List<Entrega> getEntrega() {
        return entrega;
    }

    public void setEntrega(List<Entrega> entrega) {
        this.entrega = entrega;
    }

    public Venta(Long id_Venta, String fecha, String precio_Total, List<Entrega> entrega) {
        this.id_Venta = id_Venta;
        Fecha = fecha;
        Precio_Total = precio_Total;
        this.entrega = entrega;
    }

    public Venta(String fecha, String precio_Total, List<Entrega> entrega) {
        Fecha = fecha;
        Precio_Total = precio_Total;
        this.entrega = entrega;
    }

    public Venta() {
    }

}
