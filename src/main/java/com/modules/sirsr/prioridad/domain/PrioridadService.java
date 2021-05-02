/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.prioridad.domain;

import com.modules.sirsr.prioridad.persistence.Prioridad;
import com.modules.sirsr.prioridad.persistence.PrioridadMapper;
import com.modules.sirsr.prioridad.persistence.PrioridadRepository;
import com.modules.sirsr.config.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Edward Reyes
 */
@Service
public class PrioridadService {

	private final PrioridadRepository prioridadRepository;
	private Mensaje msg;

	@Autowired
	public PrioridadService(PrioridadRepository prioridadRepository) {
		this.prioridadRepository = prioridadRepository;
	}

	public List<PrioridadDTO> findAll() {
		return PrioridadMapper.toPrioridadDTOs(prioridadRepository.findAll());
	}

	public PrioridadDTO findById(int id) {
		Optional<Prioridad> prioridadOptional = prioridadRepository.findById(id);
		PrioridadDTO prioridadDTO = PrioridadMapper.toPrioridadDTO(prioridadOptional.get());
		return prioridadDTO;
	}

	public Mensaje save(PrioridadDTO prioridadDTO) {
		try {

			prioridadRepository.save(PrioridadMapper.toPrioridad(prioridadDTO));
			msg = Mensaje.success("Agregado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje update(PrioridadDTO prioridadDTO, int id) {
		try {
			Optional<Prioridad> prioridadFound = prioridadRepository.findById(id);
			Prioridad prioridad = PrioridadMapper.setToUpdate(prioridadFound.get(), prioridadDTO);
			prioridadRepository.save(prioridad);
			msg = Mensaje.success("Actualizado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Actualizar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje deleteById(int id) {
		try {
			prioridadRepository.deleteById(id);
			msg = Mensaje.success("Eliminado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Eliminar por que hay usuarios asociados a rol.");
		}
		return msg;

	}

}
