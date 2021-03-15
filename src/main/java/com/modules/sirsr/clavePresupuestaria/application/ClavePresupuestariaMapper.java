package com.modules.sirsr.clavePresupuestaria.application;

import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestaria;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Component
public class ClavePresupuestariaMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public ClavePresupuestaria toClavePresupuestaria(ClavePresupuestariaDTO clavePresupuestariaDTO){
        ClavePresupuestaria clavePresupuestaria = modelMapper.map(clavePresupuestariaDTO, ClavePresupuestaria.class);
        return clavePresupuestaria;
    }
    public ClavePresupuestariaDTO toClavePresupuestariaDTO(ClavePresupuestaria clavePresupuestaria){
        ClavePresupuestariaDTO clavePresupuestariaDTO = modelMapper.map(clavePresupuestaria, ClavePresupuestariaDTO.class);
        clavePresupuestariaDTO.setClaveCompleta(getClaveCompleta.apply(clavePresupuestariaDTO));
        return clavePresupuestariaDTO;
    }
    public List<ClavePresupuestariaDTO> toClavePresupuestariaDTOs(List<ClavePresupuestaria> clavesPresupuestarias){
        if (Objects.isNull(clavesPresupuestarias)) {
            return null;
        }
        List<ClavePresupuestariaDTO> list = new ArrayList<>(clavesPresupuestarias.size());
        for (ClavePresupuestaria clavePresupuestaria : clavesPresupuestarias) {
            list.add(toClavePresupuestariaDTO(clavePresupuestaria));
        }
        return list;
    }

    Function<ClavePresupuestariaDTO, String> getClaveCompleta =
            (clave) -> String.format("%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s",
                clave.getAnio(),
                clave.getRamo(),
                clave.getInstitucion(),
                clave.getUnidadResponsable().getClaveUr(),
                clave.getFinalidad(),
                clave.getFuncion(),
                clave.getSubfuncion(),
                clave.getProgramaPresupuestario(),
                clave.getSubprogramaPresupuestario(),
                clave.getActividadInstitucional(),
                clave.getIdentificadorGasto(),
                clave.getFuenteFinanciamiento(),
                clave.getOrigen(),
                clave.getProcedencia(),
                clave.getActividadEspecifica(),
                clave.getObjetoGasto().getObjetoGasto(),
                clave.getTipoGasto(),
                clave.getRegion(),
                clave.getMunicipio(),
                clave.getPpi());
}
