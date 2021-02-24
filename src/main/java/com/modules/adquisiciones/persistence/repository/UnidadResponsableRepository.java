/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.persistence.repository;

import com.modules.adquisiciones.persistence.entity.UnidadResponsable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Edward Reyes
 */
public interface UnidadResponsableRepository extends JpaRepository<UnidadResponsable, Integer>{
    
}
