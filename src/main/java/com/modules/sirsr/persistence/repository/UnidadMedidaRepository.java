/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.repository;

import com.modules.sirsr.persistence.entity.UnidadMedida;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Edward Reyes
 */
public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida, Integer>{
    
}
