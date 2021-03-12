/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.personal;

import com.modules.sirsr.persistence.entity.DatosPersonales;
import com.modules.sirsr.persistence.repository.DatosPersonalesRepository;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 *
 * @author Edward Reyes
 */
@Service
public class PersonalService {

    private final DatosPersonalesRepository datosPersonalesRepository;
    private final DatosPersonalesMapper datosPersonalesMapper;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    public PersonalService(DatosPersonalesRepository datosPersonalesRepository, DatosPersonalesMapper datosPersonalesMapper) {
        this.datosPersonalesRepository = datosPersonalesRepository;
        this.datosPersonalesMapper = datosPersonalesMapper;
    }

    public List<DatosPersonalesDTO> findAll() {
        return datosPersonalesMapper.toUnidadResponsableDTOs(datosPersonalesRepository.findAll());
    }
    
    public List<DatosPersonalesDTO> findByNoPersonal(int noPersonal) {
        return datosPersonalesMapper.toUnidadResponsableDTOs(datosPersonalesRepository.findByNoPersonal(noPersonal));
    }
    public DatosPersonales findByCorreo(String email) {
        DatosPersonales personal = datosPersonalesRepository.findByCorreo(email);
        return personal;
    }

    public DatosPersonalesDTO findById(int id) {
        DatosPersonales personal = datosPersonalesRepository.findById(id).get();
        return datosPersonalesMapper.toPersonalDTO(personal);
    }

}
