/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.partidaGastoGenerica.domain;

import com.modules.sirsr.concepto.domain.ConceptoDTO;
import com.modules.sirsr.estatus.domain.EstatusDTO;

import java.util.Date;

/**
 *
 * @author Edward Reyes
 */
public class PartidaGastoGenericaDTO {
    private Integer claveGenerica;
    private String descripcion;
    private String definicion;
    private Date fechaInicio;
    private Date fechaFinal;
    private ConceptoDTO concepto;
    private EstatusDTO estatus;

    public Integer getClaveGenerica() {
        return claveGenerica;
    }

    public void setClaveGenerica(Integer claveGenerica) {
        this.claveGenerica = claveGenerica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public ConceptoDTO getConcepto() {
        return concepto;
    }

    public void setConcepto(ConceptoDTO concepto) {
        this.concepto = concepto;
    }

    public EstatusDTO getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusDTO estatus) {
        this.estatus = estatus;
    }
}
