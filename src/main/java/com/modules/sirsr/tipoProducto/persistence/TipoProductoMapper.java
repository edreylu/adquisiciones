package com.modules.sirsr.tipoProducto.persistence;

import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.objetoGasto.persistence.ObjetoDeGastoMapper;
import com.modules.sirsr.tipoProducto.domain.TipoProductoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TipoProductoMapper {

	public static TipoProductoDTO toTipoProductoDTO(TipoProducto tipoProducto) {
		if (Objects.isNull(tipoProducto)) {
			return null;
		}
		TipoProductoDTO tipoProductoDTO = new TipoProductoDTO();
		tipoProductoDTO.setIdTipoProducto(tipoProducto.getIdTipoProducto());
		tipoProductoDTO.setDescripcion(tipoProducto.getDescripcion());
		tipoProductoDTO.setEstatus(EstatusMapper.toEstatusDTO(tipoProducto.getEstatus()));
		tipoProductoDTO.setObjetoDeGasto(ObjetoDeGastoMapper.toObjetoDeGastoDTO(tipoProducto.getObjetoGasto()));
		return tipoProductoDTO;
	}

	public static List<TipoProductoDTO> toTipoProductoDTOs(List<TipoProducto> tipoProductoes) {
		if (Objects.isNull(tipoProductoes)) {
			return null;
		}
		List<TipoProductoDTO> list = new ArrayList<>(tipoProductoes.size());
		for (TipoProducto tipoProducto : tipoProductoes) {
			list.add(toTipoProductoDTO(tipoProducto));
		}
		return list;
	}

	public static TipoProducto toTipoProducto(TipoProductoDTO tipoProductoDTO) {
		if (Objects.isNull(tipoProductoDTO)) {
			return null;
		}
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto.setIdTipoProducto(tipoProductoDTO.getIdTipoProducto());
		tipoProducto.setDescripcion(tipoProductoDTO.getDescripcion());
		tipoProducto.setEstatus(EstatusMapper.toEstatus(tipoProductoDTO.getEstatus()));
		tipoProducto.setObjetoGasto(ObjetoDeGastoMapper.toObjetoDeGasto(tipoProductoDTO.getObjetoDeGasto()));
		return tipoProducto;
	}

	public static TipoProducto setToUpdate(TipoProducto tipoProductoFound, TipoProductoDTO tipoProductoDTO) {
		return tipoProductoFound;
	}

}
