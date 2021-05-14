/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.marca.domain;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.marca.persistence.Marca;
import com.modules.sirsr.marca.persistence.MarcaMapper;
import com.modules.sirsr.marca.persistence.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Edward Reyes
 */
@Service
public class MarcaService {

	private final MarcaRepository marcaRepository;
	private Mensaje msg;

	@Autowired
	public MarcaService(MarcaRepository marcaRepository) {
		this.marcaRepository = marcaRepository;
	}

	public List<MarcaDTO> findAll() {
		return MarcaMapper.toMarcaDTOs(marcaRepository.findAll());
	}

	public MarcaDTO findById(int id) {
		Optional<Marca> marcaOptional = marcaRepository.findById(id);
		MarcaDTO marcaDTO = MarcaMapper.toMarcaDTO(marcaOptional.get());
		return marcaDTO;
	}

	public Mensaje save(MarcaDTO marcaDTO) {
		return msg;
	}

	public Mensaje update(MarcaDTO marcaDTO, int id) {
		return msg;
	}

	public Mensaje deleteById(int id) {
		return msg;
	}

}
