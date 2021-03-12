/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "SOLICITUD")
public class Solicitud {

    @Id
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitud")
    private List<Documento> documentos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitud")
    private List<Revision> revisiones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitud")
    private List<Requisicion> requisiciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitud")
    private List<SeguimientoSolicitud> seguimientosSolicitud;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;
    @JoinColumn(name = "ID_PRIORIDAD", referencedColumnName = "ID_PRIORIDAD")
    @ManyToOne(optional = false)
    private Prioridad prioridad;
    @JoinColumn(name = "CLAVE_UR", referencedColumnName = "CLAVE_UR")
    @ManyToOne(optional = false)
    private UnidadResponsable unidadResponsable;

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

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    public List<Requisicion> getRequisiciones() {
        return requisiciones;
    }

    public void setRequisiciones(List<Requisicion> requisiciones) {
        this.requisiciones = requisiciones;
    }

    public List<SeguimientoSolicitud> getSeguimientosSolicitud() {
        return seguimientosSolicitud;
    }

    public void setSeguimientosSolicitud(List<SeguimientoSolicitud> seguimientosSolicitud) {
        this.seguimientosSolicitud = seguimientosSolicitud;
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
}
