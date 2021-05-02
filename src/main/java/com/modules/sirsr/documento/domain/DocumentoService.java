/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.documento.domain;

import com.modules.sirsr.documento.persistence.DocumentoRepository;
import com.modules.sirsr.documento.persistence.Documento;
import com.modules.sirsr.documento.persistence.DocumentoMapper;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.solicitud.domain.SolicitudService;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoDTO;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoService;
import com.modules.sirsr.config.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Edward Reyes
 */
@Service
public class DocumentoService {

	private final DocumentoRepository documentoRepository;
	private final SolicitudService solicitudService;
	private final TipoDocumentoService tipoDocumentoService;
	private List<Integer> idTiposDocumentosUnicos;
	private Mensaje msg;

	@Autowired
	public DocumentoService(DocumentoRepository documentoRepository, SolicitudService solicitudService,
			TipoDocumentoService tipoDocumentoService) {
		this.documentoRepository = documentoRepository;
		this.solicitudService = solicitudService;
		this.tipoDocumentoService = tipoDocumentoService;
	}

	public List<DocumentoDTO> findAll() {
		return DocumentoMapper.toDocumentoDTOs(documentoRepository.findAll());
	}

	public DocumentoDTO findById(int id) {
		Optional<Documento> documentoOptional = documentoRepository.findById(id);
		DocumentoDTO documentoDTO = DocumentoMapper.toDocumentoDTO(documentoOptional.get());
		return documentoDTO;
	}

	public List<DocumentoDTO> findByIdSolicitud(int idSolicitud) {
		List<DocumentoDTO> documentoDTOs = DocumentoMapper.toDocumentoDTOs(documentoRepository.findByIdSolicitud(idSolicitud));
		return documentoDTOs;
	}

	public Mensaje save(DocumentoDTO documentoDTO) {
		try {
			SolicitudDTO solicitud = solicitudService.findById(documentoDTO.getSolicitud().getIdSolicitud());
			TipoDocumentoDTO tipoDocumento = tipoDocumentoService
					.findById(documentoDTO.getTipoDocumento().getIdTipoDocumento());
			documentoDTO.setSolicitud(solicitud);
			documentoDTO.setTipoDocumento(tipoDocumento);
			documentoRepository.save(DocumentoMapper.toDocumento(documentoDTO));

			msg = Mensaje.success("Documentos agregados correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar documento por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje deleteById(int id) {
		try {
			documentoRepository.deleteById(id);
			msg = Mensaje.success("Eliminado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Eliminar.");
		}
		return msg;

	}

	public List<Integer> getTiposDocumentoNot(int idSolicitud) {
		idTiposDocumentosUnicos = tipoDocumentoService.findAllIdDocumentosUnicos();
		List<Integer> documentoDTOs = this.findByIdSolicitud(idSolicitud).stream().filter(
				documentoDTO -> idTiposDocumentosUnicos.contains(documentoDTO.getTipoDocumento().getIdTipoDocumento()))
				.map(documentoDTO -> documentoDTO.getTipoDocumento().getIdTipoDocumento()).collect(Collectors.toList());
		if (documentoDTOs.isEmpty())
			documentoDTOs.add(0);
		return documentoDTOs;
	}

}
