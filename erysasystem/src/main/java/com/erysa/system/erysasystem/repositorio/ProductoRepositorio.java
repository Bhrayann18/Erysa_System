package com.erysa.system.erysasystem.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.erysa.system.erysasystem.modelo.Producto;

/** Se toma la id de la entidad y su tipo que en este caso es integer */
@Repository
public interface ProductoRepositorio extends PagingAndSortingRepository<Producto, Integer> {

}
