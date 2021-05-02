package com.modules.sirsr.actividad.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.modules.sirsr.actividad.domain.ActividadDTO;
import com.modules.sirsr.estatus.persistence.EstatusMapper;

@Component
public class ActividadMapper {
	
	public static ActividadDTO toActividadDTO(Actividad actividad) {
		
		ActividadDTO actividadDTO = new ActividadDTO();
		actividadDTO.setIdActividad(actividad.getIdActividad());
		actividadDTO.setDescripcion(actividad.getDescripcion());
		actividadDTO.setEstatus(EstatusMapper.toEstatusDTO(actividad.getEstatus()));
		
		return actividadDTO;
	}
	
	
	public static List<ActividadDTO> toActividadDTOs(List<Actividad> actividades){
		List<ActividadDTO> actividadesDTO = new ArrayList<ActividadDTO>();
		for (Actividad actividad : actividades) {
			actividadesDTO.add(toActividadDTO(actividad));
		}
		return actividadesDTO;
	}
	
	
	public static Actividad toActividad(ActividadDTO actividadDTO) {
		
		Actividad actividad = new Actividad();
		
	    actividad.setIdActividad(actividadDTO.getIdActividad());
	    actividad.setDescripcion(actividadDTO.getDescripcion());
	    actividad.setEstatus(EstatusMapper.toEstatus(actividadDTO.getEstatus()));
	    
	    return actividad;
	}
	
	
public static Actividad setToUpdate(Actividad actividadFound, ActividadDTO actividadDTO) {
    	
    	actividadFound.setDescripcion(actividadDTO.getDescripcion());
       
        return actividadFound;
    }
	
}
