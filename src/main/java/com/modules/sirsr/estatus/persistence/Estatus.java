/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.estatus.persistence;


import javax.persistence.*;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "ESTATUS")
public class Estatus {

	@Id
	@Basic(optional = false)
	@Column(name = "ID_ESTATUS")
	private Integer idEstatus;
	@Column(name = "CLAVE")
	private String clave;
	@Basic(optional = false)
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "COLORHEX")
	private String colorhex;
	@Column(name = "EXPLICACION")
	private String explicacion;

	public Estatus() {
		
	}
	public Estatus(Integer idEstatus, String clave, String descripcion, String colorhex, String explicacion) {
		this.idEstatus = idEstatus;
		this.clave = clave;
		this.descripcion = descripcion;
		this.colorhex = colorhex;
		this.explicacion = explicacion;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColorhex() {
		return colorhex;
	}

	public void setColorhex(String colorhex) {
		this.colorhex = colorhex;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}
}
