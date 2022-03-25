package com.formacionbdi.springboot.app.productos.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.entity.Producto;
import com.formacionbdi.springboot.app.productos.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {

	@Autowired
	private ProductoService productoService;

	@Autowired
	private Environment env;

	@Value("${server.port}")
	private Integer port;

	@GetMapping
	public List<Producto> listar() {
		return productoService.findAll().stream().map(producto -> {
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
//			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public Producto detalle(@PathVariable("id") Long id) {
		Producto producto = productoService.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
//		producto.setPort(port);
		return producto;
	}
}
