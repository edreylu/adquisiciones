/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.proveedor.persistence;

import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.tipoPersonaFiscal.persistence.TipoPersonaFiscal;
import com.modules.sirsr.actividad.persistence.Actividad;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "PROVEEDOR")
public class Proveedor{

		
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proveedor_generator")
    @SequenceGenerator(name = "proveedor_generator", sequenceName = "SEQ_PROVEEDOR", allocationSize = 1)
    @Column(name = "ID_PROVEEDOR", nullable = false)
    private Integer idProveedor;
    @Basic(optional = false)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Basic(optional = false)
    @Column(name = "RFC")
    private String rfc;
    @Column(name = "TELEFONO1")
    private String telefono1;
    @Column(name = "TELEFONO2")
    private String telefono2;
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Column(name = "FECHA_INICIO_OPERACIONES")
    private Date fechaInicioOperaciones;
     @Column(name = "NUMERO_PROVEEDOR")
    private String numeroProveedor;
    
    @Column(name = "REPRESENTANTE_LEGAL")
    private String representanteLegal;
    
    @Column(name = "CALLE")
    private String calle;
    
    @Column(name = "NUMERO_EXTERIOR")
    private String numeroExterior;
    
    @Column(name = "NUMERO_INTERIOR")
    private String numeroInterior;
    
    @Column(name = "COLONIA")
    private String colonia;
    
    @Column(name = "CODIGO_POSTAL")
    private String codigoPostal;
    
    @Column(name = "LOCALIDAD")
    private String localidad;
    
    @Column(name = "CIUDAD")
    private String ciudad;
    
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;
    
    @Column(name = "FECHA_FIN")
    private Date fechaFin;
    
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;
    
    @JoinColumn(name = "ID_TIPO_PERSONA_FISCAL", referencedColumnName = "ID_TIPO_PERSONA_FISCAL")
    @ManyToOne(optional = true)
    private TipoPersonaFiscal tipoPersonaFiscal;
    
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "PROVEEDOR_ACTIVIDAD",
            joinColumns = @JoinColumn(name = "ID_PROVEEDOR", nullable = false),
            inverseJoinColumns = @JoinColumn(name="ID_ACTIVIDAD", nullable = false)
        )
    private List<Actividad> actividades;
   
    
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

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	public TipoPersonaFiscal getTipoPersonaFiscal() {
		return tipoPersonaFiscal == null ? new TipoPersonaFiscal() : tipoPersonaFiscal;
	}

	public void setTipoPersonaFiscal(TipoPersonaFiscal tipoPersonaFiscal) {
		this.tipoPersonaFiscal = tipoPersonaFiscal;
	}
	
	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", razonSocial=" + razonSocial + ", rfc=" + rfc
				+ ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + ", correoElectronico=" + correoElectronico
				+ ", fechaInicioOperaciones=" + fechaInicioOperaciones + ", numeroProveedor=" + numeroProveedor
				+ ", representanteLegal=" + representanteLegal + ", calle=" + calle + ", numeroExterior="
				+ numeroExterior + ", numeroInterior=" + numeroInterior + ", colonia=" + colonia + ", codigoPostal="
				+ codigoPostal + ", localidad=" + localidad + ", ciudad=" + ciudad + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", estatus=" + estatus + ", tipoPersonaFiscal=" + tipoPersonaFiscal
				+ ", actividades=" + actividades + "]";
	}

	
   
    
    
    
    
}
