/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.tipoDocumento.domain;

import com.modules.sirsr.tipoDocumento.domain.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author Edward Reyes
 */
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer>{
    List<TipoDocumento> findByIdTipoDocumentoNotIn(List<Integer> tiposDocumento);
}
