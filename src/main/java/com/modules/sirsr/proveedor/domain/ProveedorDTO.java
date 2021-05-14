/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.proveedor.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.modules.sirsr.actividad.domain.ActividadDTO;
import com.modules.sirsr.actividad.persistence.Actividad;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.tipoPersonaFiscal.domain.TipoPersonaFiscalDTO;


/**
 *
 * @author Edward Reyes
 */

public class ProveedorDTO implements Serializable {
    
	
	
    public ProveedorDTO() {
    	tipoPersonaFiscal = new TipoPersonaFiscalDTO();
		estatus = new  EstatusDTO();
	}

    private Integer idProveedor;
    private String razonSocial;
    private String rfc;
    private String telefono1;
    private String telefono2;
    private String correoElectronico;
    private Date fechaInicioOperaciones;
    private String numeroProveedor;
    private String representanteLegal;
    private String calle;
    private String numeroExterior;    
    private String numeroInterior;
    private String colonia;
    private String codigoPostal;  
    private String localidad;
    private String ciudad;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer idActividadSeleccionada;
   
    private EstatusDTO estatus;
    private TipoPersonaFiscalDTO tipoPersonaFiscal;
    private List<ActividadDTO> actividades;
    
   
    
 	public Integer getIdProveedor() {
		return idProveedor;
	}

 	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

 	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	
	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Date getFechaInicioOperaciones() {
		return fechaInicioOperaciones;
	}

	public void setFechaInicioOperaciones(Date fechaInicioOperaciones) {
		this.fechaInicioOperaciones = fechaInicioOperaciones;
	}

	public String getNumeroProveedor() {
		return numeroProveedor;
	}

	public void setNumeroProveedor(String numeroProveedor) {
		this.numeroProveedor = numeroProveedor;
	}

	public String getRepresentanteLegal() {
		return representanteLegal;
	}

	public void setRepresentanteLegal(String representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	

	public EstatusDTO getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusDTO estatus) {
		this.estatus = estatus;
	}
	
	public Integer getIdActividadSeleccionada() {
		return idActividadSeleccionada;
	}

	public void setIdActividadSeleccionada(Integer idActividadSeleccionada) {
		this.idActividadSeleccionada = idActividadSeleccionada;
	}

	public TipoPersonaFiscalDTO getTipoPersonaFiscal() {
		return tipoPersonaFiscal;
	}

	public void setTipoPersonaFiscal(TipoPersonaFiscalDTO tipoPersonaFiscal) {
		this.tipoPersonaFiscal = tipoPersonaFiscal;
	}
	
	public List<ActividadDTO> getActividades() {
		return actividades;
	}

	public void setActividades(List<ActividadDTO> actividades) {
		this.actividades = actividades;
	}

	@Override
	public String toString() {
		return "ProveedorDTO [idProveedor=" + idProveedor + ", razonSocial=" + razonSocial + ", rfc=" + rfc
				+ ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + ", correoElectronico=" + correoElectronico
				+ ", fechaInicioOperaciones=" + fechaInicioOperaciones + ", numeroProveedor=" + numeroProveedor
				+ ", representanteLegal=" + representanteLegal + ", calle=" + calle + ", numeroExterior="
				+ numeroExterior + ", numeroInterior=" + numeroInterior + ", colonia=" + colonia + ", codigoPostal="
				+ codigoPostal + ", localidad=" + localidad + ", ciudad=" + ciudad + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", idActividadSeleccionada=" + idActividadSeleccionada + ", estatus="
				+ estatus + ", tipoPersonaFiscal=" + tipoPersonaFiscal + ", actividades=" + actividades + "]";
	}

	

    
    

}
