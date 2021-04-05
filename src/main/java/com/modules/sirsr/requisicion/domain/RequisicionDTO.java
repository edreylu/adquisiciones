/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.domain;

import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestariaDTO;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.montoAdjudicacion.domain.MontoAdjudicacionDTO;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;

/**
 *
 * @author Edward Reyes
 */
public class RequisicionDTO {
    private int idRequisicion;
    private int idSolicitud;
    private Double montoSuficiencia;
    private ClavePresupuestariaDTO clavePresupuestaria;
    private EstatusDTO estatus;
    private MontoAdjudicacionDTO montoAdjudicacion;
    private SolicitudDTO solicitud;

    public int getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(int idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public Double getMontoSuficiencia() {
        return montoSuficiencia;
    }

    public void setMontoSuficiencia(Double montoSuficiencia) {
        this.montoSuficiencia = montoSuficiencia;
    }

    public ClavePresupuestariaDTO getClavePresupuestaria() {
        return clavePresupuestaria;
    }

    public void setClavePresupuestaria(ClavePresupuestariaDTO clavePresupuestaria) {
        this.clavePresupuestaria = clavePresupuestaria;
    }

    public EstatusDTO getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusDTO estatus) {
        this.estatus = estatus;
    }

    public MontoAdjudicacionDTO getMontoAdjudicacion() {
        return montoAdjudicacion;
    }

    public void setMontoAdjudicacion(MontoAdjudicacionDTO montoAdjudicacion) {
        this.montoAdjudicacion = montoAdjudicacion;
    }

    public SolicitudDTO getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudDTO solicitud) {
        this.solicitud = solicitud;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public String toString() {
        return "RequisicionDTO{" +
                "idRequisicion=" + idRequisicion +
                ", idSolicitud=" + idSolicitud +
                ", montoSuficiencia=" + montoSuficiencia +
                ", clavePresupuestaria=" + clavePresupuestaria +
                ", estatus=" + estatus +
                ", montoAdjudicacion=" + montoAdjudicacion +
                ", solicitud=" + solicitud +
                '}';
    }
}
