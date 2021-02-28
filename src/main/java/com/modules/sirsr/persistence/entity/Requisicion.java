/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Column(name = "CLAVE_UNIDAD")
    private String claveUnidad;
    @Column(name = "FECHA_ELABORACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaElaboracion;
    @Column(name = "ANIO_CALENDARIZACION")
    private Integer anioCalendarizacion;
    @Column(name = "MES_CALENDARIZACION")
    private Integer mesCalendarizacion;
    @Column(name = "JUSTIFICACION_DEL_USO")
    private String justificacionDelUso;
    @Column(name = "FOLIO")
    private Integer folio;
    @Column(name = "MONTO_SUFICIENCIA")
    private BigDecimal montoSuficiencia;
    @Column(name = "FECHA_RECEPCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    @Column(name = "MONTO_ADJUDICACION")
    private BigDecimal montoAdjudicacion;
    @Column(name = "FECHA_AUTORIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAutorizacion;
    @Column(name = "ESTATUS")
    private Integer estatus;
    @Column(name = "CLAVE_ESPECIFICA")
    private Integer claveEspecifica;
    @Column(name = "DIGITO")
    private Integer digito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisicion")
    private List<Documento> documentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisicion")
    private List<Cotizacion> cotizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisicion")
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

    public Date getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
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

    public BigDecimal getMontoAdjudicacion() {
        return montoAdjudicacion;
    }

    public void setMontoAdjudicacion(BigDecimal montoAdjudicacion) {
        this.montoAdjudicacion = montoAdjudicacion;
    }

    public List<DetalleRequisicion> getDetalleRequisicionList() {
        return detalleRequisicionList;
    }

    public void setDetalleRequisicionList(List<DetalleRequisicion> detalleRequisicionList) {
        this.detalleRequisicionList = detalleRequisicionList;
    }

    public Integer getClaveEspecifica() {
        return claveEspecifica;
    }

    public void setClaveEspecifica(Integer claveEspecifica) {
        this.claveEspecifica = claveEspecifica;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    @Override
    public String toString() {
        return "Requisicion{" + "idRequisicion=" + idRequisicion + ", claveUnidad=" + claveUnidad + ", fechaElaboracion=" + fechaElaboracion + ", anioCalendarizacion=" + anioCalendarizacion + ", mesCalendarizacion=" + mesCalendarizacion + ", justificacionDelUso=" + justificacionDelUso + ", folio=" + folio + ", montoSuficiencia=" + montoSuficiencia + ", fechaRecepcion=" + fechaRecepcion + ", montoAdjudicacion=" + montoAdjudicacion + ", fechaAutorizacion=" + fechaAutorizacion + ", estatus=" + estatus + ", claveEspecifica=" + claveEspecifica + ", digito=" + digito + ", documentoList=" + documentoList + ", cotizacionList=" + cotizacionList + ", detalleRequisicionList=" + detalleRequisicionList + '}';
    }

}
