/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Edward Reyes
 */
public interface RequisicionRepository extends JpaRepository<Requisicion, Integer> {

	List<Requisicion> findByIdSolicitud(Integer idSolicitud);

}
