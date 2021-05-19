/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.domain;

import com.modules.sirsr.documento.persistence.Documento;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.estatus.domain.EstatusService;
import com.modules.sirsr.folioRequisicion.persistence.FolioRequisicionRepository;
import com.modules.sirsr.prioridad.domain.PrioridadDTO;
import com.modules.sirsr.prioridad.domain.PrioridadService;
import com.modules.sirsr.prioridad.persistence.PrioridadMapper;

import java.util.*;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.config.Utils;
import java.time.Instant;
import com.modules.sirsr.prioridad.persistence.PrioridadRepository;
import com.modules.sirsr.revision.domain.RevisionDTO;
import com.modules.sirsr.revision.domain.RevisionService;
import com.modules.sirsr.revision.persistence.Revision;
import com.modules.sirsr.revision.persistence.RevisionPK;
import com.modules.sirsr.revision.persistence.RevisionRepository;
import com.modules.sirsr.solicitud.persistence.Solicitud;
import com.modules.sirsr.solicitud.persistence.SolicitudMapper;
import com.modules.sirsr.solicitud.persistence.SolicitudRepository;

import org.eclipse.persistence.exceptions.JAXBException;
import org.eclipse.persistence.jpa.rs.exceptions.JPARSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.modules.sirsr.usuario.domain.UsuarioDTO;
import com.modules.sirsr.usuario.domain.UsuarioService;
import com.modules.sirsr.config.WebUtils;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoService;
import java.util.stream.Collectors;

/**
 *
 * @author Edward Reyes
 */
@Service
public class SolicitudService {

	private final SolicitudRepository solicitudRepository;
	private final UsuarioService usuarioService;
	private final EstatusService estatusService;
	private final TipoDocumentoService tipoDocumentoService;
	private final PrioridadService prioridadService;
	private final RevisionService revisionService;
	private List<Integer> idTiposDocumentoObligatorios;
	private SolicitudDTO solicitudDTO;
	private UsuarioDTO usuarioDTO;
	private EstatusDTO estatusDTO;
	private PrioridadDTO prioridadDTO;
	private Mensaje msg;

	@Autowired
	public SolicitudService(SolicitudRepository solicitudRepository, UsuarioService usuarioService,
			EstatusService estatusService, TipoDocumentoService tipoDocumentoService,
			PrioridadService prioridadService, RevisionService revisionService) {
		this.solicitudRepository = solicitudRepository;
		this.usuarioService = usuarioService;
		this.estatusService = estatusService;
		this.prioridadService = prioridadService;
		this.revisionService = revisionService;
		this.tipoDocumentoService = tipoDocumentoService;
	}

	public List<SolicitudDTO> findAll() {
		return SolicitudMapper
				.toSolicitudDTOs(solicitudRepository.findAll(Sort.by(Sort.Direction.DESC, "idSolicitud")));
	}

	public List<SolicitudDTO> findAllEmitidas() {
		return SolicitudMapper.toSolicitudDTOs(solicitudRepository.findByIdEstatusGreaterThanEqual(11));
	}

	public List<SolicitudDTO> findByClaveUnidad() {
		usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
		return SolicitudMapper.toSolicitudDTOs(solicitudRepository.findByClaveUr(
				usuarioDTO.getUnidadResponsable().getClaveUr(), Sort.by(Sort.Direction.DESC, "idSolicitud")));
	}

	public SolicitudDTO findById(int id) {
		Optional<Solicitud> requisicionOptional = solicitudRepository.findById(id);
		SolicitudDTO solicitudDTO = SolicitudMapper.toSolicitudDTO(requisicionOptional.get());
		return solicitudDTO;
	}

	public Mensaje save(SolicitudDTO solicitudDTO) {
		try {
			usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
			estatusDTO = estatusService.findById(10);
			prioridadDTO = prioridadService.findById(solicitudDTO.getPrioridad().getIdPrioridad());
			Calendar calendar = Calendar.getInstance();
			int annio = calendar.get(Calendar.YEAR);
			solicitudDTO.setUnidadResponsable(usuarioDTO.getUnidadResponsable());
			solicitudDTO.setFechaCreacion(Date.from(Instant.now()));
			solicitudDTO.setAnioCalendarizacion(annio);
			solicitudDTO.setPrioridad(prioridadDTO);
			solicitudDTO.setEstatus(estatusDTO);
			System.out.println(solicitudDTO.toString());
			solicitudRepository.save(SolicitudMapper.toSolicitud(solicitudDTO));

			msg = Mensaje.success("Agregado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje update(SolicitudDTO solicitudDTO, int id) {
		try {
			SolicitudDTO solicitudFound = this.findById(id);
			solicitudRepository.save(SolicitudMapper.setToUpdate(solicitudFound, solicitudDTO));
			msg = Mensaje.success("Actualizado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Actualizar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje deleteById(int id) {
		try {
			estatusDTO = estatusService.findById(14);
			solicitudDTO = this.findById(id);
			solicitudDTO.setEstatus(estatusDTO);
			solicitudRepository.save(SolicitudMapper.toSolicitud(solicitudDTO));
			msg = Mensaje.success("Cancelado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Cancelar.");
		}
		return msg;

	}

	public Mensaje emitirById(int id) {
		Solicitud solicitud = solicitudRepository.findById(id).get();
		if (areDocumentsComplete(solicitud.getDocumentos())) {
			try {
				solicitud.setEstatus(estatusService.estatusFindById(11));
				solicitud.setFechaEmision(Date.from(Instant.now()));
				solicitudRepository.save(solicitud);

				Utils.firmaDirector(usuarioService.findByUserName(WebUtils.getUserName()), solicitudRepository, solicitud);

				msg = Mensaje.success("Emitido correctamente");
			} catch (Exception e) {
				msg = Mensaje.danger("No se pudo Emitir.");
			}
		} else
			msg = Mensaje.danger("No has subido los documentos necesarios.");
		return msg;

	}

	public Mensaje correction(RevisionDTO revisionDTO, int id) {
		try {
			SolicitudDTO solicitudDTO = findById(id);
			EstatusDTO estatusDTO = estatusService.findById(13);
			revisionDTO.setFechaRevision(Date.from(Instant.now()));
			revisionDTO.setSolicitud(solicitudDTO);
			Mensaje msgRev = revisionService.save(revisionDTO);
			if(msgRev.getResult()==1) {
			solicitudDTO.setEstatus(estatusDTO);
			solicitudRepository.save(SolicitudMapper.toSolicitud(solicitudDTO));
			msg = Mensaje.success("Se enviaron correciones correctamente");
			}else {
				msg = Mensaje.warning("No se pudo enviar correcciones.");
			}
		} catch (JPARSException e) {
			msg = Mensaje.danger("No se pudo enviar correcciones.");
		}
		return msg;

	}

	public Mensaje acceptById(int id) {
		try {
			solicitudDTO = findById(id);
			EstatusDTO estatusDTO = estatusService.findById(15);
			solicitudDTO.setEstatus(estatusDTO);
			solicitudDTO.setFechaAutorizacion(Date.from(Instant.now()));
			solicitudRepository.save(SolicitudMapper.toSolicitud(solicitudDTO));
			msg = Mensaje.success("Se Acepto la solicitud correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo aceptar la solicitud.");
		}
		return msg;
	}

	public void updateEstatusFecha(SolicitudDTO solicitudDTO, int idEstatus) {
		try {
			estatusDTO = estatusService.findById(idEstatus);
			Date now = Date.from(Instant.now());
			solicitudDTO.setFechaRecepcion(now);
			solicitudDTO.setEstatus(estatusDTO);
			solicitudRepository.save(SolicitudMapper.toSolicitud(solicitudDTO));
		} catch (Exception e) {
		}
	}

	public Boolean areDocumentsComplete(List<Documento> documentos) {
		idTiposDocumentoObligatorios = tipoDocumentoService.findAllIdDocumentosObligatorios();
		List<Integer> idTiposDocumento = documentos.stream()
				.map(idTipoDocumento -> idTipoDocumento.getTipoDocumento().getIdTipoDocumento())
				.collect(Collectors.toList());
		boolean isValid = idTiposDocumentoObligatorios.stream()
				.allMatch(idTipoDocumentoObligatorio -> idTiposDocumento.contains(idTipoDocumentoObligatorio));
		return isValid;
	}

}
