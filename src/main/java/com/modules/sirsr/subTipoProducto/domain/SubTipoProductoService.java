/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.subTipoProducto.domain;

import com.modules.sirsr.subTipoProducto.persistence.SubTipoProducto;
import com.modules.sirsr.subTipoProducto.persistence.SubTipoProductoMapper;
import com.modules.sirsr.subTipoProducto.persistence.SubTipoProductoRepository;
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
public class SubTipoProductoService {

	private final SubTipoProductoRepository subTipoProductoRepository;
	private Mensaje msg;

	@Autowired
	public SubTipoProductoService(SubTipoProductoRepository subTipoProductoRepository) {
		this.subTipoProductoRepository = subTipoProductoRepository;
	}

	public List<SubTipoProductoDTO> findAll() {
		return SubTipoProductoMapper.toSubTipoProductoDTOs(subTipoProductoRepository.findAll());
	}

	public SubTipoProductoDTO findById(int id) {
		Optional<SubTipoProducto> subTipoProductoOptional = subTipoProductoRepository.findById(id);
		SubTipoProductoDTO tipoDocumentoDTO = SubTipoProductoMapper.toSubTipoProductoDTO(subTipoProductoOptional.get());
		return tipoDocumentoDTO;
	}

}
