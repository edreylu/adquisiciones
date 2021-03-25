package com.modules.sirsr.diaPermitido.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.diaPermitido.domain.DiaPermitido;
import com.modules.sirsr.diaPermitido.domain.DiaPermitidoRepository;
import com.modules.sirsr.estatus.domain.EstatusRepository;
import com.modules.sirsr.proveedor.application.ProveedorDTO;
import com.modules.sirsr.proveedor.domain.Proveedor;


@Service
public class DiaPermitidoService {

	private final DiaPermitidoMapper diaPermitidoMapper;
	private final DiaPermitidoRepository diaPermitidoRepository;
	private final EstatusRepository estatusRepository;
	private Mensaje msg;

	@Autowired
	public DiaPermitidoService(DiaPermitidoRepository diaPermitidoRepository, DiaPermitidoMapper diaPermitidoMapper, EstatusRepository estatusRepository) {
		this.diaPermitidoRepository = diaPermitidoRepository;
		this.diaPermitidoMapper = diaPermitidoMapper;
		this.estatusRepository = estatusRepository;
	}

	public List<DiaPermitidoDTO> findAll() {
		List<DiaPermitido> diasPermitidos = diaPermitidoRepository.findAll();
		return diaPermitidoMapper.toDiasPermitodosDTO(diasPermitidos);
	}
	
	public Mensaje save(DiaPermitidoDTO diaPermitidoDTO) {
		try {
			diaPermitidoDTO.setEstatus(estatusRepository.findById(1).get());
			DiaPermitido diaPermitido = diaPermitidoMapper.toDiaPermitido(diaPermitidoDTO);
			diaPermitidoRepository.save(diaPermitido);
			msg = Mensaje.CREATE("Agregado correctamente", 1);
		} catch (Exception e) {
			msg = Mensaje.CREATE("No se pudo agregar por: " + e.getMessage(), 2);
		}
		return msg;
	}

}
