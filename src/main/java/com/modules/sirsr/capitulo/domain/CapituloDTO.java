/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.capitulo.domain;

import com.modules.sirsr.estatus.domain.EstatusDTO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Edward Reyes
 */
public class CapituloDTO implements Serializable{
	private Integer claveCapitulo;
	private String descripcion;
	private String definicion;
	private Date fechaInicio;
	private Date fechaFinal;
	private EstatusDTO estatus;
	
	public CapituloDTO() {
		// TODO Auto-generated constructor stub
	}

	public CapituloDTO(Integer claveCapitulo, String descripcion, String definicion, Date fechaInicio, Date fechaFinal,
			EstatusDTO estatus) {
		this.claveCapitulo = claveCapitulo;
		this.descripcion = descripcion;
		this.definicion = definicion;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.estatus = estatus;
	}

	public Integer getClaveCapitulo() {
		return claveCapitulo;
	}

	public void setClaveCapitulo(Integer claveCapitulo) {
		this.claveCapitulo = claveCapitulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDefinicion() {
		return definicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
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
