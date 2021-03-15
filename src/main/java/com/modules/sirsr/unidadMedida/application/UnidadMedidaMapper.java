package com.modules.sirsr.unidadMedida.application;

import com.modules.sirsr.unidadMedida.domain.UnidadMedida;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UnidadMedidaMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public UnidadMedida toUnidadMedida(UnidadMedidaDTO unidadMedidaDTO){
        UnidadMedida unidadMedida = modelMapper.map(unidadMedidaDTO, UnidadMedida.class);
        return unidadMedida;
    }
    public UnidadMedidaDTO toUnidadMedidaDTO(UnidadMedida unidadMedida){
        UnidadMedidaDTO unidadMedidaDTO = modelMapper.map(unidadMedida, UnidadMedidaDTO.class);
        return unidadMedidaDTO;
    }
    public List<UnidadMedidaDTO> toUnidadMedidaDTOs(List<UnidadMedida> unidadMedidas){
        if (Objects.isNull(unidadMedidas)) {
            return null;
        }
        List<UnidadMedidaDTO> list = new ArrayList<>(unidadMedidas.size());
        for (UnidadMedida unidadMedida : unidadMedidas) {
            list.add(toUnidadMedidaDTO(unidadMedida));
        }
        return list;
    }
}
