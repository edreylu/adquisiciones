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
import com.modules.sirsr.estatus.persistence.EstatusRepository;

@Service
public class ActividadService {

	private final ActividadRepository actividadRepository;
	private final ActividadMapper actividadMapper;
	private final EstatusRepository estatusRepository;
	private Mensaje msg;

	@Autowired
	public ActividadService(ActividadRepository actividadRepository, ActividadMapper actividadMapper, EstatusRepository estatusRepository) {
		this.actividadRepository = actividadRepository;
		this.actividadMapper = actividadMapper;
		this.estatusRepository = estatusRepository;
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
			
			Actividad actividad = ActividadMapper.toActividad(actividadDTO);
			actividad.setEstatus(estatusRepository.findById(1).get());
			actividadRepository.save(actividad);
			msg = Mensaje.CREATE("Agregado correctamente", 1);
		} catch (Exception e) {
			msg = Mensaje.CREATE("No se pudo agregar por: " + e.getMessage(), 2);
		}
		return msg;
	}
	
	public Mensaje borraPorId(int id, int idEstatus) {

        String action = idEstatus == 1 ? "Activado" : "Inactivado";
        try {
            Optional<Actividad> actividad = actividadRepository.findById(id);
            if(actividad.isPresent()) {
            	actividad.get().setEstatus(estatusRepository.findById(idEstatus).get());
            }
            
            actividadRepository.save(actividad.get());
            msg = Mensaje.CREATE(action + " correctamente", 1);
        } catch (Exception e) {
            msg = Mensaje.CREATE("No se pudo " + action + " por: " + e.getMessage(), 2);
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
				msg = Mensaje.CREATE("No se encontro el proveedor", -1);
			}
		
			msg = Mensaje.CREATE("Actualizado correctamente", 1);

		} catch (Exception e) {
			msg = Mensaje.CREATE("No se pudo Actualizar por: " + e.getMessage(), 2);
		}
		return msg;
	}
	
	

}
