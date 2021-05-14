package com.modules.sirsr.requisicion.persistence;

import com.modules.sirsr.producto.persistence.ProductoMapper;
import com.modules.sirsr.requisicion.domain.DetalleRequisicionDTO;
import org.springframework.stereotype.Component;

import java.util.*;

public class DetalleRequisicionMapper {

	public static DetalleRequisicion toDetalleRequisicion(DetalleRequisicionDTO detalleRequisicionDTO) {

		if (Objects.isNull(detalleRequisicionDTO)) {
			return null;
		}
		DetalleRequisicion detalleRequisicion = new DetalleRequisicion();
		detalleRequisicion.setIdDetalleRequisicion(detalleRequisicionDTO.getIdDetalleRequisicion());
		detalleRequisicion.setIdRequisicion(detalleRequisicionDTO.getIdRequisicion());
		detalleRequisicion.setProducto(ProductoMapper.toProducto(detalleRequisicionDTO.getProducto()));
		detalleRequisicion.setRequisicion(RequisicionMapper.toRequisicion(detalleRequisicionDTO.getRequisicion()));
		detalleRequisicion.setCantidadAutorizada(detalleRequisicionDTO.getCantidadAutorizada());
		detalleRequisicion.setCantidadSolicitada(detalleRequisicionDTO.getCantidadSolicitada());
		detalleRequisicion.setPrecioUnitario(detalleRequisicionDTO.getPrecioUnitario());

		return detalleRequisicion;
	}

	public static DetalleRequisicionDTO toDetalleRequisicionDTO(DetalleRequisicion detalleRequisicion) {

		if (Objects.isNull(detalleRequisicion)) {
			return null;
		}

		DetalleRequisicionDTO detalleRequisicionDTO = new DetalleRequisicionDTO();
		detalleRequisicionDTO.setIdDetalleRequisicion(detalleRequisicion.getIdDetalleRequisicion());
		detalleRequisicionDTO.setIdRequisicion(detalleRequisicion.getIdRequisicion());
		detalleRequisicionDTO.setProducto(ProductoMapper.toProductoDTO(detalleRequisicion.getProducto()));
		detalleRequisicionDTO.setCantidadAutorizada(0);
		detalleRequisicionDTO.setCantidadSolicitada(detalleRequisicion.getCantidadSolicitada());
		detalleRequisicionDTO.setPrecioUnitario(detalleRequisicion.getPrecioUnitario());

		return detalleRequisicionDTO;
	}

	public static List<DetalleRequisicionDTO> toDetalleRequisicionDTOs(List<DetalleRequisicion> detalleRequisiciones) {
		if (Objects.isNull(detalleRequisiciones)) {
			return null;
		}
		List<DetalleRequisicionDTO> list = new ArrayList<>(detalleRequisiciones.size());
		for (DetalleRequisicion detalleRequisicion : detalleRequisiciones) {
			list.add(toDetalleRequisicionDTO(detalleRequisicion));
		}
		return list;
	}

	public static Set<DetalleRequisicionDTO> toDetalleRequisicionDTOsSet(Set<DetalleRequisicion> detalleRequisiciones) {
		if (Objects.isNull(detalleRequisiciones)) {
			return null;
		}
		Set<DetalleRequisicionDTO> list = new HashSet<>(detalleRequisiciones.size());
		for (DetalleRequisicion detalleRequisicion : detalleRequisiciones) {
			list.add(toDetalleRequisicionDTO(detalleRequisicion));
		}
		return list;
	}

	/*
	 * public DetalleRequisicion setToUpdate(DetalleRequisicionDTO
	 * detalleRequisicionDTO) { DetalleRequisicion detalleRequisicionFound = new
	 * DetalleRequisicion(); Producto producto =
	 * productoRepository.findById(detalleRequisicionDTO.getProducto().getIdProducto
	 * ()).get(); Requisicion requisicion =
	 * requisicionRepository.findById(detalleRequisicionDTO.getIdRequisicion()).get(
	 * ); detalleRequisicionFound.setIdDetalleRequisicion(detalleRequisicionDTO.
	 * getIdDetalleRequisicion());
	 * detalleRequisicionFound.setRequisicion(requisicion);
	 * detalleRequisicionFound.setProducto(producto);
	 * detalleRequisicionFound.setCantidadSolicitada(detalleRequisicionDTO.
	 * getCantidadSolicitada()); return detalleRequisicionFound; }
	 */

}
