/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.datosPersonales.domain;

import com.modules.sirsr.datosPersonales.persistence.DatosPersonales;
import com.modules.sirsr.datosPersonales.persistence.DatosPersonalesMapper;
import com.modules.sirsr.datosPersonales.persistence.DatosPersonalesRepository;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edward Reyes
 */
@Service
public class DatosPersonalesService {

	private final DatosPersonalesRepository datosPersonalesRepository;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	public DatosPersonalesService(DatosPersonalesRepository datosPersonalesRepository) {
		this.datosPersonalesRepository = datosPersonalesRepository;
	}

	public List<DatosPersonalesDTO> findAll() {
		return DatosPersonalesMapper.toUnidadResponsableDTOs(datosPersonalesRepository.findAll());
	}

	public List<DatosPersonalesDTO> findByNoPersonal(int noPersonal) {
		return DatosPersonalesMapper.toUnidadResponsableDTOs(datosPersonalesRepository.findByNoPersonal(noPersonal));
	}

	public List<DatosPersonalesDTO> findByNombrePersonal(String nombrePersonal) {
		return DatosPersonalesMapper.toUnidadResponsableDTOs(datosPersonalesRepository
				.findByNombreIgnoreCaseContainingOrApellidoPaternoIgnoreCaseContainingOrApellidoMaternoIgnoreCaseContaining(
						nombrePersonal, nombrePersonal, nombrePersonal));
	}

	public DatosPersonales findByCorreo(String email) {
		return datosPersonalesRepository.findByCorreo(email);
	}

	public DatosPersonalesDTO findById(int id) {
		DatosPersonales personal = datosPersonalesRepository.findById(id).get();
		return DatosPersonalesMapper.toPersonalDTO(personal);
	}

}
