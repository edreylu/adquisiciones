package com.modules.sirsr.prioridad.application;

import com.modules.sirsr.prioridad.domain.Prioridad;
import com.modules.sirsr.unidadResponsable.application.UnidadResponsableMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class PrioridadMapper {

    ModelMapper modelMapper = new ModelMapper();
    private final UnidadResponsableMapper unidadResponsableMapper = new UnidadResponsableMapper();

    public PrioridadDTO toPrioridadDTO(Prioridad prioridad) {
        if (Objects.isNull(prioridad)) {
            return null;
        }
        PrioridadDTO prioridadDTO = modelMapper.map(prioridad, PrioridadDTO.class);

        return prioridadDTO;
    }

    public List<PrioridadDTO> toPrioridadDTOs(List<Prioridad> prioridades) {
        if (Objects.isNull(prioridades)) {
            return null;
        }
        List<PrioridadDTO> list = new ArrayList<>(prioridades.size());
        for (Prioridad prioridad : prioridades) {
            list.add(toPrioridadDTO(prioridad));
        }
        return list;
    }

    public Prioridad toPrioridad(PrioridadDTO prioridadDTO) throws IOException {
        if (Objects.isNull(prioridadDTO)) {
            return null;
        }


        Prioridad prioridad = modelMapper.map(prioridadDTO, Prioridad.class);
        return prioridad;
    }

    public Prioridad setToUpdate(Prioridad prioridadFound, PrioridadDTO prioridadDTO) {
        return prioridadFound;
    }

}
