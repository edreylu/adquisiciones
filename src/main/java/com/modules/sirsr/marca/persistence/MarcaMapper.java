package com.modules.sirsr.marca.persistence;

import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.marca.domain.MarcaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MarcaMapper {

	public static Marca toMarca(MarcaDTO marcaDTO) {
		Marca marca = new Marca();
		marca.setIdMarca(marcaDTO.getIdMarca());
		marca.setDescripcion(marcaDTO.getDescripcion());
		marca.setEstatus(EstatusMapper.toEstatus(marcaDTO.getEstatus()));
		return marca;
	}

	public static MarcaDTO toMarcaDTO(Marca marca) {
		MarcaDTO marcaDTO = new MarcaDTO();
		marcaDTO.setIdMarca(marca.getIdMarca());
		marcaDTO.setDescripcion(marca.getDescripcion());
		marcaDTO.setEstatus(EstatusMapper.toEstatusDTO(marca.getEstatus()));
		return marcaDTO;
	}

	public static List<MarcaDTO> toMarcaDTOs(List<Marca> marcas) {
		if (Objects.isNull(marcas)) {
			return null;
		}
		List<MarcaDTO> list = new ArrayList<>(marcas.size());
		for (Marca marca : marcas) {
			list.add(toMarcaDTO(marca));
		}
		return list;
	}
}
