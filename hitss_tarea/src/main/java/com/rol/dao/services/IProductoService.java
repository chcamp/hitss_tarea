package com.rol.dao.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rol.entities.Producto;

@Service
public interface IProductoService {
	
	public List<Producto> findAll();
	
	public Producto save(Producto producto);

}
