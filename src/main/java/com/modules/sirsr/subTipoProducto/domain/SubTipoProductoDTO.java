/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.subTipoProducto.domain;

import java.io.Serializable;

import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.objetoGasto.domain.ObjetoDeGastoDTO;
import com.modules.sirsr.tipoProducto.domain.TipoProductoDTO;

/**
 *
 * @author Edward Reyes
 */
public class SubTipoProductoDTO implements Serializable {
	private int idSubtipoProducto;
	private String descripcion;
	private EstatusDTO estatus;
	private ObjetoDeGastoDTO objetoDeGasto;
	private TipoProductoDTO tipoProducto;

	public int getIdSubtipoProducto() {
		return idSubtipoProducto;
	}

	public void setIdSubtipoProducto(int idSubtipoProducto) {
		this.idSubtipoProducto = idSubtipoProducto;
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

	public ObjetoDeGastoDTO getObjetoDeGasto() {
		return objetoDeGasto;
	}

	public void setObjetoDeGasto(ObjetoDeGastoDTO objetoDeGasto) {
		this.objetoDeGasto = objetoDeGasto;
	}

	public TipoProductoDTO getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProductoDTO tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
}
