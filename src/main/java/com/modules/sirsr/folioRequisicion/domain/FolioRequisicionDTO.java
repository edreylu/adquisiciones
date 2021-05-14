package com.modules.sirsr.folioRequisicion.domain;

import java.io.Serializable;

import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.estatus.persistence.Estatus;

public class FolioRequisicionDTO implements Serializable {

	private Integer anio;
	private Integer consecutivo;
	private EstatusDTO estatus;

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

	public EstatusDTO getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusDTO estatus) {
		this.estatus = estatus;
	}

}
