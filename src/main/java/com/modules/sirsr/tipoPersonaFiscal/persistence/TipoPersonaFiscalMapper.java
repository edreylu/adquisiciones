package com.modules.sirsr.tipoPersonaFiscal.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.modules.sirsr.tipoPersonaFiscal.domain.TipoPersonaFiscalDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

public class TipoPersonaFiscalMapper {

	public static TipoPersonaFiscalDTO toTipoPersonaFiscalDTO(TipoPersonaFiscal tipoPersonaFiscal) {
		TipoPersonaFiscalDTO tipoPersonaFiscalDTO = new TipoPersonaFiscalDTO();
		tipoPersonaFiscalDTO.setIdTipoPersonaFiscal(tipoPersonaFiscal.getIdTipoPersonaFiscal());
		tipoPersonaFiscalDTO.setDescripcion(tipoPersonaFiscal.getDescripcion());
		tipoPersonaFiscalDTO.setIdEstatus(tipoPersonaFiscal.getIdEstatus());
		return tipoPersonaFiscalDTO;
	}

	public static List<TipoPersonaFiscalDTO> toTipoPersonaFiscalDTOs(List<TipoPersonaFiscal> tiposPersonaFiscal) {
		if (Objects.isNull(tiposPersonaFiscal)) {
			return null;
		}
		List<TipoPersonaFiscalDTO> list = new ArrayList<>(tiposPersonaFiscal.size());
		for (TipoPersonaFiscal tipoPersonaFiscal : tiposPersonaFiscal) {
			list.add(toTipoPersonaFiscalDTO(tipoPersonaFiscal));
		}
		return list;
	}

	public static TipoPersonaFiscal toTipoPersonaFiscal(TipoPersonaFiscalDTO tipoPersonaFiscalDTO) {
		TipoPersonaFiscal tipoPersonaFiscal = new TipoPersonaFiscal();
		tipoPersonaFiscal.setIdTipoPersonaFiscal(tipoPersonaFiscalDTO.getIdTipoPersonaFiscal());
		tipoPersonaFiscal.setDescripcion(tipoPersonaFiscalDTO.getDescripcion());
		tipoPersonaFiscal.setIdEstatus(tipoPersonaFiscalDTO.getIdEstatus());
		return tipoPersonaFiscal;
	}

	public static TipoPersonaFiscal toUpdatePersonaFiscal(TipoPersonaFiscal tipoPersonaFiscal,
			TipoPersonaFiscalDTO tipoPersonaFiscalDTO) {
		tipoPersonaFiscal.setDescripcion(tipoPersonaFiscalDTO.getDescripcion());
		return tipoPersonaFiscal;
	}

}
