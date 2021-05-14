package com.modules.sirsr.producto.persistence;

import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.producto.domain.ProductoDTO;
import com.modules.sirsr.tipoProducto.persistence.TipoProductoMapper;
import com.modules.sirsr.unidadMedida.persistence.UnidadMedidaMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ProductoMapper {

	public static Producto toProducto(ProductoDTO productoDTO) {
		Producto producto = new Producto();
		producto.setIdProducto(productoDTO.getIdProducto());
		producto.setUnidadMedida(UnidadMedidaMapper.toUnidadMedida(productoDTO.getUnidadMedida()));
		producto.setTipoProducto(TipoProductoMapper.toTipoProducto(productoDTO.getTipoProducto()));
		producto.setCaracteristicas(productoDTO.getCaracteristicas());
		producto.setPrecioDeReferencia(productoDTO.getPrecioDeReferencia());
		producto.setFechaActualizacion(Date.from(Instant.now()));
		producto.setPermisoUr(1);
		producto.setEstatus(EstatusMapper.toEstatus(productoDTO.getEstatus()));
		return producto;
	}

	public static ProductoDTO toProductoDTO(Producto producto) {
		ProductoDTO productoDTO = new ProductoDTO();
		productoDTO.setIdProducto(producto.getIdProducto());
		productoDTO.setUnidadMedida(UnidadMedidaMapper.toUnidadMedidaDTO(producto.getUnidadMedida()));
		productoDTO.setTipoProducto(TipoProductoMapper.toTipoProductoDTO(producto.getTipoProducto()));
		productoDTO.setCaracteristicas(producto.getCaracteristicas());
		productoDTO.setPrecioDeReferencia(producto.getPrecioDeReferencia());
		productoDTO.setFechaActualizacion(producto.getFechaActualizacion());
		productoDTO.setPermisoUr(producto.getPermisoUr());
		productoDTO.setEstatus(EstatusMapper.toEstatusDTO(producto.getEstatus()));

		return productoDTO;
	}

	public static List<ProductoDTO> toProductoDTOs(List<Producto> productos) {
		if (Objects.isNull(productos)) {
			return null;
		}
		List<ProductoDTO> list = new ArrayList<>(productos.size());
		for (Producto producto : productos) {
			list.add(toProductoDTO(producto));
		}
		return list;
	}
}
