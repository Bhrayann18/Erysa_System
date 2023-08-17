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
@Table(name = "Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Curso;

    @Column(name = "Titulo")
    private String Titulo;

    @Column(name = "Miniatura")
    private String Miniatura;

    @Column(name = "Descripcion")
    private String Descripcion;

    @Column(name = "Precio")
    private String Precio;

    @Column(name = "Duracion")
    private String Duracion;

    @Column(name = "Cantidad_videos")
    private String Cantidad_videos;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> carrito;

    public Long getId_Curso() {
        return id_Curso;
    }

    public void setId_Curso(Long id_Curso) {
        this.id_Curso = id_Curso;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getMiniatura() {
        return Miniatura;
    }

    public void setMiniatura(String miniatura) {
        Miniatura = miniatura;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String duracion) {
        Duracion = duracion;
    }

    public String getCantidad_videos() {
        return Cantidad_videos;
    }

    public void setCantidad_videos(String cantidad_videos) {
        Cantidad_videos = cantidad_videos;
    }

    public List<Carrito> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Carrito> carrito) {
        this.carrito = carrito;
    }

    public Curso(Long id_Curso, String titulo, String miniatura, String descripcion, String precio, String duracion,
            String cantidad_videos, List<Carrito> carrito) {
        this.id_Curso = id_Curso;
        Titulo = titulo;
        Miniatura = miniatura;
        Descripcion = descripcion;
        Precio = precio;
        Duracion = duracion;
        Cantidad_videos = cantidad_videos;
        this.carrito = carrito;
    }

    public Curso(String titulo, String miniatura, String descripcion, String precio, String duracion,
            String cantidad_videos, List<Carrito> carrito) {
        Titulo = titulo;
        Miniatura = miniatura;
        Descripcion = descripcion;
        Precio = precio;
        Duracion = duracion;
        Cantidad_videos = cantidad_videos;
        this.carrito = carrito;
    }

    public Curso() {
    }

}
