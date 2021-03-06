package com.modules.sirsr.unidadMedida.domain;

import java.io.Serializable;

import com.modules.sirsr.estatus.domain.EstatusDTO;

public class UnidadMedidaDTO implements Serializable{
	private Integer idUnidadMedida;
	private String claveUnidad;
	private String nombre;
	private String descripcion;
	private EstatusDTO estatus;
	
	public UnidadMedidaDTO() {
		// TODO Auto-generated constructor stub
	}

	public UnidadMedidaDTO(Integer idUnidadMedida, String claveUnidad, String nombre, String descripcion,
			EstatusDTO estatus) {
		this.idUnidadMedida = idUnidadMedida;
		this.claveUnidad = claveUnidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	public Integer getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(Integer idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	public String getClaveUnidad() {
		return claveUnidad;
	}

	public void setClaveUnidad(String claveUnidad) {
		this.claveUnidad = claveUnidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
