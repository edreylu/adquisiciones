/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author Edward Reyes
 */
public interface DetalleRequisicionRepository extends JpaRepository<DetalleRequisicion, Integer> {
	List<DetalleRequisicion> findByIdRequisicion(Integer idRequisicion);
}
