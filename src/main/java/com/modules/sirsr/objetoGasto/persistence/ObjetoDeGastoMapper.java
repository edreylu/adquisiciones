package com.modules.sirsr.objetoGasto.persistence;

import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.objetoGasto.domain.ObjetoDeGastoDTO;
import com.modules.sirsr.partidaGastoGenerica.persistence.PartidaGastoGenericaMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ObjetoDeGastoMapper {

	public static ObjetoDeGasto toObjetoDeGasto(ObjetoDeGastoDTO objetoDeGastoDTO) {
		ObjetoDeGasto objetoDeGasto = new ObjetoDeGasto();
		objetoDeGasto.setObjetoGasto(objetoDeGastoDTO.getObjetoGasto());
		objetoDeGasto.setDefinicion(objetoDeGastoDTO.getDefinicion());
		objetoDeGasto.setFechaInicio(objetoDeGastoDTO.getFechaInicio());
		objetoDeGasto.setFechaFinal(objetoDeGastoDTO.getFechaFinal());
		objetoDeGasto.setDescripcion(objetoDeGastoDTO.getDescripcion());
		objetoDeGasto.setPartidaGastoGenerica(
				PartidaGastoGenericaMapper.toPartidaGastoGenerica(objetoDeGastoDTO.getClaveGenerica()));
		objetoDeGasto.setEstatus(EstatusMapper.toEstatus(objetoDeGastoDTO.getEstatus()));
		return objetoDeGasto;
	}

	public static ObjetoDeGastoDTO toObjetoDeGastoDTO(ObjetoDeGasto objetoDeGasto) {
		ObjetoDeGastoDTO objetoDeGastoDTO = new ObjetoDeGastoDTO();
		objetoDeGastoDTO.setObjetoGasto(objetoDeGasto.getObjetoGasto());
		objetoDeGastoDTO.setDefinicion(objetoDeGasto.getDefinicion());
		objetoDeGastoDTO.setFechaInicio(objetoDeGasto.getFechaInicio());
		objetoDeGastoDTO.setFechaFinal(objetoDeGasto.getFechaFinal());
		objetoDeGastoDTO.setDescripcion(objetoDeGasto.getDescripcion());
		objetoDeGastoDTO.setClaveGenerica(
				PartidaGastoGenericaMapper.toPartidaGastoGenericaDTO(objetoDeGasto.getPartidaGastoGenerica()));
		objetoDeGastoDTO.setEstatus(EstatusMapper.toEstatusDTO(objetoDeGasto.getEstatus()));
		return objetoDeGastoDTO;
	}

	public static List<ObjetoDeGastoDTO> toObjetoDeGastoDTOs(List<ObjetoDeGasto> objetosDeGasto) {
		if (Objects.isNull(objetosDeGasto)) {
			return null;
		}
		List<ObjetoDeGastoDTO> list = new ArrayList<>(objetosDeGasto.size());
		for (ObjetoDeGasto objetoDeGasto : objetosDeGasto) {
			list.add(toObjetoDeGastoDTO(objetoDeGasto));
		}
		return list;
	}
}
