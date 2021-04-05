package com.modules.sirsr.clavePresupuestaria.persistence;

import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestariaDTO;
import com.modules.sirsr.objetoGasto.persistence.ObjetoDeGastoMapper;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsableMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Component
public class ClavePresupuestariaMapper {

    private final UnidadResponsableMapper unidadResponsableMapper = new UnidadResponsableMapper();
    private final ObjetoDeGastoMapper objetoDeGastoMapper = new ObjetoDeGastoMapper();

    public ClavePresupuestaria toClavePresupuestaria(ClavePresupuestariaDTO clavePresupuestariaDTO){
        ClavePresupuestaria clavePresupuestaria = new ClavePresupuestaria();
        clavePresupuestaria.setIdClavePresup(clavePresupuestariaDTO.getIdClavePresup());
        clavePresupuestaria.setAnio(clavePresupuestariaDTO.getAnio());
        clavePresupuestaria.setRamo(clavePresupuestariaDTO.getRamo());
        clavePresupuestaria.setInstitucion(clavePresupuestariaDTO.getInstitucion());
        clavePresupuestaria.setUnidadResponsable(unidadResponsableMapper.toUnidadResponsable(clavePresupuestariaDTO.getUnidadResponsable()));
        clavePresupuestaria.setFinalidad(clavePresupuestariaDTO.getFinalidad());
        clavePresupuestaria.setFuncion(clavePresupuestariaDTO.getFuncion());
        clavePresupuestaria.setSubfuncion(clavePresupuestariaDTO.getSubfuncion());
        clavePresupuestaria.setProgramaPresupuestario(clavePresupuestariaDTO.getProgramaPresupuestario());
        clavePresupuestaria.setSubprogramaPresupuestario(clavePresupuestariaDTO.getSubprogramaPresupuestario());
        clavePresupuestaria.setActividadInstitucional(clavePresupuestariaDTO.getActividadInstitucional());
        clavePresupuestaria.setIdentificadorGasto(clavePresupuestariaDTO.getIdentificadorGasto());
        clavePresupuestaria.setFuenteFinanciamiento(clavePresupuestariaDTO.getFuenteFinanciamiento());
        clavePresupuestaria.setOrigen(clavePresupuestariaDTO.getOrigen());
        clavePresupuestaria.setProcedencia(clavePresupuestariaDTO.getProcedencia());
        clavePresupuestaria.setActividadEspecifica(clavePresupuestariaDTO.getActividadEspecifica());
        clavePresupuestaria.setObjetoDeGasto(objetoDeGastoMapper.toObjetoDeGasto(clavePresupuestariaDTO.getObjetoDeGasto()));
        clavePresupuestaria.setTipoGasto(clavePresupuestariaDTO.getTipoGasto());
        clavePresupuestaria.setRegion(clavePresupuestariaDTO.getRegion());
        clavePresupuestaria.setMunicipio(clavePresupuestariaDTO.getMunicipio());
        clavePresupuestaria.setPpi(clavePresupuestariaDTO.getPpi());
        return clavePresupuestaria;
    }
    public ClavePresupuestariaDTO toClavePresupuestariaDTO(ClavePresupuestaria clavePresupuestaria){
        ClavePresupuestariaDTO clavePresupuestariaDTO = new ClavePresupuestariaDTO();
        clavePresupuestariaDTO.setIdClavePresup(clavePresupuestaria.getIdClavePresup());
        clavePresupuestariaDTO.setAnio(clavePresupuestaria.getAnio());
        clavePresupuestariaDTO.setRamo(clavePresupuestaria.getRamo());
        clavePresupuestariaDTO.setInstitucion(clavePresupuestaria.getInstitucion());
        clavePresupuestariaDTO.setUnidadResponsable(unidadResponsableMapper.toUnidadResponsableDTO(clavePresupuestaria.getUnidadResponsable()));
        clavePresupuestariaDTO.setFinalidad(clavePresupuestaria.getFinalidad());
        clavePresupuestariaDTO.setFuncion(clavePresupuestaria.getFuncion());
        clavePresupuestariaDTO.setSubfuncion(clavePresupuestaria.getSubfuncion());
        clavePresupuestariaDTO.setProgramaPresupuestario(clavePresupuestaria.getProgramaPresupuestario());
        clavePresupuestariaDTO.setSubprogramaPresupuestario(clavePresupuestaria.getSubprogramaPresupuestario());
        clavePresupuestariaDTO.setActividadInstitucional(clavePresupuestaria.getActividadInstitucional());
        clavePresupuestariaDTO.setIdentificadorGasto(clavePresupuestaria.getIdentificadorGasto());
        clavePresupuestariaDTO.setFuenteFinanciamiento(clavePresupuestaria.getFuenteFinanciamiento());
        clavePresupuestariaDTO.setOrigen(clavePresupuestaria.getOrigen());
        clavePresupuestariaDTO.setProcedencia(clavePresupuestaria.getProcedencia());
        clavePresupuestariaDTO.setActividadEspecifica(clavePresupuestaria.getActividadEspecifica());
        clavePresupuestariaDTO.setObjetoDeGasto(objetoDeGastoMapper.toObjetoDeGastoDTO(clavePresupuestaria.getObjetoDeGasto()));
        clavePresupuestariaDTO.setTipoGasto(clavePresupuestaria.getTipoGasto());
        clavePresupuestariaDTO.setRegion(clavePresupuestaria.getRegion());
        clavePresupuestariaDTO.setMunicipio(clavePresupuestaria.getMunicipio());
        clavePresupuestariaDTO.setPpi(clavePresupuestaria.getPpi());
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
                clave.getObjetoDeGasto().getObjetoGasto(),
                clave.getTipoGasto(),
                clave.getRegion(),
                clave.getMunicipio(),
                clave.getPpi());
}
