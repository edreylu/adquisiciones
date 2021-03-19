package com.modules.sirsr.tipoPersonaFiscal.application;

import java.util.List;
import java.util.Optional;

import com.modules.sirsr.estatus.application.EstatusDTO;
import com.modules.sirsr.estatus.application.EstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.proveedor.application.ProveedorDTO;
import com.modules.sirsr.proveedor.domain.Proveedor;
import com.modules.sirsr.tipoPersonaFiscal.domain.TipoPersonaFiscal;
import com.modules.sirsr.tipoPersonaFiscal.domain.TipoPersonaFiscalRepository;
import com.modules.sirsr.usuario.domain.Usuario;

@Service
public class TipoPersonaFiscalService {

	private final TipoPersonaFiscalRepository tipoPersonaFiscalRepository;
	private final TipoPersonaFiscalMapper tipoPersonaFiscalMapper;
	private final EstatusService estatusService;


	@Autowired
	public TipoPersonaFiscalService(TipoPersonaFiscalRepository tipoPersonaFiscalRepository, TipoPersonaFiscalMapper tipoPersonaFiscalMapper, EstatusService estatusService) {
		this.tipoPersonaFiscalRepository = tipoPersonaFiscalRepository;
		this.tipoPersonaFiscalMapper = tipoPersonaFiscalMapper;
		this.estatusService = estatusService;
	}

	private Mensaje msg;

	public List<TipoPersonaFiscalDTO> findAll() {
		return tipoPersonaFiscalMapper.toTipoPersonaFiscalDTOs(tipoPersonaFiscalRepository.findAll());
	}

	public TipoPersonaFiscalDTO buscaPorId(int id) {
		Optional<TipoPersonaFiscal> tipoPersonaFiscalOp = tipoPersonaFiscalRepository.findById(id);
		TipoPersonaFiscalDTO tipoPersonaFiscalDTO = tipoPersonaFiscalMapper
				.toTipoPersonaFiscalDTO(tipoPersonaFiscalOp.get());
		return tipoPersonaFiscalDTO;
	}

	public Mensaje actualizaTipoPersonaFiscal(TipoPersonaFiscalDTO tipoPersonaFiscalDTO, int id) {
		try {
			Optional<TipoPersonaFiscal> tipoPersonaFiscal = tipoPersonaFiscalRepository.findById(id);
			if (tipoPersonaFiscal.isPresent()) {
				
				tipoPersonaFiscalRepository.save(tipoPersonaFiscalMapper.toUpdatePersonaFiscal(tipoPersonaFiscal.get(), tipoPersonaFiscalDTO));
				msg = Mensaje.CREATE("Actualizado correctamente", 1);
			}

		} catch (Exception e) {
			msg = Mensaje.CREATE("No se pudo Actualizar por: " + e.getMessage(), 2);
		}
		return msg;
	}
	
	public Mensaje save(TipoPersonaFiscalDTO tipoPersonaFiscalDTO) {
        try {
        	tipoPersonaFiscalDTO.setIdEstatus(1);
        	tipoPersonaFiscalRepository.save(tipoPersonaFiscalMapper.toTipoPersonaFiscal(tipoPersonaFiscalDTO));
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
        }
        return msg;
    }
	
	public Mensaje borraPorId(int id, int idEstatus) {

        String action = idEstatus == 1 ? "Activado" : "Inactivado";
        try {
            Optional<TipoPersonaFiscal> tipoPersonaFiscal = tipoPersonaFiscalRepository.findById(id);
            if(tipoPersonaFiscal.isPresent()) {
            	tipoPersonaFiscal.get().setIdEstatus(idEstatus);
            }
            
            tipoPersonaFiscalRepository.save(tipoPersonaFiscal.get());
            msg = Mensaje.CREATE(action + " correctamente", 1);
        } catch (Exception e) {
            msg = Mensaje.CREATE("No se pudo " + action + " por: " + e.getMessage(), 2);
        }
        return msg;

    }
}
