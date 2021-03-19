package com.modules.sirsr.estatus.application;

import com.modules.sirsr.estatus.domain.Estatus;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class EstatusMapper {

    ModelMapper modelMapper = new ModelMapper();

    public Estatus toEstatus(EstatusDTO estatusDTO){
        
            if (Objects.isNull(estatusDTO)) {
                return null;
            }
            
            Estatus estatus = modelMapper.map(estatusDTO, Estatus.class);
            
            return estatus;
        
    }

    public EstatusDTO toEstatusDTO(Estatus estatus) {

        if (Objects.isNull(estatus)) {
            return null;
        }
        EstatusDTO estatusDTO = modelMapper.map(estatus, EstatusDTO.class);

        return estatusDTO;

    }

    public List<EstatusDTO> toEstatusDTOs(List<Estatus> estatus) {
        if (Objects.isNull(estatus)) {
            return null;
        }
        List<EstatusDTO> list = new ArrayList<>(estatus.size());
        for (Estatus estatusr : estatus) {
            list.add(toEstatusDTO(estatusr));
        }
        return list;
    }

   
}
