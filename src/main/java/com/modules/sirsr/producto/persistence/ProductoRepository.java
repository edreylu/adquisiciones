package com.modules.sirsr.producto.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByIdTipoProductoIn(List<Integer> tiposProducto);
    List<Producto> findAllByIdEstatus(Integer idEstatus);
}
