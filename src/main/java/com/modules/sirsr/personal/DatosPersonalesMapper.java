package com.modules.sirsr.personal;

import java.util.ArrayList;
import java.util.List;

import com.modules.sirsr.persistence.entity.DatosPersonales;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.function.Function;

@Component
public class DatosPersonalesMapper {

    public DatosPersonalesDTO toPersonalDTO(DatosPersonales personal) {
        if (Objects.isNull(personal)) {
            return null;
        }

        DatosPersonalesDTO datosPersonalesDTO = new DatosPersonalesDTO();

        datosPersonalesDTO.setNoPersonal(personal.getNoPersonal());
        datosPersonalesDTO.setApellidoPaterno(personal.getApellidoPaterno());
        datosPersonalesDTO.setApellidoMaterno(personal.getApellidoMaterno());
        datosPersonalesDTO.setNombre(personal.getNombre());
        datosPersonalesDTO.setCorreo(personal.getCorreo());
        datosPersonalesDTO.setTelefonoFijo(personal.getTelefonoFijo());
        datosPersonalesDTO.setTelefonoMovil(personal.getTelefonoMovil());
        datosPersonalesDTO.setNombreCompleto(getNombreCompleto.apply(datosPersonalesDTO));
        

        return datosPersonalesDTO;
    }
    
    public List<DatosPersonalesDTO> toUnidadResponsableDTOs(List<DatosPersonales> personales) {
        if (Objects.isNull(personales)) {
            return null;
        }
        List<DatosPersonalesDTO> list = new ArrayList<>(personales.size());
        for (DatosPersonales personal : personales) {
            list.add(toPersonalDTO(personal));
        }
        return list;
    }

    private Function<DatosPersonalesDTO, String> getNombreCompleto =
            personal -> String.format("%s %s %s", personal.getNombre(),personal.getApellidoPaterno(),personal.getApellidoMaterno());
}
