package com.modules.sirsr.partidaGastoGenerica.persistence;

import com.modules.sirsr.concepto.persistence.ConceptoMapper;
import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.partidaGastoGenerica.domain.PartidaGastoGenericaDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PartidaGastoGenericaMapper {

	public static PartidaGastoGenerica toPartidaGastoGenerica(PartidaGastoGenericaDTO partidaGastoGenericaDTO) {
		PartidaGastoGenerica partidaGastoGenerica = new PartidaGastoGenerica();
		partidaGastoGenerica.setClaveGenerica(partidaGastoGenericaDTO.getClaveGenerica());
		partidaGastoGenerica.setDescripcion(partidaGastoGenericaDTO.getDescripcion());
		partidaGastoGenerica.setDefinicion(partidaGastoGenericaDTO.getDefinicion());
		partidaGastoGenerica.setFechaInicio(partidaGastoGenericaDTO.getFechaInicio());
		partidaGastoGenerica.setFechaFinal(partidaGastoGenericaDTO.getFechaFinal());
		partidaGastoGenerica.setConcepto(ConceptoMapper.toConcepto(partidaGastoGenericaDTO.getConcepto()));
		partidaGastoGenerica.setEstatus(EstatusMapper.toEstatus(partidaGastoGenericaDTO.getEstatus()));
		return partidaGastoGenerica;
	}

	public static PartidaGastoGenericaDTO toPartidaGastoGenericaDTO(PartidaGastoGenerica partidaGastoGenerica) {
		PartidaGastoGenericaDTO partidaGastoGenericaDTO = new PartidaGastoGenericaDTO();
		partidaGastoGenericaDTO.setClaveGenerica(partidaGastoGenerica.getClaveGenerica());
		partidaGastoGenericaDTO.setDescripcion(partidaGastoGenerica.getDescripcion());
		partidaGastoGenericaDTO.setDefinicion(partidaGastoGenerica.getDefinicion());
		partidaGastoGenericaDTO.setFechaInicio(partidaGastoGenerica.getFechaInicio());
		partidaGastoGenericaDTO.setFechaFinal(partidaGastoGenerica.getFechaFinal());
		partidaGastoGenericaDTO.setConcepto(ConceptoMapper.toConceptoDTO(partidaGastoGenerica.getConcepto()));
		partidaGastoGenericaDTO.setEstatus(EstatusMapper.toEstatusDTO(partidaGastoGenerica.getEstatus()));

		return partidaGastoGenericaDTO;
	}

	public static List<PartidaGastoGenericaDTO> toPartidaGastoGenericaDTOs(
			List<PartidaGastoGenerica> partidaGastoGenericas) {
		if (Objects.isNull(partidaGastoGenericas)) {
			return null;
		}
		List<PartidaGastoGenericaDTO> list = new ArrayList<>(partidaGastoGenericas.size());
		for (PartidaGastoGenerica partidaGastoGenerica : partidaGastoGenericas) {
			list.add(toPartidaGastoGenericaDTO(partidaGastoGenerica));
		}
		return list;
	}
}
