package com.formacionbdi.springboot.app.productos.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.formacionbdi.springboot.app.productos.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

}
