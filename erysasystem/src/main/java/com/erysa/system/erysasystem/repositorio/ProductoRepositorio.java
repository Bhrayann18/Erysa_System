package com.erysa.system.erysasystem.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.erysa.system.erysasystem.modelo.Producto;

@Repository
public interface ProductoRepositorio extends PagingAndSortingRepository<Producto, Long> {

}
