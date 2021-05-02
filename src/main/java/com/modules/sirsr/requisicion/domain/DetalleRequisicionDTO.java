/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.domain;

import com.modules.sirsr.marca.domain.MarcaDTO;
import com.modules.sirsr.producto.domain.ProductoDTO;

import java.math.BigDecimal;

/**
 *
 * @author Edward Reyes
 */
public class DetalleRequisicionDTO {
	private int idDetalleRequisicion;
	private int idRequisicion;
	private int cantidadSolicitada;
	private Double precioUnitario;
	private int cantidadAutorizada;
	private RequisicionDTO requisicion;
	private MarcaDTO marca;
	private ProductoDTO producto;
	
	public DetalleRequisicionDTO() {
		// TODO Auto-generated constructor stub
	}

	

	public DetalleRequisicionDTO(int idDetalleRequisicion, int cantidadSolicitada, Double precioUnitario,
			RequisicionDTO requisicion, MarcaDTO marca, ProductoDTO producto) {
		this.idDetalleRequisicion = idDetalleRequisicion;
		this.cantidadSolicitada = cantidadSolicitada;
		this.precioUnitario = precioUnitario;
		this.requisicion = requisicion;
		this.marca = marca;
		this.producto = producto;
	}

	public int getIdDetalleRequisicion() {
		return idDetalleRequisicion;
	}

	public void setIdDetalleRequisicion(int idDetalleRequisicion) {
		this.idDetalleRequisicion = idDetalleRequisicion;
	}

	public int getIdRequisicion() {
		return idRequisicion;
	}

	public void setIdRequisicion(int idRequisicion) {
		this.idRequisicion = idRequisicion;
	}

	public int getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidadAutorizada() {
		return cantidadAutorizada;
	}

	public void setCantidadAutorizada(int cantidadAutorizada) {
		this.cantidadAutorizada = cantidadAutorizada;
	}

	public RequisicionDTO getRequisicion() {
		return requisicion;
	}

	public void setRequisicion(RequisicionDTO requisicion) {
		this.requisicion = requisicion;
	}

	public MarcaDTO getMarca() {
		return marca;
	}

	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DetalleRequisicionDTO{" + "idDetalleRequisicion=" + idDetalleRequisicion + ", idRequisicion="
				+ idRequisicion + ", cantidadSolicitada=" + cantidadSolicitada + ", precioUnitario=" + precioUnitario
				+ ", cantidadAutorizada=" + cantidadAutorizada + ", requisicion=" + requisicion + ", marca=" + marca
				+ ", producto=" + producto + '}';
	}
}
