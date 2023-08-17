package com.erysa.system.erysasystem.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.erysa.system.erysasystem.modelo.Producto;

public interface ProductoServicio {

	public List<Producto> findAll();

	public Page<Producto> findAll(Pageable pageable);

	public void save(Producto producto);

	public Producto findOne(Long id);

	public void delete(Long id);
}
