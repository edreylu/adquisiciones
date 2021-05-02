/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.tipoProducto.domain;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.tipoProducto.persistence.TipoProducto;
import com.modules.sirsr.tipoProducto.persistence.TipoProductoMapper;
import com.modules.sirsr.tipoProducto.persistence.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Edward Reyes
 */
@Service
public class TipoProductoService {

	private final TipoProductoRepository tipoProductoRepository;
	private final TipoProductoMapper tipoProductoMapper;
	private Mensaje msg;

	@Autowired
	public TipoProductoService(TipoProductoRepository tipoProductoRepository, TipoProductoMapper tipoProductoMapper) {
		this.tipoProductoRepository = tipoProductoRepository;
		this.tipoProductoMapper = tipoProductoMapper;
	}

	public List<TipoProductoDTO> findAll() {
		return tipoProductoMapper.toTipoProductoDTOs(tipoProductoRepository.findAll());
	}

	public List<TipoProductoDTO> findByObjetoGastoStr(String objetoGasto) {
		List<TipoProducto> tiposProducto = tipoProductoRepository.findByObjetoGastoStr(objetoGasto);
		List<TipoProductoDTO> tiposProductoDTO = tipoProductoMapper.toTipoProductoDTOs(tiposProducto);
		return tiposProductoDTO;
	}

	public TipoProductoDTO findById(int id) {
		Optional<TipoProducto> tipoProductoOptional = tipoProductoRepository.findById(id);
		TipoProductoDTO tipoProductoDTO = tipoProductoMapper.toTipoProductoDTO(tipoProductoOptional.get());
		return tipoProductoDTO;
	}

	public Mensaje save(TipoProductoDTO tipoProductoDTO) {
		return msg;
	}

	public Mensaje update(TipoProductoDTO tipoProductoDTO, int id) {
		return msg;
	}

	public Mensaje deleteById(int id) {
		return msg;
	}

}
