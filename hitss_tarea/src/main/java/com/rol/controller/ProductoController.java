package com.rol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rol.dao.services.IProductoService;
import com.rol.entities.Producto;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	IProductoService iProductoService;
	
	//Listar procutos:
	@GetMapping("/productos")
	public List<Producto> productos(){
		return iProductoService.findAll();
	}
	
	
	//insertar producto
	@PostMapping("productos")
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
		
		Producto nuevoProducto = iProductoService.save(producto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
	}

}



