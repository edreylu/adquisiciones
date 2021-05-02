package com.modules.sirsr.marca.persistence;

import com.modules.sirsr.marca.domain.MarcaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class MarcaMapper {
	private final ModelMapper modelMapper = new ModelMapper();

	public Marca toMarca(MarcaDTO marcaDTO) {
		Marca marca = modelMapper.map(marcaDTO, Marca.class);
		return marca;
	}

	public MarcaDTO toMarcaDTO(Marca marca) {
		MarcaDTO marcaDTO = modelMapper.map(marca, MarcaDTO.class);
		return marcaDTO;
	}

	public List<MarcaDTO> toMarcaDTOs(List<Marca> marcas) {
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
