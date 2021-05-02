package com.modules.sirsr.tipoDocumento.persistence;

import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class TipoDocumentoMapper {

	public static TipoDocumentoDTO toTipoDocumentoDTO(TipoDocumento tipoDocumento) {
		TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
		tipoDocumentoDTO.setIdTipoDocumento(tipoDocumento.getIdTipoDocumento());
		tipoDocumentoDTO.setDescripcion(tipoDocumento.getDescripcion());
		tipoDocumentoDTO.setEstatus(EstatusMapper.toEstatusDTO(tipoDocumento.getEstatus()));
		return tipoDocumentoDTO;
	}

	public static TipoDocumento toTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO) {
		TipoDocumento tipoDocumento = new TipoDocumento();
		tipoDocumento.setIdTipoDocumento(tipoDocumentoDTO.getIdTipoDocumento());
		tipoDocumento.setDescripcion(tipoDocumentoDTO.getDescripcion());
		tipoDocumento.setEstatus(EstatusMapper.toEstatus(tipoDocumentoDTO.getEstatus()));
		return tipoDocumento;
	}

	public static List<TipoDocumentoDTO> toTipoDocumentoDTOs(List<TipoDocumento> tipoDocumentos) {
		if (Objects.isNull(tipoDocumentos)) {
			return null;
		}
		List<TipoDocumentoDTO> list = new ArrayList<>(tipoDocumentos.size());
		for (TipoDocumento tipoDocumento : tipoDocumentos) {
			list.add(toTipoDocumentoDTO(tipoDocumento));
		}
		return list;
	}

}
