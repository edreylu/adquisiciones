package com.modules.sirsr.solicitud.application;

import com.modules.sirsr.solicitud.domain.Solicitud;
import com.modules.sirsr.requisicion.domain.Requisicion;

import java.io.IOException;

import com.modules.sirsr.requisicion.application.RequisicionDTO;
import com.modules.sirsr.unidadResponsable.application.UnidadResponsableMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class SolicitudMapper {

    ModelMapper modelMapper = new ModelMapper();
    private final UnidadResponsableMapper unidadResponsableMapper = new UnidadResponsableMapper();

    public SolicitudDTO toSolicitudDTO(Solicitud solicitud) {
        if (Objects.isNull(solicitud)) {
            return null;
        }

        SolicitudDTO solicitudDTO = modelMapper.map(solicitud, SolicitudDTO.class);
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
