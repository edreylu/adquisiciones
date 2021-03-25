package com.modules.sirsr.folioRequisicion.application;

import com.modules.sirsr.estatus.domain.Estatus;

public class FolioRequisicionDTO {

	private Integer anio;
	private Integer consecutivo;
	private Estatus estatus;
	
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(Integer consecutivo) {
		this.consecutivo = consecutivo;
	}
	public Estatus getEstatus() {
		return estatus;
	}
	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}
    
	
}
