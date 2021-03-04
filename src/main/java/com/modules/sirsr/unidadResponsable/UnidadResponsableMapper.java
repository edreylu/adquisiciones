package com.modules.sirsr.unidadResponsable;

import com.modules.sirsr.persistence.entity.UnidadResponsable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UnidadResponsableMapper {

    public UnidadResponsableDTO toUnidadResponsableDTO(UnidadResponsable unidadResponsable) {
        if (Objects.isNull(unidadResponsable)) {
            return null;
        }

        UnidadResponsableDTO unidadResponsableDTO = new UnidadResponsableDTO();
        unidadResponsableDTO.setClaveUr(unidadResponsable.getClaveUr());
        unidadResponsableDTO.setDescripcion(unidadResponsable.getDescripcion());
        unidadResponsableDTO.setFechaInicio(unidadResponsable.getFechaInicio());
        unidadResponsableDTO.setFechaFinal(unidadResponsable.getFechaFinal());
        unidadResponsableDTO.setEstatus(unidadResponsable.getEstatus());

        return unidadResponsableDTO;
    }

    public List<UnidadResponsableDTO> toUnidadResponsableDTOs(List<UnidadResponsable> unidadesResponsables) {
        if (Objects.isNull(unidadesResponsables)) {
            return null;
        }
        List<UnidadResponsableDTO> list = new ArrayList<>(unidadesResponsables.size());
        for (UnidadResponsable unidad : unidadesResponsables) {
            list.add(toUnidadResponsableDTO(unidad));
        }
        return list;
    }

    public UnidadResponsable toUnidadResponsable(UnidadResponsableDTO unidadResponsableDTO) {
        if (Objects.isNull(unidadResponsableDTO)) {
            return null;
        }

        UnidadResponsable unidadResponsable = new UnidadResponsable();
        unidadResponsable.setClaveUr(unidadResponsableDTO.getClaveUr());
        unidadResponsable.setDescripcion(unidadResponsableDTO.getDescripcion());
        unidadResponsable.setFechaInicio(unidadResponsableDTO.getFechaInicio());
        unidadResponsable.setFechaFinal(unidadResponsableDTO.getFechaFinal());
        unidadResponsable.setEstatus(unidadResponsableDTO.getEstatus());

        return unidadResponsable;
    }
}
