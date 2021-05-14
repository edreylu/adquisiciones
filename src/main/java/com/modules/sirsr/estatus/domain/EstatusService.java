/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.estatus.domain;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.estatus.persistence.EstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Edward Reyes
 */
@Service
public class EstatusService {

	private final EstatusRepository estatusRepository;
	private Mensaje msg;

	@Autowired
	public EstatusService(EstatusRepository estatusRepository) {
		this.estatusRepository = estatusRepository;
	}

	public List<EstatusDTO> findAll() {
		return EstatusMapper.toEstatusDTOs(estatusRepository.findAll());
	}

	public EstatusDTO findById(int id) {
		Optional<Estatus> estatusOptional = estatusRepository.findById(id);
		EstatusDTO estatusDTO = EstatusMapper.toEstatusDTO(estatusOptional.get());
		return estatusDTO;
	}

	public Estatus estatusFindById(int id) {
		Optional<Estatus> estatusOptional = estatusRepository.findById(id);
		return estatusOptional.get();
	}

	public Mensaje save(EstatusDTO estatusDTO, int id) {
		try {
			msg = Mensaje.success("Estatuss agregados correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar estatuss por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje deleteById(int id) {
		try {
			msg = Mensaje.success("Eliminado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Eliminar.");
		}
		return msg;

	}

}
