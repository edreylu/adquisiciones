/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.partidaGastoGenerica.persistence;

import com.modules.sirsr.concepto.persistence.Concepto;
import com.modules.sirsr.estatus.persistence.Estatus;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "PARTIDA_GASTO_GENERICA")
public class PartidaGastoGenerica {

	@Id
	@Basic(optional = false)
	@Column(name = "CLAVE_GENERICA")
	private Integer claveGenerica;
	@Basic(optional = false)
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "DEFINICION")
	private String definicion;
	@Basic(optional = false)
	@Column(name = "FECHA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	@Column(name = "FECHA_FINAL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinal;
	@JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
	@ManyToOne(optional = false)
	private Estatus estatus;
	@JoinColumn(name = "CLAVE_CONCEPTO", referencedColumnName = "CLAVE_CONCEPTO")
	@ManyToOne(optional = false)
	private Concepto concepto;
	
	public PartidaGastoGenerica() {
		// TODO Auto-generated constructor stub
	}

	public PartidaGastoGenerica(Integer claveGenerica, String descripcion, String definicion, Date fechaInicio,
			Date fechaFinal, Estatus estatus, Concepto concepto) {
		this.claveGenerica = claveGenerica;
		this.descripcion = descripcion;
		this.definicion = definicion;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.estatus = estatus;
		this.concepto = concepto;
	}


	public Integer getClaveGenerica() {
		return claveGenerica;
	}

	public void setClaveGenerica(Integer claveGenerica) {
		this.claveGenerica = claveGenerica;
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

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

}
