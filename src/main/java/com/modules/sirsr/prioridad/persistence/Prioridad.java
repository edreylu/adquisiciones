/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.prioridad.persistence;

import com.modules.sirsr.estatus.persistence.Estatus;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "PRIORIDAD")
public class Prioridad {

	@Id
	@Basic(optional = false)
	@Column(name = "ID_PRIORIDAD")
	private Integer idPrioridad;
	@Basic(optional = false)
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
	@ManyToOne(optional = false)
	private Estatus estatus;

	public Prioridad() {

	}
	
	public Prioridad(Integer idPrioridad, String descripcion, Estatus estatus) {
		this.idPrioridad = idPrioridad;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	public Integer getIdPrioridad() {
		return idPrioridad;
	}

	public void setIdPrioridad(Integer idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

}
