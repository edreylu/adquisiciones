/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.unidadResponsable.domain;

import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsableMapper;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsableRepository;

import com.modules.sirsr.config.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edward Reyes
 */
@Service
public class UnidadResponsableService {

	private final UnidadResponsableRepository unidadResponsableRepository;
	private Mensaje msg;

	@Autowired
	public UnidadResponsableService(UnidadResponsableRepository unidadResponsableRepository) {
		this.unidadResponsableRepository = unidadResponsableRepository;
	}

	public List<UnidadResponsableDTO> findAll() {
		return UnidadResponsableMapper.toUnidadResponsableDTOs(unidadResponsableRepository.findAll());
	}

	public UnidadResponsableDTO findById(String id) {
		UnidadResponsableDTO unidadResponsableDTO = UnidadResponsableMapper
				.toUnidadResponsableDTO(unidadResponsableRepository.findById(id).get());
		return unidadResponsableDTO;
	}

	public UnidadResponsableDTO findByClaveUr(String claveUr) {
		UnidadResponsableDTO unidadResponsableDTO = UnidadResponsableMapper
				.toUnidadResponsableDTO(unidadResponsableRepository.findByClaveUr(claveUr));
		return unidadResponsableDTO;
	}

}
