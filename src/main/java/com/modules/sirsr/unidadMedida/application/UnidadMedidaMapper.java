package com.modules.sirsr.unidadMedida.application;

import com.modules.sirsr.estatus.application.EstatusMapper;
import com.modules.sirsr.unidadMedida.domain.UnidadMedida;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UnidadMedidaMapper {

    private final EstatusMapper estatusMapper = new EstatusMapper();
    public UnidadMedida toUnidadMedida(UnidadMedidaDTO unidadMedidaDTO){
        UnidadMedida unidadMedida = new UnidadMedida();
        unidadMedida.setIdUnidadMedida(unidadMedidaDTO.getIdUnidadMedida());
        unidadMedida.setClaveUnidad(unidadMedidaDTO.getClaveUnidad());
        unidadMedida.setDescripcion(unidadMedidaDTO.getDescripcion());
        unidadMedida.setNombre(unidadMedidaDTO.getNombre());
        unidadMedida.setEstatus(estatusMapper.toEstatus(unidadMedidaDTO.getEstatus()));
        return unidadMedida;
    }
    public UnidadMedidaDTO toUnidadMedidaDTO(UnidadMedida unidadMedida){
        UnidadMedidaDTO unidadMedidaDTO = new UnidadMedidaDTO();
        unidadMedidaDTO.setIdUnidadMedida(unidadMedida.getIdUnidadMedida());
        unidadMedidaDTO.setClaveUnidad(unidadMedida.getClaveUnidad());
        unidadMedidaDTO.setDescripcion(unidadMedida.getDescripcion());
        unidadMedidaDTO.setNombre(unidadMedida.getNombre());
        unidadMedidaDTO.setEstatus(estatusMapper.toEstatusDTO(unidadMedida.getEstatus()));
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
