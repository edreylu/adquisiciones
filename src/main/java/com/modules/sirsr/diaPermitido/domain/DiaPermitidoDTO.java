package com.modules.sirsr.diaPermitido.domain;

import com.modules.sirsr.estatus.persistence.Estatus;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;


public class DiaPermitidoDTO {

	private Date diaPermitido;
	private Estatus estatus;
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

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
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

	// lo ocupamos para obtener el mes de una fecha en texto
	public String obtenerTextoMes(Date date) {
		Month month = convertToLocalDateViaMilisecond(date).getMonth();
		return month.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
	}

	public int obtenerDia(Date date) {
		int dia = convertToLocalDateViaMilisecond(date).getDayOfMonth();
		return dia;
	}

	public int obtenerMes(Date date) {
		int idMes = convertToLocalDateViaMilisecond(date).getMonthValue();
		return idMes;
	}

	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
		return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
