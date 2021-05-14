/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.unidadMedida.domain;

import com.modules.sirsr.unidadMedida.persistence.UnidadMedida;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.unidadMedida.persistence.UnidadMedidaMapper;
import com.modules.sirsr.unidadMedida.persistence.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 * @author Edward Reyes
 */
@Service
public class UnidadMedidaService {

	private final UnidadMedidaRepository unidadMedidaRepository;
	private Mensaje msg;

	@Autowired
	public UnidadMedidaService(UnidadMedidaRepository unidadMedidaRepository) {
		this.unidadMedidaRepository = unidadMedidaRepository;
	}

	public List<UnidadMedidaDTO> findAll() {
		return UnidadMedidaMapper.toUnidadMedidaDTOs(unidadMedidaRepository.findAll());
	}

	public UnidadMedidaDTO findById(int id) {
		Optional<UnidadMedida> unidadMedidaOptional = unidadMedidaRepository.findById(id);
		UnidadMedidaDTO unidadMedidaDTO = UnidadMedidaMapper.toUnidadMedidaDTO(unidadMedidaOptional.get());
		return unidadMedidaDTO;
	}

	public Mensaje save(UnidadMedidaDTO unidadMedidaDTO) {
		return msg;
	}

	public Mensaje update(UnidadMedidaDTO unidadMedidaDTO, int id) {
		return msg;
	}

	public Mensaje deleteById(int id) {
		return msg;
	}

}
