package com.modules.sirsr.montoAdjudicacion.domain;

import com.modules.sirsr.estatus.domain.EstatusDTO;

import java.io.Serializable;

public class MontoAdjudicacionDTO implements Serializable{
	private int montoAdjudicacion;
	private String tipoContratacion;
	private Double importeSuperiorA;
	private Double importeLimite;
	private EstatusDTO estatus;
	
	public MontoAdjudicacionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public MontoAdjudicacionDTO(int montoAdjudicacion, String tipoContratacion, Double importeSuperiorA,
			Double importeLimite, EstatusDTO estatus) {
		this.montoAdjudicacion = montoAdjudicacion;
		this.tipoContratacion = tipoContratacion;
		this.importeSuperiorA = importeSuperiorA;
		this.importeLimite = importeLimite;
		this.estatus = estatus;
	}

	public int getMontoAdjudicacion() {
		return montoAdjudicacion;
	}

	public void setMontoAdjudicacion(int montoAdjudicacion) {
		this.montoAdjudicacion = montoAdjudicacion;
	}

	public String getTipoContratacion() {
		return tipoContratacion;
	}

	public void setTipoContratacion(String tipoContratacion) {
		this.tipoContratacion = tipoContratacion;
	}

	public Double getImporteSuperiorA() {
		return importeSuperiorA;
	}

	public void setImporteSuperiorA(Double importeSuperiorA) {
		this.importeSuperiorA = importeSuperiorA;
	}

	public Double getImporteLimite() {
		return importeLimite;
	}

	public void setImporteLimite(Double importeLimite) {
		this.importeLimite = importeLimite;
	}

	public EstatusDTO getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusDTO estatus) {
		this.estatus = estatus;
	}
}