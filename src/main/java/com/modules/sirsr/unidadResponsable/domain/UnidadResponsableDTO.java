/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.unidadResponsable.domain;

import com.modules.sirsr.estatus.domain.EstatusDTO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Edward Reyes
 */

public class UnidadResponsableDTO implements Serializable{

	private String claveUr;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFinal;
	private EstatusDTO estatus;
	
	public UnidadResponsableDTO() {
	
	}

	
	public UnidadResponsableDTO(String claveUr, String descripcion, Date fechaInicio, Date fechaFinal,
			EstatusDTO estatus) {
		this.claveUr = claveUr;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.estatus = estatus;
	}


	public String getClaveUr() {
		return claveUr;
	}

	public void setClaveUr(String claveUr) {
		this.claveUr = claveUr;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public EstatusDTO getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusDTO estatus) {
		this.estatus = estatus;
	}

}
