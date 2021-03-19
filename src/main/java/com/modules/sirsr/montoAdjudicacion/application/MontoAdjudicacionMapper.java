package com.modules.sirsr.montoAdjudicacion.application;

import com.modules.sirsr.montoAdjudicacion.domain.MontoAdjudicacion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class MontoAdjudicacionMapper {
    
    private ModelMapper modelMapper = new ModelMapper();

    public MontoAdjudicacionDTO toMontoAdjudicacionDTO(MontoAdjudicacion montoAdjudicacion){
        if (Objects.isNull(montoAdjudicacion)) {
            return null;
        }

        MontoAdjudicacionDTO montoAdjudicacionDTO = modelMapper.map(montoAdjudicacion, MontoAdjudicacionDTO.class);

        return montoAdjudicacionDTO;
    }

    public List<MontoAdjudicacionDTO> toMontoAdjudicacionsDTOs(List<MontoAdjudicacion> montoAdjudicacions) {
        if (Objects.isNull(montoAdjudicacions)) {
            return null;
        }

        List<MontoAdjudicacionDTO> list = new ArrayList<>(montoAdjudicacions.size());
        for (MontoAdjudicacion montoAdjudicacion : montoAdjudicacions) {
            list.add(toMontoAdjudicacionDTO(montoAdjudicacion));
        }

        return list;
    }

    public MontoAdjudicacion toMontoAdjudicacion(MontoAdjudicacionDTO montoAdjudicacionDTO) {
        if (Objects.isNull(montoAdjudicacionDTO)) {
            return null;
        }
        MontoAdjudicacion montoAdjudicacion = new MontoAdjudicacion();
        return montoAdjudicacion;
    }

}
