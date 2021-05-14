package com.modules.sirsr.subTipoProducto.persistence;

import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.subTipoProducto.domain.SubTipoProductoDTO;
import com.modules.sirsr.tipoDocumento.persistence.TipoDocumentoMapper;
import com.modules.sirsr.tipoProducto.persistence.TipoProductoMapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubTipoProductoMapper {

	public static SubTipoProductoDTO toSubTipoProductoDTO(SubTipoProducto subTipoProducto) {
		SubTipoProductoDTO subTipoProductoDTO = new SubTipoProductoDTO();
		subTipoProductoDTO.setIdSubtipoProducto(subTipoProducto.getIdSubtipoProducto());
		subTipoProductoDTO.setDescripcion(subTipoProducto.getDescripcion());
		subTipoProductoDTO.setEstatus(EstatusMapper.toEstatusDTO(subTipoProducto.getEstatus()));
		subTipoProductoDTO.setTipoProducto(TipoProductoMapper.toTipoProductoDTO(subTipoProducto.getTipoProducto()));
		return subTipoProductoDTO;
	}

	public static List<SubTipoProductoDTO> toSubTipoProductoDTOs(List<SubTipoProducto> subTipoProductos) {
		if (Objects.isNull(subTipoProductos)) {
			return null;
		}
		List<SubTipoProductoDTO> list = new ArrayList<>(subTipoProductos.size());
		for (SubTipoProducto subTipoProducto : subTipoProductos) {
			list.add(toSubTipoProductoDTO(subTipoProducto));
		}
		return list;
	}

}
