/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.application;

import com.modules.sirsr.documento.application.DocumentoDTO;
import com.modules.sirsr.documento.domain.Documento;
import com.modules.sirsr.estatus.application.EstatusDTO;
import com.modules.sirsr.estatus.domain.Estatus;
import com.modules.sirsr.prioridad.application.PrioridadDTO;
import com.modules.sirsr.prioridad.domain.Prioridad;
import com.modules.sirsr.requisicion.application.RequisicionDTO;
import com.modules.sirsr.requisicion.domain.Requisicion;
import com.modules.sirsr.revision.application.RevisionDTO;
import com.modules.sirsr.revision.domain.Revision;
import com.modules.sirsr.seguimientoSolicitud.domain.SeguimientoSolicitud;
import com.modules.sirsr.unidadResponsable.application.UnidadResponsableDTO;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsable;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Edward Reyes
 */
public class SolicitudDTO{
    private int idSolicitud;
    private Date fechaCreacion;
    private int anioCalendarizacion;
    private int mesCalendarizacion;
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
}
