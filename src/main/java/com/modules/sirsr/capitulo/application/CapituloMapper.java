package com.modules.sirsr.capitulo.application;

import com.modules.sirsr.capitulo.domain.Capitulo;
import com.modules.sirsr.estatus.application.EstatusMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CapituloMapper {

    private final EstatusMapper estatusMapper = new EstatusMapper();

    public Capitulo toCapitulo(CapituloDTO capituloDTO){
        Capitulo capitulo = new Capitulo();
        capitulo.setClaveCapitulo(capituloDTO.getClaveCapitulo());
        capitulo.setDescripcion(capituloDTO.getDescripcion());
        capitulo.setDefinicion(capituloDTO.getDefinicion());
        capitulo.setFechaInicio(capituloDTO.getFechaInicio());
        capitulo.setFechaFinal(capituloDTO.getFechaFinal());
        capitulo.setEstatus(estatusMapper.toEstatus(capituloDTO.getEstatus()));
        return capitulo;
    }
    public CapituloDTO toCapituloDTO(Capitulo capitulo){
        CapituloDTO capituloDTO = new CapituloDTO();
        capituloDTO.setClaveCapitulo(capitulo.getClaveCapitulo());
        capituloDTO.setDescripcion(capitulo.getDescripcion());
        capituloDTO.setDefinicion(capitulo.getDefinicion());
        capituloDTO.setFechaInicio(capitulo.getFechaInicio());
        capituloDTO.setFechaFinal(capitulo.getFechaFinal());
        capituloDTO.setEstatus(estatusMapper.toEstatusDTO(capitulo.getEstatus()));

        return capituloDTO;
    }
    public List<CapituloDTO> toCapituloDTOs(List<Capitulo> capitulos){
        if (Objects.isNull(capitulos)) {
            return null;
        }
        List<CapituloDTO> list = new ArrayList<>(capitulos.size());
        for (Capitulo capitulo : capitulos) {
            list.add(toCapituloDTO(capitulo));
        }
        return list;
    }
}
