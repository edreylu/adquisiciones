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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "REQUISICION")
public class Requisicion{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requisicion_generator")
    @SequenceGenerator(name = "requisicion_generator", sequenceName = "ADQUISICIONES.SEQ_REQUISICION", allocationSize = 1)
    @Column(name = "ID_REQUISICION")
    private Integer idRequisicion;
    @Column(name = "CLAVE_UR", insertable = false, updatable = false)
    private String claveUnidad;
    @Column(name = "FECHA_ELABORACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaElaboracion;
    @Basic(optional = false)
    @Column(name = "ANIO_CALENDARIZACION")
    private Integer anioCalendarizacion;
    @Basic(optional = false)
    @Column(name = "MES_CALENDARIZACION")
    private Integer mesCalendarizacion;
    @Column(name = "JUSTIFICACION_DEL_USO")
    private String justificacionDelUso;
    @Column(name = "FECHA_RECEPCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    @Column(name = "FECHA_AUTORIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAutorizacion;
    @Column(name = "FOLIO")
    private String folio;
    @Column(name = "ESTATUS")
    private Integer estatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisicion")
    private List<Documento> documentos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisicion")
    private List<Cotizacion> cotizaciones;
    @JoinColumn(name = "CLAVE_UR", referencedColumnName = "CLAVE_UR")
    @ManyToOne(optional = false)
    private UnidadResponsable unidadResponsable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisicion")
    private List<Volante> volantes;
    @JoinColumn(name = "MONTO_ADJUDICACION", referencedColumnName = "ID_MONTO_ADJUDICACION")
    @ManyToOne
    private MontoAdjudicacion montoAdjudicacion;

    public Integer getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(Integer idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public String getClaveUnidad() {
        return claveUnidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public Date getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(Date fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
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

    public String getJustificacionDelUso() {
        return justificacionDelUso;
    }

    public void setJustificacionDelUso(String justificacionDelUso) {
        this.justificacionDelUso = justificacionDelUso;
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

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<Cotizacion> getCotizaciones() {
        return cotizaciones;
    }

    public void setCotizaciones(List<Cotizacion> cotizaciones) {
        this.cotizaciones = cotizaciones;
    }

    public UnidadResponsable getUnidadResponsable() {
        return unidadResponsable;
    }

    public void setUnidadResponsable(UnidadResponsable unidadResponsable) {
        this.unidadResponsable = unidadResponsable;
    }

    public List<Volante> getVolantes() {
        return volantes;
    }

    public void setVolantes(List<Volante> volantes) {
        this.volantes = volantes;
    }

    public MontoAdjudicacion getMontoAdjudicacion() {
        return montoAdjudicacion;
    }

    public void setMontoAdjudicacion(MontoAdjudicacion montoAdjudicacion) {
        this.montoAdjudicacion = montoAdjudicacion;
    }

    
}
