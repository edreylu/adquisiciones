/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion;

import com.modules.sirsr.unidadResponsable.UnidadResponsableDTO;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Edward Reyes
 */
public class RequisicionDTO {
    private int idRequisicion;
    private UnidadResponsableDTO unidadResponsable;
    private Date fechaElaboracion;
    private int anioCalendarizacion;
    private int mesCalendarizacion;
    private String justificacionDelUso;
    private String folio;
    private Date fechaRecepcion;
    private BigDecimal montoAdjudicacion;
    private Date fechaAutorizacion;
    private int estatus;
    private String idUnidadMedida;
    private String cantidad;
    private String caracteristicas;

    public int getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(int idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public UnidadResponsableDTO getUnidadResponsable() {
        return unidadResponsable;
    }

    public void setUnidadResponsable(UnidadResponsableDTO unidadResponsable) {
        this.unidadResponsable = unidadResponsable;
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

    public BigDecimal getMontoAdjudicacion() {
        return montoAdjudicacion;
    }

    public void setMontoAdjudicacion(BigDecimal montoAdjudicacion) {
        this.montoAdjudicacion = montoAdjudicacion;
    }

    public Date getFechaAutorizacion() {
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


}
