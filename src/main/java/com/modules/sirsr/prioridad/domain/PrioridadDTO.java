/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.prioridad.domain;

import java.io.Serializable;

import com.modules.sirsr.estatus.domain.EstatusDTO;

/**
 *
 * @author Edward Reyes
 */
public class PrioridadDTO implements Serializable{

	private Integer idPrioridad;
	private String descripcion;
	private EstatusDTO estatus;
	
	public PrioridadDTO() {
	
	}

	public PrioridadDTO(Integer idPrioridad, String descripcion, EstatusDTO estatus) {
		this.idPrioridad = idPrioridad;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}


	public Integer getIdPrioridad() {
		return idPrioridad;
	}

	public void setIdPrioridad(Integer idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstatusDTO getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusDTO estatus) {
		this.estatus = estatus;
	}

}
