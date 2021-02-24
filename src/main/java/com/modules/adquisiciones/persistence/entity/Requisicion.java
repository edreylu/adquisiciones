/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.persistence.entity;

import java.math.BigDecimal;
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
@Table(name = "REQUISICION")
public class Requisicion{

    @Id
    @Basic(optional = false)
    @Column(name = "ID_REQUISICION")
    private Integer idRequisicion;
    @Basic(optional = false)
    @Column(name = "CLAVE_UNIDAD")
    private String claveUnidad;
    @Basic(optional = false)
    @Column(name = "FECHA_ELABORACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaElaboracion;
    @Basic(optional = false)
    @Column(name = "ANIO_CALENDARIZACION")
    private short anioCalendarizacion;
    @Basic(optional = false)
    @Column(name = "MES_CALENDARIZACION")
    private short mesCalendarizacion;
    @Column(name = "JUSTIFICACION_DEL_USO")
    private String justificacionDelUso;
    @Column(name = "FOLIO")
    private Integer folio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO_SUFICIENCIA")
    private BigDecimal montoSuficiencia;
    @Column(name = "FECHA_RECEPCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    @Column(name = "FECHA_AUTORIZACI\u00d3N")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAutorización;
    @Column(name = "ESTATUS")
    private Short estatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequisicion")
    private List<Documento> documentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequisicion")
    private List<Cotizacion> cotizacionList;
    @JoinColumn(name = "MONTO_ADJUDICACION", referencedColumnName = "MONTO_ADJUDICACION")
    @ManyToOne(optional = false)
    private MontoAdjudicacion montoAdjudicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequisicion")
    private List<DetalleRequisicion> detalleRequisicionList;

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

    public short getAnioCalendarizacion() {
        return anioCalendarizacion;
    }

    public void setAnioCalendarizacion(short anioCalendarizacion) {
        this.anioCalendarizacion = anioCalendarizacion;
    }

    public short getMesCalendarizacion() {
        return mesCalendarizacion;
    }

    public void setMesCalendarizacion(short mesCalendarizacion) {
        this.mesCalendarizacion = mesCalendarizacion;
    }

    public String getJustificacionDelUso() {
        return justificacionDelUso;
    }

    public void setJustificacionDelUso(String justificacionDelUso) {
        this.justificacionDelUso = justificacionDelUso;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public BigDecimal getMontoSuficiencia() {
        return montoSuficiencia;
    }

    public void setMontoSuficiencia(BigDecimal montoSuficiencia) {
        this.montoSuficiencia = montoSuficiencia;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Date getFechaAutorización() {
        return fechaAutorización;
    }

    public void setFechaAutorización(Date fechaAutorización) {
        this.fechaAutorización = fechaAutorización;
    }

    public Short getEstatus() {
        return estatus;
    }

    public void setEstatus(Short estatus) {
        this.estatus = estatus;
    }

    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    public List<Cotizacion> getCotizacionList() {
        return cotizacionList;
    }

    public void setCotizacionList(List<Cotizacion> cotizacionList) {
        this.cotizacionList = cotizacionList;
    }

    public MontoAdjudicacion getMontoAdjudicacion() {
        return montoAdjudicacion;
    }

    public void setMontoAdjudicacion(MontoAdjudicacion montoAdjudicacion) {
        this.montoAdjudicacion = montoAdjudicacion;
    }

    public List<DetalleRequisicion> getDetalleRequisicionList() {
        return detalleRequisicionList;
    }

    public void setDetalleRequisicionList(List<DetalleRequisicion> detalleRequisicionList) {
        this.detalleRequisicionList = detalleRequisicionList;
    }

}
