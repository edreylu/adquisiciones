package com.modules.sirsr.tipoPersonaFiscal.domain;

import java.util.List;
import java.util.Optional;

import com.modules.sirsr.estatus.domain.EstatusService;
import com.modules.sirsr.tipoPersonaFiscal.persistence.TipoPersonaFiscalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.tipoPersonaFiscal.persistence.TipoPersonaFiscal;
import com.modules.sirsr.tipoPersonaFiscal.persistence.TipoPersonaFiscalRepository;

@Service
public class TipoPersonaFiscalService {

	private final TipoPersonaFiscalRepository tipoPersonaFiscalRepository;
	private final EstatusService estatusService;

	@Autowired
	public TipoPersonaFiscalService(TipoPersonaFiscalRepository tipoPersonaFiscalRepository, EstatusService estatusService) {
		this.tipoPersonaFiscalRepository = tipoPersonaFiscalRepository;
		this.estatusService = estatusService;
	}

	private Mensaje msg;

	public List<TipoPersonaFiscalDTO> findAll() {
		return TipoPersonaFiscalMapper.toTipoPersonaFiscalDTOs(tipoPersonaFiscalRepository.findAll());
	}

	public TipoPersonaFiscalDTO buscaPorId(int id) {
		Optional<TipoPersonaFiscal> tipoPersonaFiscalOp = tipoPersonaFiscalRepository.findById(id);
		TipoPersonaFiscalDTO tipoPersonaFiscalDTO = TipoPersonaFiscalMapper
				.toTipoPersonaFiscalDTO(tipoPersonaFiscalOp.get());
		return tipoPersonaFiscalDTO;
	}

	public Mensaje actualizaTipoPersonaFiscal(TipoPersonaFiscalDTO tipoPersonaFiscalDTO, int id) {
		try {
			Optional<TipoPersonaFiscal> tipoPersonaFiscal = tipoPersonaFiscalRepository.findById(id);
			if (tipoPersonaFiscal.isPresent()) {

				tipoPersonaFiscalRepository.save(
						TipoPersonaFiscalMapper.toUpdatePersonaFiscal(tipoPersonaFiscal.get(), tipoPersonaFiscalDTO));
				msg = Mensaje.success("Actualizado correctamente");
			}

		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Actualizar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje save(TipoPersonaFiscalDTO tipoPersonaFiscalDTO) {
		try {
			tipoPersonaFiscalDTO.setIdEstatus(1);
			tipoPersonaFiscalRepository.save(TipoPersonaFiscalMapper.toTipoPersonaFiscal(tipoPersonaFiscalDTO));
			msg = Mensaje.success("Agregado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje borraPorId(int id, int idEstatus) {

		String action = idEstatus == 1 ? "Activado" : "Inactivado";
		try {
			Optional<TipoPersonaFiscal> tipoPersonaFiscal = tipoPersonaFiscalRepository.findById(id);
			if (tipoPersonaFiscal.isPresent()) {
				tipoPersonaFiscal.get().setIdEstatus(idEstatus);
			}

			tipoPersonaFiscalRepository.save(tipoPersonaFiscal.get());
			msg = Mensaje.success(action + " correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo " + action + " por: " + e.getMessage());
		}
		return msg;

	}
}
