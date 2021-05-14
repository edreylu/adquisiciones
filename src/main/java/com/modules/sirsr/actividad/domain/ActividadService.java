package com.modules.sirsr.actividad.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modules.sirsr.actividad.persistence.Actividad;
import com.modules.sirsr.actividad.persistence.ActividadMapper;
import com.modules.sirsr.actividad.persistence.ActividadRepository;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.estatus.domain.EstatusService;
import com.modules.sirsr.estatus.persistence.EstatusRepository;

@Service
public class ActividadService {

	private final ActividadRepository actividadRepository;
	private final EstatusService estatusService;
	private Mensaje msg;

	@Autowired
	public ActividadService(ActividadRepository actividadRepository, EstatusService estatusService) {
		this.actividadRepository = actividadRepository;
		this.estatusService = estatusService;
	}

	public List<ActividadDTO> findAll() {
		return ActividadMapper.toActividadDTOs(actividadRepository.findAll());
	}

	public ActividadDTO findById(int id) {

		Optional<Actividad> actividad = actividadRepository.findById(id);
		if (actividad.isPresent()) {
			return ActividadMapper.toActividadDTO(actividad.get());
		}
		return null;
	}
	
	
	public Mensaje save(ActividadDTO actividadDTO) {
		try {
			
			actividadDTO.setEstatus(estatusService.findById(1));
			actividadRepository.save(ActividadMapper.toActividad(actividadDTO));
			msg = Mensaje.success("Agregado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}
	
	public Mensaje borraPorId(int id, int idEstatus) {

        String action = idEstatus == 1 ? "Activado" : "Inactivado";
        try {
        	ActividadDTO actividadDTO = findById(id);
            if(Objects.nonNull(actividadDTO)) {
            	actividadDTO.setEstatus(estatusService.findById(idEstatus));
            }
            
            actividadRepository.save(ActividadMapper.toActividad(actividadDTO));
            msg = Mensaje.success(action + " correctamente");
        } catch (Exception e) {
            msg = Mensaje.danger("No se pudo " + action + " por: " + e.getMessage());
        }
        return msg;

    }
	
	public Mensaje update(ActividadDTO actividadDTO, int id) {
		try {
			Optional<Actividad> actividadFound = actividadRepository.findById(id);
			
			if (actividadFound.isPresent()) {
				Actividad actividad = ActividadMapper.setToUpdate(actividadFound.get(), actividadDTO);
				actividadRepository.save(actividad);
				
			} else {
				msg = Mensaje.notFound("No se encontro el proveedor");
			}
		
			msg = Mensaje.notFound("Actualizado correctamente");

		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Actualizar por: " + e.getMessage());
		}
		return msg;
	}
	
	

}
