package com.modules.sirsr.PartidaGasto;

import com.modules.sirsr.persistence.entity.PartidaGastoEspecifica;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class PartidaGastoEspecificaMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public PartidaGastoEspecifica toPartidaGastoEspecifica(PartidaGastoEspecificaDTO partidaGastoEspecificaDTO){
        PartidaGastoEspecifica partidaGastoEspecifica = modelMapper.map(partidaGastoEspecificaDTO, PartidaGastoEspecifica.class);
        return partidaGastoEspecifica;
    }
    public PartidaGastoEspecificaDTO toPartidaGastoEspecificaDTO(PartidaGastoEspecifica partidaGastoEspecifica){
        PartidaGastoEspecificaDTO partidaGastoEspecificaDTO = modelMapper.map(partidaGastoEspecifica, PartidaGastoEspecificaDTO.class);
        return partidaGastoEspecificaDTO;
    }
    public List<PartidaGastoEspecificaDTO> toPartidaGastoEspecificaDTOs(List<PartidaGastoEspecifica> partidaGastoEspecificas){
        if (Objects.isNull(partidaGastoEspecificas)) {
            return null;
        }
        List<PartidaGastoEspecificaDTO> list = new ArrayList<>(partidaGastoEspecificas.size());
        for (PartidaGastoEspecifica partidaGastoEspecifica : partidaGastoEspecificas) {
            list.add(toPartidaGastoEspecificaDTO(partidaGastoEspecifica));
        }
        return list;
    }
}
