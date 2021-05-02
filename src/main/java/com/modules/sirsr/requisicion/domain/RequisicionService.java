/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestariaDTO;
import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestariaService;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.estatus.domain.EstatusService;
import com.modules.sirsr.requisicion.persistence.Requisicion;
import com.modules.sirsr.requisicion.persistence.RequisicionMapper;
import com.modules.sirsr.requisicion.persistence.RequisicionRepository;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.solicitud.domain.SolicitudService;

/**
 *
 * @author Edward Reyes
 */
@Service
public class RequisicionService {

	private final RequisicionRepository requisicionRepository;
	private final SolicitudService solicitudService;
	private final EstatusService estatusService;
	private final ClavePresupuestariaService clavePresupuestariaService;
	private SolicitudDTO solicitudDTO;
	private EstatusDTO estatusDTO;
	private ClavePresupuestariaDTO clavePresupuestariaDTO;
	private Mensaje msg;

	@Autowired
	public RequisicionService(RequisicionRepository requisicionRepository, SolicitudService solicitudService,
			EstatusService estatusService, ClavePresupuestariaService clavePresupuestariaService) {
		this.requisicionRepository = requisicionRepository;
		this.solicitudService = solicitudService;
		this.estatusService = estatusService;
		this.clavePresupuestariaService = clavePresupuestariaService;
	}

	public List<RequisicionDTO> findAll() {
		return RequisicionMapper.toRequisicionDTOs(requisicionRepository.findAll());
	}

	public RequisicionDTO findById(int id) {
		Optional<Requisicion> requisicionOptional = requisicionRepository.findById(id);
		RequisicionDTO requisicionDTO = RequisicionMapper.toRequisicionDTO(requisicionOptional.get());
		return requisicionDTO;
	}

	public List<RequisicionDTO> findByIdSolicitud(int id) {
		List<RequisicionDTO> requisicionesDTO = RequisicionMapper
				.toRequisicionDTOs(requisicionRepository.findByIdSolicitud(id));
		return requisicionesDTO;
	}

	@Transactional
	public Mensaje save(RequisicionDTO requisicionDTO, int idSolicitud) {
		try {
			System.out.println(requisicionDTO.toString());
			solicitudDTO = solicitudService.findById(idSolicitud);
			clavePresupuestariaDTO = clavePresupuestariaService
					.findById(requisicionDTO.getClavePresupuestaria().getIdClavePresup());
			estatusDTO = estatusService.findById(1);
			requisicionDTO.setSolicitud(solicitudDTO);
			requisicionDTO.setClavePresupuestaria(clavePresupuestariaDTO);
			requisicionDTO.setEstatus(estatusDTO);
			requisicionRepository.save(RequisicionMapper.toRequisicion(requisicionDTO));

			msg = Mensaje.success("Agregado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}

	@Transactional
	public Mensaje saveDetalles(RequisicionDTO requisicionDTO, int id) {
		try {

			msg = Mensaje.success("Detalles agregados correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar detalles por: " + e.getMessage());
		}
		return msg;
	}

	@Transactional
	public Mensaje update(RequisicionDTO requisicionDTO) {
		try {
			Requisicion requisicion = requisicionRepository.findById(requisicionDTO.getIdRequisicion()).get();
			clavePresupuestariaDTO = clavePresupuestariaService
					.findById(requisicionDTO.getClavePresupuestaria().getIdClavePresup());
			requisicionDTO.setClavePresupuestaria(clavePresupuestariaDTO);
			requisicionRepository.save(RequisicionMapper.setToUpdate(requisicion, requisicionDTO));
			msg = Mensaje.success("Actualizado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Actualizar por: " + e.getMessage());
		}
		return msg;
	}

	@Transactional
	public Mensaje deleteById(int id) {
		try {
			requisicionRepository.deleteById(id);
			msg = Mensaje.success("Eliminado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Eliminar.");
		}
		return msg;

	}

}
