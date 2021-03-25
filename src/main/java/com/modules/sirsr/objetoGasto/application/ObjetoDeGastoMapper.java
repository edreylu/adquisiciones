package com.modules.sirsr.objetoGasto.application;

import com.modules.sirsr.estatus.application.EstatusMapper;
import com.modules.sirsr.objetoGasto.domain.ObjetoDeGasto;
import com.modules.sirsr.partidaGastoGenerica.application.PartidaGastoGenericaMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ObjetoDeGastoMapper {
    private final EstatusMapper estatusMapper = new EstatusMapper();
    private final PartidaGastoGenericaMapper partidaGastoGenericaMapper = new PartidaGastoGenericaMapper();

    public ObjetoDeGasto toObjetoDeGasto(ObjetoDeGastoDTO objetoDeGastoDTO){
        ObjetoDeGasto objetoDeGasto = new ObjetoDeGasto();
        objetoDeGasto.setObjetoGasto(objetoDeGastoDTO.getObjetoGasto());
        objetoDeGasto.setDefinicion(objetoDeGastoDTO.getDefinicion());
        objetoDeGasto.setFechaInicio(objetoDeGastoDTO.getFechaInicio());
        objetoDeGasto.setFechaFinal(objetoDeGastoDTO.getFechaFinal());
        objetoDeGasto.setDescripcion(objetoDeGastoDTO.getDescripcion());
        objetoDeGasto.setPartidaGastoGenerica(partidaGastoGenericaMapper.toPartidaGastoGenerica(objetoDeGastoDTO.getClaveGenerica()));
        objetoDeGasto.setEstatus(estatusMapper.toEstatus(objetoDeGastoDTO.getEstatus()));
        return objetoDeGasto;
    }
    public ObjetoDeGastoDTO toObjetoDeGastoDTO(ObjetoDeGasto objetoDeGasto){
        ObjetoDeGastoDTO objetoDeGastoDTO = new ObjetoDeGastoDTO();
        objetoDeGastoDTO.setObjetoGasto(objetoDeGasto.getObjetoGasto());
        objetoDeGastoDTO.setDefinicion(objetoDeGasto.getDefinicion());
        objetoDeGastoDTO.setFechaInicio(objetoDeGasto.getFechaInicio());
        objetoDeGastoDTO.setFechaFinal(objetoDeGasto.getFechaFinal());
        objetoDeGastoDTO.setDescripcion(objetoDeGasto.getDescripcion());
        objetoDeGastoDTO.setClaveGenerica(partidaGastoGenericaMapper.toPartidaGastoGenericaDTO(objetoDeGasto.getPartidaGastoGenerica()));
        objetoDeGastoDTO.setEstatus(estatusMapper.toEstatusDTO(objetoDeGasto.getEstatus()));
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
