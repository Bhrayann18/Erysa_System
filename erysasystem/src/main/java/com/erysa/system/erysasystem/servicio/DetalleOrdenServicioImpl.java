package com.erysa.system.erysasystem.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erysa.system.erysasystem.modelo.DetalleOrden;

@Service
public class DetalleOrdenServicioImpl implements DetalleOrdenServicio {
	
	@Autowired
	private DetalleOrdenServicioImpl detalleOrdenRepositorio;

	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {
		return detalleOrdenRepositorio.save(detalleOrden);
	}
}
