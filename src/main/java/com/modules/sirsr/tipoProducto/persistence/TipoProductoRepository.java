package com.modules.sirsr.tipoProducto.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Integer> {
	List<TipoProducto> findByObjetoGastoStrIn(List<String> objetos);

	List<TipoProducto> findByObjetoGastoStr(String objeto);
}
