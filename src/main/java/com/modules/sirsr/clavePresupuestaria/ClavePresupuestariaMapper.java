package com.modules.sirsr.clavePresupuestaria;

import com.modules.sirsr.persistence.entity.ClavePresupuestaria;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ClavePresupuestariaMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public ClavePresupuestaria toClavePresupuestaria(ClavePresupuestariaDTO clavePresupuestariaDTO){
        ClavePresupuestaria clavePresupuestaria = modelMapper.map(clavePresupuestariaDTO, ClavePresupuestaria.class);
        return clavePresupuestaria;
    }
    public ClavePresupuestariaDTO toClavePresupuestariaDTO(ClavePresupuestaria clavePresupuestaria){
        ClavePresupuestariaDTO clavePresupuestariaDTO = modelMapper.map(clavePresupuestaria, ClavePresupuestariaDTO.class);
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
}
