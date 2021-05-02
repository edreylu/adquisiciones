/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.domain;

import com.modules.sirsr.documento.domain.DocumentoDTO;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.prioridad.domain.PrioridadDTO;
import com.modules.sirsr.prioridad.persistence.Prioridad;
import com.modules.sirsr.requisicion.domain.RequisicionDTO;
import com.modules.sirsr.revision.domain.RevisionDTO;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsableDTO;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsable;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Edward Reyes
 */
public class SolicitudDTO implements Serializable{
	private int idSolicitud;
	private Date fechaCreacion;
	private int anioCalendarizacion;
	private int mesCalendarizacion;
	private String mesCalendarizacionStr;
	private String actividadOUso;
	private Date fechaEmision;
	private String firmaDirector;
	private String folio;
	private String claveUr;
	private Date fechaRecepcion;
	private Date fechaAutorizacion;
	private EstatusDTO estatus;
	private PrioridadDTO prioridad;
	private UnidadResponsableDTO unidadResponsable;
	private List<DocumentoDTO> documentos;
	private List<RevisionDTO> revisiones;
	private List<RequisicionDTO> requisiciones;

	public SolicitudDTO() {
	}

	public SolicitudDTO(Date fechaCreacion, Integer anioCalendarizacion, Integer mesCalendarizacion, String actividadOUso,
			EstatusDTO estatus, PrioridadDTO prioridad, UnidadResponsableDTO unidadResponsable) {
		this.fechaCreacion = fechaCreacion;
		this.anioCalendarizacion = anioCalendarizacion;
		this.mesCalendarizacion = mesCalendarizacion;
		this.actividadOUso = actividadOUso;
		this.estatus = estatus;
		this.prioridad = prioridad;
		this.unidadResponsable = unidadResponsable;
	}

	public SolicitudDTO(SolicitudDTO solicitud) {
		this.idSolicitud = solicitud.getIdSolicitud();
		this.fechaCreacion = solicitud.getFechaCreacion();
		this.anioCalendarizacion = solicitud.getAnioCalendarizacion();
		this.mesCalendarizacion = solicitud.getMesCalendarizacion();
		this.mesCalendarizacionStr = solicitud.getMesCalendarizacionStr();
		this.actividadOUso = solicitud.getActividadOUso();
		this.fechaEmision = solicitud.getFechaEmision();
		this.firmaDirector = solicitud.getFirmaDirector();
		this.folio = solicitud.getFolio();
		this.claveUr = solicitud.getClaveUr();
		this.fechaRecepcion = solicitud.getFechaRecepcion();
		this.fechaAutorizacion = solicitud.getFechaAutorizacion();
		this.estatus = solicitud.getEstatus();
		this.prioridad = solicitud.getPrioridad();
		this.unidadResponsable = solicitud.getUnidadResponsable();
		this.documentos = solicitud.getDocumentos();
		this.revisiones = solicitud.getRevisiones();
		this.requisiciones = solicitud.getRequisiciones();
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getAnioCalendarizacion() {
		return anioCalendarizacion;
	}

	public void setAnioCalendarizacion(int anioCalendarizacion) {
		this.anioCalendarizacion = anioCalendarizacion;
	}

	public int getMesCalendarizacion() {
		return mesCalendarizacion;
	}

	public void setMesCalendarizacion(int mesCalendarizacion) {
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

	public String getClaveUr() {
		return claveUr;
	}

	public void setClaveUr(String claveUr) {
		this.claveUr = claveUr;
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

	public EstatusDTO getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusDTO estatus) {
		this.estatus = estatus;
	}

	public PrioridadDTO getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(PrioridadDTO prioridad) {
		this.prioridad = prioridad;
	}

	public UnidadResponsableDTO getUnidadResponsable() {
		return unidadResponsable;
	}

	public void setUnidadResponsable(UnidadResponsableDTO unidadResponsable) {
		this.unidadResponsable = unidadResponsable;
	}

	public List<DocumentoDTO> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DocumentoDTO> documentos) {
		this.documentos = documentos;
	}

	public List<RevisionDTO> getRevisiones() {
		return revisiones;
	}

	public void setRevisiones(List<RevisionDTO> revisiones) {
		this.revisiones = revisiones;
	}

	public List<RequisicionDTO> getRequisiciones() {
		return requisiciones;
	}

	public void setRequisiciones(List<RequisicionDTO> requisiciones) {
		this.requisiciones = requisiciones;
	}

	public String getMesCalendarizacionStr() {
		return mesCalendarizacionStr;
	}

	public void setMesCalendarizacionStr(String mesCalendarizacionStr) {
		this.mesCalendarizacionStr = mesCalendarizacionStr;
	}
}
