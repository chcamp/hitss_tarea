package com.rol.dao;

import org.springframework.data.repository.CrudRepository;

import com.rol.entities.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
	

}
