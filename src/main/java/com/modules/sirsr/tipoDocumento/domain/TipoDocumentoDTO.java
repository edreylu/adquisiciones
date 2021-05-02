/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.tipoDocumento.domain;

import java.io.Serializable;

import com.modules.sirsr.estatus.domain.EstatusDTO;

/**
 *
 * @author Edward Reyes
 */
public class TipoDocumentoDTO implements Serializable{
	private int idTipoDocumento;
	private String descripcion;
	private String obligatorio;
	private String unico;
	private EstatusDTO estatus;
	
	public TipoDocumentoDTO() {
	
	}

	public TipoDocumentoDTO(int idTipoDocumento, String descripcion,String obligatorio,String unico, EstatusDTO estatus) {
		this.idTipoDocumento = idTipoDocumento;
		this.descripcion = descripcion;
		this.obligatorio = obligatorio;
		this.unico = unico;
		this.estatus = estatus;
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

	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstatusDTO getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusDTO estatus) {
		this.estatus = estatus;
	}
}
