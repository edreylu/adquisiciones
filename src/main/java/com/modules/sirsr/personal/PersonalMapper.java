package com.modules.sirsr.personal;

import com.modules.sirsr.persistence.entity.Personal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PersonalMapper {

    public PersonalDTO toPersonalDTO(Personal personal) {
        if (Objects.isNull(personal)) {
            return null;
        }

        PersonalDTO personalDTO = new PersonalDTO();

        personalDTO.setNoPersonal(personal.getNoPersonal());
        personalDTO.setApellidoPaterno(personal.getApellidoPaterno());
        personalDTO.setApellidoMaterno(personal.getApellidoMaterno());
        personalDTO.setNombre(personal.getNombre());
        personalDTO.setCorreo(personal.getCorreo());
        personalDTO.setTelefonoFijo(personal.getTelefonoFijo());
        personalDTO.setTelefonoMovil(personal.getTelefonoMovil());
        personalDTO.setNombreCompleto(String.format("%s %s %s", personal.getNombre(),personal.getApellidoPaterno(),personal.getApellidoMaterno()));
        

        return personalDTO;
    }
    
    public List<PersonalDTO> toUnidadResponsableDTOs(List<Personal> personales) {
        if (Objects.isNull(personales)) {
            return null;
        }
        List<PersonalDTO> list = new ArrayList<>(personales.size());
        for (Personal personal : personales) {
            list.add(toPersonalDTO(personal));
        }
        return list;
    }

    
}
