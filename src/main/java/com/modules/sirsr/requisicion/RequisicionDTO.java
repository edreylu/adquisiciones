/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Edward Reyes
 */
public class RequisicionDTO {
    private int idRequisicion;
    private String claveUnidad;
    private Date fechaElaboracion;
    private int anioCalendarizacion;
    private int mesCalendarizacion;
    private String justificacionDelUso;
    private int folio;
    private BigDecimal montoSuficiencia;
    private Date fechaRecepcion;
    private BigDecimal montoAdjudicacion;
    private Date fechaAutorizacion;
    private int estatus;
    private int claveEspecifica;
    private int digito;
    private MultipartFile volanteSuficiencia;
    private MultipartFile oficio;
    private MultipartFile otro;
    private String idUnidadMedida;
    private String cantidad;
    private String caracteristicas;
    
    

    public int getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(int idRequisicion) {
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

    public String getJustificacionDelUso() {
        return justificacionDelUso;
    }

    public void setJustificacionDelUso(String justificacionDelUso) {
        this.justificacionDelUso = justificacionDelUso;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
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
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getClaveEspecifica() {
        return claveEspecifica;
    }

    public void setClaveEspecifica(int claveEspecifica) {
        this.claveEspecifica = claveEspecifica;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public MultipartFile getVolanteSuficiencia() {
        return volanteSuficiencia;
    }

    public void setVolanteSuficiencia(MultipartFile volanteSuficiencia) {
        this.volanteSuficiencia = volanteSuficiencia;
    }

    public MultipartFile getOficio() {
        return oficio;
    }

    public void setOficio(MultipartFile oficio) {
        this.oficio = oficio;
    }

    public MultipartFile getOtro() {
        return otro;
    }

    public void setOtro(MultipartFile otro) {
        this.otro = otro;
    }

    public BigDecimal getMontoAdjudicacion() {
        return montoAdjudicacion;
    }

    public void setMontoAdjudicacion(BigDecimal montoAdjudicacion) {
        this.montoAdjudicacion = montoAdjudicacion;
    }

    public String getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(String idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "RequisicionDTO{" + "idRequisicion=" + idRequisicion + ", claveUnidad=" + claveUnidad + ", fechaElaboracion=" + fechaElaboracion + ", anioCalendarizacion=" + anioCalendarizacion + ", mesCalendarizacion=" + mesCalendarizacion + ", justificacionDelUso=" + justificacionDelUso + ", folio=" + folio + ", montoSuficiencia=" + montoSuficiencia + ", fechaRecepcion=" + fechaRecepcion + ", montoAdjudicacion=" + montoAdjudicacion + ", fechaAutorizacion=" + fechaAutorizacion + ", estatus=" + estatus + ", claveEspecifica=" + claveEspecifica + ", digito=" + digito + ", volanteSuficiencia=" + volanteSuficiencia + ", oficio=" + oficio + ", otro=" + otro + ", idUnidadMedida=" + idUnidadMedida + ", cantidad=" + cantidad + ", caracteristicas=" + caracteristicas + '}';
    }

    
}
