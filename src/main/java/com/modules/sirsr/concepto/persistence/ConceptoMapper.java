package com.modules.sirsr.concepto.persistence;

import com.modules.sirsr.capitulo.persistence.CapituloMapper;
import com.modules.sirsr.concepto.domain.ConceptoDTO;
import com.modules.sirsr.estatus.persistence.EstatusMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ConceptoMapper {

    private final EstatusMapper estatusMapper = new EstatusMapper();
    private final CapituloMapper capituloMapper = new CapituloMapper();

    public Concepto toConcepto(ConceptoDTO conceptoDTO){
        Concepto concepto = new Concepto();
        concepto.setClaveConcepto(conceptoDTO.getClaveConcepto());
        concepto.setDescripcion(conceptoDTO.getDescripcion());
        concepto.setDefinicion(conceptoDTO.getDefinicion());
        concepto.setFechaInicio(conceptoDTO.getFechaInicio());
        concepto.setFechaFinal(conceptoDTO.getFechaFinal());
        concepto.setCapitulo(capituloMapper.toCapitulo(conceptoDTO.getCapitulo()));
        concepto.setEstatus(estatusMapper.toEstatus(conceptoDTO.getEstatus()));
        System.out.println(concepto.toString());
        
        return concepto;
    }
    public ConceptoDTO toConceptoDTO(Concepto concepto){
        ConceptoDTO conceptoDTO = new ConceptoDTO();
        conceptoDTO.setClaveConcepto(concepto.getClaveConcepto());
        conceptoDTO.setDescripcion(concepto.getDescripcion());
        conceptoDTO.setDefinicion(concepto.getDefinicion());
        conceptoDTO.setFechaInicio(concepto.getFechaInicio());
        conceptoDTO.setFechaFinal(concepto.getFechaFinal());
        conceptoDTO.setCapitulo(capituloMapper.toCapituloDTO(concepto.getCapitulo()));
        conceptoDTO.setEstatus(estatusMapper.toEstatusDTO(concepto.getEstatus()));
        
        return conceptoDTO;
    }
    public List<ConceptoDTO> toConceptoDTOs(List<Concepto> conceptos){
        if (Objects.isNull(conceptos)) {
            return null;
        }
        List<ConceptoDTO> list = new ArrayList<>(conceptos.size());
        for (Concepto concepto : conceptos) {
            list.add(toConceptoDTO(concepto));
        }
        return list;
    }
}
