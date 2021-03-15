/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.application;

import com.modules.sirsr.estatus.application.EstatusDTO;
import com.modules.sirsr.prioridad.application.PrioridadDTO;
import com.modules.sirsr.unidadResponsable.application.UnidadResponsableDTO;
import java.util.Date;

/**
 *
 * @author Edward Reyes
 */
public class SolicitudDTO {
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

    public String getClaveUr() {
        return claveUr;
    }

    public void setClaveUr(String claveUr) {
        this.claveUr = claveUr;
    }

    public UnidadResponsableDTO getUnidadResponsable() {
        return unidadResponsable;
    }

    public void setUnidadResponsable(UnidadResponsableDTO unidadResponsable) {
        this.unidadResponsable = unidadResponsable;
    }

    @Override
    public String toString() {
        return "SolicitudDTO{" +
                "idSolicitud=" + idSolicitud +
                ", fechaCreacion=" + fechaCreacion +
                ", anioCalendarizacion=" + anioCalendarizacion +
                ", mesCalendarizacion=" + mesCalendarizacion +
                ", actividadOUso='" + actividadOUso + '\'' +
                ", fechaEmision=" + fechaEmision +
                ", firmaDirector='" + firmaDirector + '\'' +
                ", folio='" + folio + '\'' +
                ", claveUr='" + claveUr + '\'' +
                ", fechaRecepcion=" + fechaRecepcion +
                ", fechaAutorizacion=" + fechaAutorizacion +
                ", estatus=" + estatus +
                ", prioridad=" + prioridad +
                ", unidadResponsable=" + unidadResponsable +
                '}';
    }
}
