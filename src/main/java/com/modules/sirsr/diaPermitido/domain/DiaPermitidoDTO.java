package com.modules.sirsr.diaPermitido.domain;

import java.io.Serializable;
import java.util.Date;

import com.modules.sirsr.estatus.domain.EstatusDTO;

public class DiaPermitidoDTO implements Serializable {

	private Date diaPermitido;
	private EstatusDTO estatus;
	private Integer anio;
	private String mes;
	private Integer idDia;
	private int idMes;
	private Date diaPermitidoInicio;
	private Date diaPermitidoFin;

	public Date getDiaPermitido() {
		return diaPermitido;
	}

	public void setDiaPermitido(Date diaPermitido) {
		this.diaPermitido = diaPermitido;
	}

	public EstatusDTO getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusDTO estatus) {
		this.estatus = estatus;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getMes() {

		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Integer getIdDia() {
		return idDia;
	}

	public void setIdDia(Integer idDia) {
		this.idDia = idDia;
	}

	public int getIdMes() {
		return idMes;
	}

	public void setIdMes(int idMes) {
		this.idMes = idMes;
	}

	public Date getDiaPermitidoInicio() {
		return diaPermitidoInicio;
	}

	public void setDiaPermitidoInicio(Date diaPermitidoInicio) {
		this.diaPermitidoInicio = diaPermitidoInicio;
	}

	public Date getDiaPermitidoFin() {
		return diaPermitidoFin;
	}

	public void setDiaPermitidoFin(Date diaPermitidoFin) {
		this.diaPermitidoFin = diaPermitidoFin;
	}

}
