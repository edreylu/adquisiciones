package com.modules.sirsr.prioridad.persistence;

import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.prioridad.domain.PrioridadDTO;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsableMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class PrioridadMapper {

    private final EstatusMapper estatusMapper = new EstatusMapper();
    private final UnidadResponsableMapper unidadResponsableMapper = new UnidadResponsableMapper();

    public PrioridadDTO toPrioridadDTO(Prioridad prioridad) {
        if (Objects.isNull(prioridad)) {
            return null;
        }
        PrioridadDTO prioridadDTO = new PrioridadDTO();
        prioridadDTO.setIdPrioridad(prioridad.getIdPrioridad());
        prioridadDTO.setDescripcion(prioridad.getDescripcion());
        prioridadDTO.setEstatus(estatusMapper.toEstatusDTO(prioridad.getEstatus()));

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

    public Prioridad toPrioridad(PrioridadDTO prioridadDTO) {
        if (Objects.isNull(prioridadDTO)) {
            return null;
        }
        Prioridad prioridad = new Prioridad();
        prioridad.setIdPrioridad(prioridadDTO.getIdPrioridad());
        prioridad.setDescripcion(prioridadDTO.getDescripcion());
        prioridad.setEstatus(estatusMapper.toEstatus(prioridadDTO.getEstatus()));
        return prioridad;
    }

    public Prioridad setToUpdate(Prioridad prioridadFound, PrioridadDTO prioridadDTO) {
        return prioridadFound;
    }

}
