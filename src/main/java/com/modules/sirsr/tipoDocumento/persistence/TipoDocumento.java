/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.tipoDocumento.persistence;

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
@Table(name = "TIPO_DOCUMENTO")
public class TipoDocumento {

	@Id
	@Basic(optional = false)
	@Column(name = "ID_TIPO_DOCUMENTO")
	private Integer idTipoDocumento;
	@Basic(optional = false)
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Basic(optional = false)
	@Column(name = "OBLIGATORIO")
	private String obligatorio;
	@Basic(optional = false)
	@Column(name = "UNICO")
	private String unico;

	@JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
	@ManyToOne(optional = false)
	private Estatus estatus;
	
	public TipoDocumento() {
		
	}

	public TipoDocumento(Integer idTipoDocumento, String descripcion, String obligatorio, String unico,
			Estatus estatus) {
		this.idTipoDocumento = idTipoDocumento;
		this.descripcion = descripcion;
		this.obligatorio = obligatorio;
		this.unico = unico;
		this.estatus = estatus;
	}

	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObligatorio() {
		return obligatorio;
	}

	public void setObligatorio(String obligatorio) {
		this.obligatorio = obligatorio;
	}

	public String getUnico() {
		return unico;
	}

	public void setUnico(String unico) {
		this.unico = unico;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

}
