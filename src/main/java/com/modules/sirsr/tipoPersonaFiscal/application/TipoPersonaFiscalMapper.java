package com.modules.sirsr.tipoPersonaFiscal.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.modules.sirsr.tipoPersonaFiscal.domain.TipoPersonaFiscal;

@Component
public class TipoPersonaFiscalMapper {

	ModelMapper modelMapper = new ModelMapper();

	public TipoPersonaFiscalDTO toTipoPersonaFiscalDTO(TipoPersonaFiscal tipoPersonaFiscal) {
		TipoPersonaFiscalDTO tipoPersonaFiscalDTO = modelMapper.map(tipoPersonaFiscal, TipoPersonaFiscalDTO.class);
		return tipoPersonaFiscalDTO;
	}

	public List<TipoPersonaFiscalDTO> toTipoPersonaFiscalDTOs(List<TipoPersonaFiscal> tiposPersonaFiscal) {
		if (Objects.isNull(tiposPersonaFiscal)) {
			return null;
		}
		List<TipoPersonaFiscalDTO> list = new ArrayList<>(tiposPersonaFiscal.size());
		for (TipoPersonaFiscal tipoPersonaFiscal : tiposPersonaFiscal) {
			list.add(toTipoPersonaFiscalDTO(tipoPersonaFiscal));
		}
		return list;
	}

	public TipoPersonaFiscal toTipoPersonaFiscal(TipoPersonaFiscalDTO tipoPersonaFiscalDTO) {
		TipoPersonaFiscal tipoPersonaFiscal = modelMapper.map(tipoPersonaFiscalDTO, TipoPersonaFiscal.class);
		return tipoPersonaFiscal;
	}

	public TipoPersonaFiscal toUpdatePersonaFiscal(TipoPersonaFiscal tipoPersonaFiscal,
			TipoPersonaFiscalDTO tipoPersonaFiscalDTO) {
		tipoPersonaFiscal.setDescripcion(tipoPersonaFiscalDTO.getDescripcion());
		return tipoPersonaFiscal;
	}

}
