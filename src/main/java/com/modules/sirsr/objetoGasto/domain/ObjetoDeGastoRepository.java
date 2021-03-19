/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.objetoGasto.domain;

import com.modules.sirsr.objetoGasto.domain.ObjetoDeGasto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author Edward Reyes
 */
public interface ObjetoDeGastoRepository extends JpaRepository<ObjetoDeGasto, String>{

}
