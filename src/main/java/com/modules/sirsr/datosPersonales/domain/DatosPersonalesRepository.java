/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.datosPersonales.domain;

import java.util.List;

import com.modules.sirsr.datosPersonales.domain.DatosPersonales;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Edward Reyes
 */
public interface DatosPersonalesRepository extends JpaRepository<DatosPersonales, Integer>{

    DatosPersonales findByCorreo(String email);
    List<DatosPersonales> findByNoPersonal(Integer noPersonal);
    
}
