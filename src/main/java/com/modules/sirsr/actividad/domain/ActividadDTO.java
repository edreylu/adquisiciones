package com.modules.sirsr.actividad.domain;

import com.modules.sirsr.estatus.domain.EstatusDTO;


public class ActividadDTO {
	
	private Integer idActividad;
	private String descripcion;
	private EstatusDTO estatus;
	
	public Integer getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
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
