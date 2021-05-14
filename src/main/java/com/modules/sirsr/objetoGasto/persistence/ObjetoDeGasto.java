/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.objetoGasto.persistence;

import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.partidaGastoGenerica.persistence.PartidaGastoGenerica;

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
@Table(name = "OBJETO_DE_GASTO")
public class ObjetoDeGasto {

	@Id
	@Basic(optional = false)
	@Column(name = "OBJETO_GASTO")
	private String objetoGasto;
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
	@JoinColumn(name = "CLAVE_GENERICA", referencedColumnName = "CLAVE_GENERICA")
	@ManyToOne(optional = false)
	private PartidaGastoGenerica partidaGastoGenerica;
	@JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
	@ManyToOne(optional = false)
	private Estatus estatus;
	
	public ObjetoDeGasto() {
		// TODO Auto-generated constructor stub
	}

	public ObjetoDeGasto(String objetoGasto, String descripcion, String definicion, Date fechaInicio, Date fechaFinal,
			PartidaGastoGenerica partidaGastoGenerica, Estatus estatus) {
		this.objetoGasto = objetoGasto;
		this.descripcion = descripcion;
		this.definicion = definicion;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.partidaGastoGenerica = partidaGastoGenerica;
		this.estatus = estatus;
	}


	public String getObjetoGasto() {
		return objetoGasto;
	}

	public void setObjetoGasto(String objetoGasto) {
		this.objetoGasto = objetoGasto;
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

	public PartidaGastoGenerica getPartidaGastoGenerica() {
		return partidaGastoGenerica;
	}

	public void setPartidaGastoGenerica(PartidaGastoGenerica partidaGastoGenerica) {
		this.partidaGastoGenerica = partidaGastoGenerica;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

}
