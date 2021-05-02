/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.persistence;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author Edward Reyes
 */
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
	List<Solicitud> findByClaveUr(String claveUr, Sort sort);

	List<Solicitud> findByIdEstatusGreaterThanEqual(Integer idEstatus);
}
