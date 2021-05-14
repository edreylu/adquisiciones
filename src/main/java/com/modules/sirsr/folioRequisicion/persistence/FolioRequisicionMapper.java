package com.modules.sirsr.folioRequisicion.persistence;

import java.util.ArrayList;
import java.util.List;

import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.folioRequisicion.domain.FolioRequisicionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

public class FolioRequisicionMapper {

	public static FolioRequisicionDTO toFolioRequisicionDTO(FolioRequisicion folioRequisicion) {
		FolioRequisicionDTO folioRequisicionDTO = new FolioRequisicionDTO();
		folioRequisicionDTO.setAnio(folioRequisicion.getAnio());
		folioRequisicionDTO.setConsecutivo(folioRequisicion.getConsecutivo());
		folioRequisicionDTO.setEstatus(EstatusMapper.toEstatusDTO(folioRequisicion.getEstatus()));
		return folioRequisicionDTO;
	}

	public static FolioRequisicion toFolioRequisicion(FolioRequisicionDTO foliorequisicionDTO) {
		FolioRequisicion folioRequisicion = new FolioRequisicion();
		folioRequisicion.setAnio(foliorequisicionDTO.getAnio());
		folioRequisicion.setConsecutivo(foliorequisicionDTO.getConsecutivo());
		folioRequisicion.setEstatus(EstatusMapper.toEstatus(foliorequisicionDTO.getEstatus()));
		return folioRequisicion;
	}

	public static List<FolioRequisicionDTO> toListaFolioRequisicioneDTO(List<FolioRequisicion> ListaFolioRequisiciones) {

		List<FolioRequisicionDTO> listaFolioRequisicionDTO = new ArrayList<>();

		for (FolioRequisicion folioRequisicion : ListaFolioRequisiciones) {
			listaFolioRequisicionDTO.add(toFolioRequisicionDTO(folioRequisicion));
		}

		return listaFolioRequisicionDTO;

	}

}
