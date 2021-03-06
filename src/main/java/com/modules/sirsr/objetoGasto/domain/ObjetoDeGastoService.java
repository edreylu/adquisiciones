/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.objetoGasto.domain;

import com.modules.sirsr.objetoGasto.persistence.ObjetoDeGasto;
import com.modules.sirsr.objetoGasto.persistence.ObjetoDeGastoMapper;
import com.modules.sirsr.objetoGasto.persistence.ObjetoDeGastoRepository;
import com.modules.sirsr.config.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 * @author Edward Reyes
 */
@Service
public class ObjetoDeGastoService {

	private final ObjetoDeGastoRepository objetoDeGastoRepository;
	private Mensaje msg;

	@Autowired
	public ObjetoDeGastoService(ObjetoDeGastoRepository objetoDeGastoRepository) {
		this.objetoDeGastoRepository = objetoDeGastoRepository;
	}

	public List<ObjetoDeGastoDTO> findAll() {
		return ObjetoDeGastoMapper.toObjetoDeGastoDTOs(objetoDeGastoRepository.findAll());
	}

	public ObjetoDeGastoDTO findById(String id) {
		Optional<ObjetoDeGasto> objetoDeGastoOptional = objetoDeGastoRepository.findById(id);
		ObjetoDeGastoDTO objetoDeGastoDTO = ObjetoDeGastoMapper.toObjetoDeGastoDTO(objetoDeGastoOptional.get());
		return objetoDeGastoDTO;
	}

	public Mensaje save(ObjetoDeGastoDTO objetoDeGastoDTO) {
		return msg;
	}

	public Mensaje update(ObjetoDeGastoDTO objetoDeGastoDTO, int id) {
		return msg;
	}

	public Mensaje deleteById(int id) {
		return msg;
	}

}
