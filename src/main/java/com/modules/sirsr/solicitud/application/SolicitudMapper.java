package com.modules.sirsr.solicitud.application;

import com.modules.sirsr.documento.application.DocumentoMapper;
import com.modules.sirsr.estatus.application.EstatusMapper;
import com.modules.sirsr.prioridad.application.PrioridadMapper;
import com.modules.sirsr.solicitud.domain.Solicitud;
import com.modules.sirsr.unidadResponsable.application.UnidadResponsableMapper;
import org.springframework.stereotype.Component;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

@Component
public class SolicitudMapper {
    EstatusMapper estatusMapper = new EstatusMapper();
    PrioridadMapper prioridadMapper = new PrioridadMapper();
    UnidadResponsableMapper unidadResponsableMapper = new UnidadResponsableMapper();

    public SolicitudDTO toSolicitudDTO(Solicitud solicitud) {
        if (Objects.isNull(solicitud)) {
            return null;
        }
        Month month=Month.of(solicitud.getMesCalendarizacion());
        String monthName=month.getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase();

        SolicitudDTO solicitudDTO = new SolicitudDTO();
        solicitudDTO.setIdSolicitud(solicitud.getIdSolicitud());
        solicitudDTO.setFechaCreacion(solicitud.getFechaCreacion());
        solicitudDTO.setAnioCalendarizacion(solicitud.getAnioCalendarizacion());
        solicitudDTO.setMesCalendarizacion(solicitud.getMesCalendarizacion());
        solicitudDTO.setMesCalendarizacionStr(monthName);
        solicitudDTO.setActividadOUso(solicitud.getActividadOUso());
        solicitudDTO.setFechaEmision(solicitud.getFechaEmision());
        solicitudDTO.setFirmaDirector(solicitud.getFirmaDirector());
        solicitudDTO.setFolio(solicitud.getFolio());
        solicitudDTO.setClaveUr(solicitud.getClaveUr());
        solicitudDTO.setFechaAutorizacion(solicitud.getFechaAutorizacion());
        solicitudDTO.setFechaRecepcion(solicitud.getFechaRecepcion());
        solicitudDTO.setEstatus(estatusMapper.toEstatusDTO(solicitud.getEstatus()));
        solicitudDTO.setPrioridad(prioridadMapper.toPrioridadDTO(solicitud.getPrioridad()));
        solicitudDTO.setUnidadResponsable(unidadResponsableMapper.toUnidadResponsableDTO(solicitud.getUnidadResponsable()));

        return solicitudDTO;
    }

    public List<SolicitudDTO> toSolicitudDTOs(List<Solicitud> solicitudes) {
        if (Objects.isNull(solicitudes)) {
            return null;
        }
        List<SolicitudDTO> list = new ArrayList<>(solicitudes.size());
        for (Solicitud solicitud : solicitudes) {
            list.add(toSolicitudDTO(solicitud));
        }
        return list;
    }

    public Solicitud toSolicitud(SolicitudDTO solicitudDTO){
        if (Objects.isNull(solicitudDTO)) {
            return null;
        }

        Solicitud solicitud = new Solicitud();
        solicitud.setIdSolicitud(solicitudDTO.getIdSolicitud());
        solicitud.setFechaCreacion(solicitudDTO.getFechaCreacion());
        solicitud.setAnioCalendarizacion(solicitudDTO.getAnioCalendarizacion());
        solicitud.setMesCalendarizacion(solicitudDTO.getMesCalendarizacion());
        solicitud.setActividadOUso(solicitudDTO.getActividadOUso());
        solicitud.setFechaEmision(solicitudDTO.getFechaEmision());
        solicitud.setFirmaDirector(solicitudDTO.getFirmaDirector());
        solicitud.setFolio(solicitudDTO.getFolio());
        solicitud.setClaveUr(solicitudDTO.getClaveUr());
        solicitud.setFechaAutorizacion(solicitudDTO.getFechaAutorizacion());
        solicitud.setFechaRecepcion(solicitudDTO.getFechaRecepcion());
        solicitud.setEstatus(estatusMapper.toEstatus(solicitudDTO.getEstatus()));
        solicitud.setPrioridad(prioridadMapper.toPrioridad(solicitudDTO.getPrioridad()));
        solicitud.setUnidadResponsable(unidadResponsableMapper.toUnidadResponsable(solicitudDTO.getUnidadResponsable()));

        return solicitud;
    }

    public Solicitud setToUpdate(Solicitud solicitudFound, SolicitudDTO solicitudDTO) {
        PrioridadMapper prioridadMapper = new PrioridadMapper();
        solicitudFound.setActividadOUso(solicitudDTO.getActividadOUso());
        solicitudFound.setMesCalendarizacion(solicitudDTO.getMesCalendarizacion());
        solicitudFound.setPrioridad(prioridadMapper.toPrioridad(solicitudDTO.getPrioridad()));
        return solicitudFound;
    }
    
    private String replaceCaracter(String caracter, int opcion) {
        Objects.nonNull(caracter);
        return opcion == 1 ? caracter.replaceAll(",", "\\|") : caracter.replaceAll("\\|", ",");
    }
}
