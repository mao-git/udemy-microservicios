package com.formacionbdi.springboot.app.item.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate clientRest;

	@Override
	public List<Item> findAll() {

		List<Producto> productos = Arrays
				.asList(clientRest.getForObject("http://servicio-productos/productos", Producto[].class));
		
		return productos.stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {

		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());

		Producto producto = clientRest.getForObject("http://servicio-productos/productos/{id}", Producto.class,
				pathVariables);

		return new Item(producto, cantidad);
	}
}
