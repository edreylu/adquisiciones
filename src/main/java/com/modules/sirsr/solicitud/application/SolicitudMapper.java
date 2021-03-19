package com.modules.sirsr.solicitud.application;

import com.modules.sirsr.documento.application.DocumentoMapper;
import com.modules.sirsr.estatus.application.EstatusMapper;
import com.modules.sirsr.prioridad.application.PrioridadMapper;
import com.modules.sirsr.requisicion.application.RequisicionMapper;
import com.modules.sirsr.solicitud.domain.Solicitud;
import com.modules.sirsr.requisicion.domain.Requisicion;

import java.io.IOException;

import com.modules.sirsr.requisicion.application.RequisicionDTO;
import com.modules.sirsr.unidadResponsable.application.UnidadResponsableMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class SolicitudMapper {

    ModelMapper modelMapper = new ModelMapper();


    public SolicitudDTO toSolicitudDTO(Solicitud solicitud) {
        if (Objects.isNull(solicitud)) {
            return null;
        }

        EstatusMapper estatusMapper = new EstatusMapper();
        PrioridadMapper prioridadMapper = new PrioridadMapper();
        UnidadResponsableMapper unidadResponsableMapper = new UnidadResponsableMapper();

        SolicitudDTO solicitudDTO = new SolicitudDTO();
        solicitudDTO.setIdSolicitud(solicitud.getIdSolicitud());
        solicitudDTO.setFechaCreacion(solicitud.getFechaCreacion());
        solicitudDTO.setAnioCalendarizacion(solicitud.getAnioCalendarizacion());
        solicitudDTO.setMesCalendarizacion(solicitud.getMesCalendarizacion());
        solicitudDTO.setActividadOUso(solicitud.getActividadOUso());
        solicitudDTO.setFechaEmision(solicitud.getFechaEmision());
        solicitudDTO.setFirmaDirector(solicitud.getFirmaDirector());
        solicitudDTO.setFolio(solicitud.getFolio());
        solicitudDTO.setClaveUr(solicitud.getClaveUr());
        solicitudDTO.setFechaAutorizacion(solicitud.getFechaAutorizacion());
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

    public Solicitud toSolicitud(SolicitudDTO solicitudDTO) throws IOException {
        if (Objects.isNull(solicitudDTO)) {
            return null;
        }

        Solicitud solicitud = modelMapper.map(solicitudDTO, Solicitud.class);

        return solicitud;
    }

    public Requisicion setToUpdate(Requisicion requisicionFound, RequisicionDTO requisicionDTO) {
        //requisicionFound.setRequisicionName("ROLE_" + requisicionDTO.getRequisicionName());
        return requisicionFound;
    }
    
    private String replaceCaracter(String caracter, int opcion) {
        Objects.nonNull(caracter);
        return opcion == 1 ? caracter.replaceAll(",", "\\|") : caracter.replaceAll("\\|", ",");
    }
}
