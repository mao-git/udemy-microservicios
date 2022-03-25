package com.formacionbdi.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.app.item.models.Producto;

//@FeignClient(name = "servicio-productos", url = "localhost:8001") --> se elimina por config ribbon en properties
@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {

	@GetMapping("/productos")
	public List<Producto> listar();

	@GetMapping("/productos/{id}")
	public Producto detalle(@PathVariable("id") Long id);
}
