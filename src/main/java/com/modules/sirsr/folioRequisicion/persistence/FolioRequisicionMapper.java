package com.modules.sirsr.folioRequisicion.persistence;

import java.util.ArrayList;
import java.util.List;

import com.modules.sirsr.folioRequisicion.domain.FolioRequisicionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FolioRequisicionMapper {

	ModelMapper modelMapper = new ModelMapper();

	public FolioRequisicionDTO toFolioRequisicionDTO(FolioRequisicion folioRequisicion) {
		FolioRequisicionDTO folioRequisicionDTO = modelMapper.map(folioRequisicion, FolioRequisicionDTO.class);
		return folioRequisicionDTO;
	}

	public FolioRequisicion toFolioRequisicion(FolioRequisicionDTO foliorequisicionDTO) {
		FolioRequisicion folioRequisicion = modelMapper.map(foliorequisicionDTO, FolioRequisicion.class);
		return folioRequisicion;
	}

	public List<FolioRequisicionDTO> toListaFolioRequisicioneDTO(List<FolioRequisicion> ListaFolioRequisiciones) {

		List<FolioRequisicionDTO> listaFolioRequisicionDTO = new ArrayList<>();

		for (FolioRequisicion folioRequisicion : ListaFolioRequisiciones) {
			listaFolioRequisicionDTO.add(toFolioRequisicionDTO(folioRequisicion));
		}

		return listaFolioRequisicionDTO;

	}

}
