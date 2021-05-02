/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.persistence;

import com.modules.sirsr.documento.persistence.Documento;
import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.requisicion.persistence.Requisicion;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsable;
import com.modules.sirsr.prioridad.persistence.Prioridad;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "SOLICITUD")
public class Solicitud {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solicitud_generator")
	@SequenceGenerator(name = "solicitud_generator", sequenceName = "SEQ_SOLICITUD", allocationSize = 1)
	@Basic(optional = false)
	@Column(name = "ID_SOLICITUD")
	private Integer idSolicitud;
	@Basic(optional = false)
	@Column(name = "FECHA_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	@Basic(optional = false)
	@Column(name = "ANIO_CALENDARIZACION")
	private Integer anioCalendarizacion;
	@Basic(optional = false)
	@Column(name = "MES_CALENDARIZACION")
	private Integer mesCalendarizacion;
	@Column(name = "ACTIVIDAD_O_USO")
	private String actividadOUso;
	@Column(name = "FECHA_EMISION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEmision;
	@Column(name = "FIRMA_DIRECTOR")
	private String firmaDirector;
	@Column(name = "FOLIO")
	private String folio;
	@Column(name = "FECHA_RECEPCION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRecepcion;
	@Column(name = "FECHA_AUTORIZACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAutorizacion;
	@Column(name = "CLAVE_UR", updatable = false, insertable = false)
	private String claveUr;
	@Column(name = "ID_ESTATUS", updatable = false, insertable = false)
	private Integer idEstatus;
	@JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
	@ManyToOne(optional = false)
	private Estatus estatus;
	@JoinColumn(name = "ID_PRIORIDAD", referencedColumnName = "ID_PRIORIDAD")
	@ManyToOne(optional = false)
	private Prioridad prioridad;
	@JoinColumn(name = "CLAVE_UR", referencedColumnName = "CLAVE_UR")
	@ManyToOne(optional = false)
	private UnidadResponsable unidadResponsable;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitud")
	private List<Documento> documentos;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitud")
	private List<Requisicion> requisiciones;

	public Solicitud() {
		
	}
    
	public Solicitud(Date fechaCreacion, Integer anioCalendarizacion, Integer mesCalendarizacion, String actividadOUso,
			Estatus estatus, Prioridad prioridad, UnidadResponsable unidadResponsable) {
		this.fechaCreacion = fechaCreacion;
		this.anioCalendarizacion = anioCalendarizacion;
		this.mesCalendarizacion = mesCalendarizacion;
		this.actividadOUso = actividadOUso;
		this.estatus = estatus;
		this.prioridad = prioridad;
		this.unidadResponsable = unidadResponsable;
	}

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getAnioCalendarizacion() {
		return anioCalendarizacion;
	}

	public void setAnioCalendarizacion(Integer anioCalendarizacion) {
		this.anioCalendarizacion = anioCalendarizacion;
	}

	public Integer getMesCalendarizacion() {
		return mesCalendarizacion;
	}

	public void setMesCalendarizacion(Integer mesCalendarizacion) {
		this.mesCalendarizacion = mesCalendarizacion;
	}

	public String getActividadOUso() {
		return actividadOUso;
	}

	public void setActividadOUso(String actividadOUso) {
		this.actividadOUso = actividadOUso;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getFirmaDirector() {
		return firmaDirector;
	}

	public void setFirmaDirector(String firmaDirector) {
		this.firmaDirector = firmaDirector;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	public String getClaveUr() {
		return claveUr;
	}

	public void setClaveUr(String claveUr) {
		this.claveUr = claveUr;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public UnidadResponsable getUnidadResponsable() {
		return unidadResponsable;
	}

	public void setUnidadResponsable(UnidadResponsable unidadResponsable) {
		this.unidadResponsable = unidadResponsable;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public List<Requisicion> getRequisiciones() {
		return requisiciones;
	}

	public void setRequisiciones(List<Requisicion> requisiciones) {
		this.requisiciones = requisiciones;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}
}
