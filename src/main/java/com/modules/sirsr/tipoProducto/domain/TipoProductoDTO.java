package com.modules.sirsr.tipoProducto.domain;

import java.io.Serializable;

import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.objetoGasto.domain.ObjetoDeGastoDTO;

public class TipoProductoDTO implements Serializable{
	private Integer idTipoProducto;
	private String descripcion;
	private ObjetoDeGastoDTO objetoDeGasto;
	private EstatusDTO estatus;
	
	public TipoProductoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public TipoProductoDTO(Integer idTipoProducto, String descripcion, ObjetoDeGastoDTO objetoDeGasto,
			EstatusDTO estatus) {
		this.idTipoProducto = idTipoProducto;
		this.descripcion = descripcion;
		this.objetoDeGasto = objetoDeGasto;
		this.estatus = estatus;
	}

	public Integer getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(Integer idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
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
}
