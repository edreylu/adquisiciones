/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.tipoDocumento.domain;

import com.modules.sirsr.tipoDocumento.persistence.TipoDocumento;
import com.modules.sirsr.tipoDocumento.persistence.TipoDocumentoMapper;
import com.modules.sirsr.tipoDocumento.persistence.TipoDocumentoRepository;
import com.modules.sirsr.config.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Edward Reyes
 */
@Service
public class TipoDocumentoService {

	private final TipoDocumentoRepository tipoDocumentoRepository;
	private Mensaje msg;

	@Autowired
	public TipoDocumentoService(TipoDocumentoRepository tipoDocumentoRepository) {
		this.tipoDocumentoRepository = tipoDocumentoRepository;
	}

	public List<TipoDocumentoDTO> findAll() {
		return TipoDocumentoMapper.toTipoDocumentoDTOs(tipoDocumentoRepository.findAll());
	}

	public TipoDocumentoDTO findById(int id) {
		Optional<TipoDocumento> tipoDocumentoOptional = tipoDocumentoRepository.findById(id);
		TipoDocumentoDTO tipoDocumentoDTO = TipoDocumentoMapper.toTipoDocumentoDTO(tipoDocumentoOptional.get());
		return tipoDocumentoDTO;
	}

	public List<Integer> findAllIdDocumentosObligatorios() {
		List<TipoDocumentoDTO> tiposDocumentosObligatorios = TipoDocumentoMapper
				.toTipoDocumentoDTOs(tipoDocumentoRepository.findByObligatorio("S"));
		List<Integer> idTipoDocumentosObligatorios = tiposDocumentosObligatorios.stream()
				.map(tipoDocumentoObligatorio -> tipoDocumentoObligatorio.getIdTipoDocumento())
				.collect(Collectors.toList());
		return idTipoDocumentosObligatorios;
	}

	public List<Integer> findAllIdDocumentosUnicos() {
		List<TipoDocumentoDTO> tiposDocumentosUnicos = TipoDocumentoMapper
				.toTipoDocumentoDTOs(tipoDocumentoRepository.findByUnico("S"));
		List<Integer> idTipoDocumentosObligatorios = tiposDocumentosUnicos.stream()
				.map(tipoDocumentosUnico -> tipoDocumentosUnico.getIdTipoDocumento()).collect(Collectors.toList());
		return idTipoDocumentosObligatorios;
	}

	public List<TipoDocumentoDTO> findAllByTiposDocumentoNot(List<Integer> documentoDTOs) {
		return TipoDocumentoMapper
				.toTipoDocumentoDTOs(tipoDocumentoRepository.findByIdTipoDocumentoNotIn(documentoDTOs));
	}

}
