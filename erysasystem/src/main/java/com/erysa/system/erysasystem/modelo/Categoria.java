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
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Categoria;

    @Column(name = "Nombre_Categoria")
    private String Nombre_Categoria;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos;

    public Long getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(Long id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public String getNombre_Categoria() {
        return Nombre_Categoria;
    }

    public void setNombre_Categoria(String nombre_Categoria) {
        Nombre_Categoria = nombre_Categoria;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Categoria(Long id_Categoria, String nombre_Categoria, List<Producto> productos) {
        this.id_Categoria = id_Categoria;
        Nombre_Categoria = nombre_Categoria;
        this.productos = productos;
    }

    public Categoria(String nombre_Categoria, List<Producto> productos) {
        Nombre_Categoria = nombre_Categoria;
        this.productos = productos;
    }

    public Categoria() {
    }

}
