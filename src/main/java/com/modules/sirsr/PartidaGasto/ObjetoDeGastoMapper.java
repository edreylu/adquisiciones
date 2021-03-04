package com.modules.sirsr.PartidaGasto;

import com.modules.sirsr.persistence.entity.ObjetoDeGasto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ObjetoDeGastoMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public ObjetoDeGasto toObjetoDeGasto(ObjetoDeGastoDTO objetoDeGastoDTO){
        ObjetoDeGasto objetoDeGasto = modelMapper.map(objetoDeGastoDTO, ObjetoDeGasto.class);
        return objetoDeGasto;
    }
    public ObjetoDeGastoDTO toObjetoDeGastoDTO(ObjetoDeGasto objetoDeGasto){
        ObjetoDeGastoDTO objetoDeGastoDTO = modelMapper.map(objetoDeGasto, ObjetoDeGastoDTO.class);
        return objetoDeGastoDTO;
    }
    public List<ObjetoDeGastoDTO> toObjetoDeGastoDTOs(List<ObjetoDeGasto> objetosDeGasto){
        if (Objects.isNull(objetosDeGasto)) {
            return null;
        }
        List<ObjetoDeGastoDTO> list = new ArrayList<>(objetosDeGasto.size());
        for (ObjetoDeGasto objetoDeGasto : objetosDeGasto) {
            list.add(toObjetoDeGastoDTO(objetoDeGasto));
        }
        return list;
    }
}
