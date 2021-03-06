package com.modules.sirsr.unidadMedida.persistence;

import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.unidadMedida.domain.UnidadMedidaDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UnidadMedidaMapper {

	public static UnidadMedida toUnidadMedida(UnidadMedidaDTO unidadMedidaDTO) {
		UnidadMedida unidadMedida = new UnidadMedida();
		unidadMedida.setIdUnidadMedida(unidadMedidaDTO.getIdUnidadMedida());
		unidadMedida.setClaveUnidad(unidadMedidaDTO.getClaveUnidad());
		unidadMedida.setDescripcion(unidadMedidaDTO.getDescripcion());
		unidadMedida.setNombre(unidadMedidaDTO.getNombre());
		unidadMedida.setEstatus(EstatusMapper.toEstatus(unidadMedidaDTO.getEstatus()));
		return unidadMedida;
	}

	public static UnidadMedidaDTO toUnidadMedidaDTO(UnidadMedida unidadMedida) {
		UnidadMedidaDTO unidadMedidaDTO = new UnidadMedidaDTO();
		unidadMedidaDTO.setIdUnidadMedida(unidadMedida.getIdUnidadMedida());
		unidadMedidaDTO.setClaveUnidad(unidadMedida.getClaveUnidad());
		unidadMedidaDTO.setDescripcion(unidadMedida.getDescripcion());
		unidadMedidaDTO.setNombre(unidadMedida.getNombre());
		unidadMedidaDTO.setEstatus(EstatusMapper.toEstatusDTO(unidadMedida.getEstatus()));
		return unidadMedidaDTO;
	}

	public static List<UnidadMedidaDTO> toUnidadMedidaDTOs(List<UnidadMedida> unidadMedidas) {
		if (Objects.isNull(unidadMedidas)) {
			return null;
		}
		List<UnidadMedidaDTO> list = new ArrayList<>(unidadMedidas.size());
		for (UnidadMedida unidadMedida : unidadMedidas) {
			list.add(toUnidadMedidaDTO(unidadMedida));
		}
		return list;
	}
}
