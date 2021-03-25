package com.modules.sirsr.partidaGastoGenerica.application;

import com.modules.sirsr.concepto.application.ConceptoMapper;
import com.modules.sirsr.estatus.application.EstatusMapper;
import com.modules.sirsr.partidaGastoGenerica.domain.PartidaGastoGenerica;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class PartidaGastoGenericaMapper {

    private final EstatusMapper estatusMapper = new EstatusMapper();
    private final ConceptoMapper conceptoMapper = new ConceptoMapper();

    public PartidaGastoGenerica toPartidaGastoGenerica(PartidaGastoGenericaDTO partidaGastoGenericaDTO){
        PartidaGastoGenerica partidaGastoGenerica = new PartidaGastoGenerica();
        partidaGastoGenerica.setClaveGenerica(partidaGastoGenericaDTO.getClaveGenerica());
        partidaGastoGenerica.setDescripcion(partidaGastoGenericaDTO.getDescripcion());
        partidaGastoGenerica.setDefinicion(partidaGastoGenericaDTO.getDefinicion());
        partidaGastoGenerica.setFechaInicio(partidaGastoGenericaDTO.getFechaInicio());
        partidaGastoGenerica.setFechaFinal(partidaGastoGenericaDTO.getFechaFinal());
        partidaGastoGenerica.setConcepto(conceptoMapper.toConcepto(partidaGastoGenericaDTO.getConcepto()));
        partidaGastoGenerica.setEstatus(estatusMapper.toEstatus(partidaGastoGenericaDTO.getEstatus()));
        return partidaGastoGenerica;
    }
    public PartidaGastoGenericaDTO toPartidaGastoGenericaDTO(PartidaGastoGenerica partidaGastoGenerica){
        PartidaGastoGenericaDTO partidaGastoGenericaDTO = new PartidaGastoGenericaDTO();
        partidaGastoGenericaDTO.setClaveGenerica(partidaGastoGenerica.getClaveGenerica());
        partidaGastoGenericaDTO.setDescripcion(partidaGastoGenerica.getDescripcion());
        partidaGastoGenericaDTO.setDefinicion(partidaGastoGenerica.getDefinicion());
        partidaGastoGenericaDTO.setFechaInicio(partidaGastoGenerica.getFechaInicio());
        partidaGastoGenericaDTO.setFechaFinal(partidaGastoGenerica.getFechaFinal());
        partidaGastoGenericaDTO.setConcepto(conceptoMapper.toConceptoDTO(partidaGastoGenerica.getConcepto()));
        partidaGastoGenericaDTO.setEstatus(estatusMapper.toEstatusDTO(partidaGastoGenerica.getEstatus()));

        return partidaGastoGenericaDTO;
    }
    public List<PartidaGastoGenericaDTO> toPartidaGastoGenericaDTOs(List<PartidaGastoGenerica> partidaGastoGenericas){
        if (Objects.isNull(partidaGastoGenericas)) {
            return null;
        }
        List<PartidaGastoGenericaDTO> list = new ArrayList<>(partidaGastoGenericas.size());
        for (PartidaGastoGenerica partidaGastoGenerica : partidaGastoGenericas) {
            list.add(toPartidaGastoGenericaDTO(partidaGastoGenerica));
        }
        return list;
    }
}
