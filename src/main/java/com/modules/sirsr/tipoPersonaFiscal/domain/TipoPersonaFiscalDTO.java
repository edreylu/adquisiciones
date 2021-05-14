package com.modules.sirsr.tipoPersonaFiscal.domain;

import java.io.Serializable;

public class TipoPersonaFiscalDTO implements Serializable {

	private Integer idTipoPersonaFiscal;
	private String descripcion;
	private Integer idEstatus;

	public Integer getIdTipoPersonaFiscal() {
		return idTipoPersonaFiscal;
	}

	public void setIdTipoPersonaFiscal(Integer idTipoPersonaFiscal) {
		this.idTipoPersonaFiscal = idTipoPersonaFiscal;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
