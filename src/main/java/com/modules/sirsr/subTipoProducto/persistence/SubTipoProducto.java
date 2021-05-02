/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.subTipoProducto.persistence;

import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.tipoProducto.persistence.TipoProducto;

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
@Table(name = "SUBTIPO_PRODUCTO")
public class SubTipoProducto {

	@Id
	@Basic(optional = false)
	@Column(name = "ID_SUBTIPO_PRODUCTO")
	private Integer idSubtipoProducto;
	@Basic(optional = false)
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@JoinColumn(name = "ID_TIPO_PRODUCTO", referencedColumnName = "ID_TIPO_PRODUCTO")
	@ManyToOne(optional = false)
	private TipoProducto tipoProducto;
	@JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
	@ManyToOne(optional = false)
	private Estatus estatus;

	public Integer getIdSubtipoProducto() {
		return idSubtipoProducto;
	}

	public void setIdSubtipoProducto(Integer idSubtipoProducto) {
		this.idSubtipoProducto = idSubtipoProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

}
