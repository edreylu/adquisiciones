package com.modules.sirsr.capitulo.persistence;

import com.modules.sirsr.capitulo.domain.CapituloDTO;
import com.modules.sirsr.estatus.persistence.EstatusMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CapituloMapper {

	public static Capitulo toCapitulo(CapituloDTO capituloDTO) {
		Capitulo capitulo = new Capitulo();
		capitulo.setClaveCapitulo(capituloDTO.getClaveCapitulo());
		capitulo.setDescripcion(capituloDTO.getDescripcion());
		capitulo.setDefinicion(capituloDTO.getDefinicion());
		capitulo.setFechaInicio(capituloDTO.getFechaInicio());
		capitulo.setFechaFinal(capituloDTO.getFechaFinal());
		capitulo.setEstatus(EstatusMapper.toEstatus(capituloDTO.getEstatus()));
		return capitulo;
	}

	public static CapituloDTO toCapituloDTO(Capitulo capitulo) {
		CapituloDTO capituloDTO = new CapituloDTO();
		capituloDTO.setClaveCapitulo(capitulo.getClaveCapitulo());
		capituloDTO.setDescripcion(capitulo.getDescripcion());
		capituloDTO.setDefinicion(capitulo.getDefinicion());
		capituloDTO.setFechaInicio(capitulo.getFechaInicio());
		capituloDTO.setFechaFinal(capitulo.getFechaFinal());
		capituloDTO.setEstatus(EstatusMapper.toEstatusDTO(capitulo.getEstatus()));

		return capituloDTO;
	}

	public static List<CapituloDTO> toCapituloDTOs(List<Capitulo> capitulos) {
		if (Objects.isNull(capitulos)) {
			return null;
		}
		List<CapituloDTO> list = new ArrayList<>(capitulos.size());
		for (Capitulo capitulo : capitulos) {
			list.add(toCapituloDTO(capitulo));
		}
		return list;
	}
}
