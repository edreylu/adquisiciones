/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.datosPersonales.domain;

import com.modules.sirsr.datosPersonales.persistence.DatosPersonales;
import com.modules.sirsr.datosPersonales.persistence.DatosPersonalesMapper;
import com.modules.sirsr.datosPersonales.persistence.DatosPersonalesRepository;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 *
 * @author Edward Reyes
 */
@Service
public class DatosPersonalesService {

    private final DatosPersonalesRepository datosPersonalesRepository;
    private final DatosPersonalesMapper datosPersonalesMapper;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    public DatosPersonalesService(DatosPersonalesRepository datosPersonalesRepository, DatosPersonalesMapper datosPersonalesMapper) {
        this.datosPersonalesRepository = datosPersonalesRepository;
        this.datosPersonalesMapper = datosPersonalesMapper;
    }

    public List<DatosPersonalesDTO> findAll() {
        return datosPersonalesMapper.toUnidadResponsableDTOs(datosPersonalesRepository.findAll());
    }
    
    public List<DatosPersonalesDTO> findByNoPersonal(int noPersonal) {
        return datosPersonalesMapper.toUnidadResponsableDTOs(datosPersonalesRepository.findByNoPersonal(noPersonal));
    }
    
    public List<DatosPersonalesDTO> findByNombrePersonal(String nombrePersonal) {
        return datosPersonalesMapper.toUnidadResponsableDTOs(datosPersonalesRepository
                .findByNombreIgnoreCaseContainingOrApellidoPaternoIgnoreCaseContainingOrApellidoMaternoIgnoreCaseContaining(nombrePersonal,nombrePersonal,nombrePersonal));
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
