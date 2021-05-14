/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.capitulo.persistence;

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
@Table(name = "CAPITULO")
public class Capitulo {

	@Id
	@Basic(optional = false)
	@Column(name = "CLAVE_CAPITULO")
	private Integer claveCapitulo;
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
	@Basic(optional = false)
	@JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
	@ManyToOne(optional = false)
	private Estatus estatus;
	
	public Capitulo() {
		// TODO Auto-generated constructor stub
	}

	public Capitulo(Integer claveCapitulo, String descripcion, String definicion, Date fechaInicio, Date fechaFinal,
			Estatus estatus) {
		this.claveCapitulo = claveCapitulo;
		this.descripcion = descripcion;
		this.definicion = definicion;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.estatus = estatus;
	}


	public Integer getClaveCapitulo() {
		return claveCapitulo;
	}

	public void setClaveCapitulo(Integer claveCapitulo) {
		this.claveCapitulo = claveCapitulo;
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

}
