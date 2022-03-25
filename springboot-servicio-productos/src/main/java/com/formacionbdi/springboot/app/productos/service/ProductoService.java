package com.formacionbdi.springboot.app.productos.service;

import java.util.List;

import com.formacionbdi.springboot.app.productos.entity.Producto;

public interface ProductoService {
	
	public List<Producto> findAll();
	
	public Producto findById(Long id);
}
