/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.concepto.application;

import com.modules.sirsr.capitulo.application.CapituloDTO;
import com.modules.sirsr.capitulo.domain.Capitulo;
import com.modules.sirsr.concepto.domain.Concepto;
import com.modules.sirsr.estatus.application.EstatusDTO;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Edward Reyes
 */
public class ConceptoDTO {
    private Integer claveConcepto;
    private String descripcion;
    private String definicion;
    private Date fechaInicio;
    private Date fechaFinal;
    private CapituloDTO capitulo;
    private EstatusDTO estatus;

    public Integer getClaveConcepto() {
        return claveConcepto;
    }

    public void setClaveConcepto(Integer claveConcepto) {
        this.claveConcepto = claveConcepto;
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

    public CapituloDTO getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(CapituloDTO capitulo) {
        this.capitulo = capitulo;
    }

    public EstatusDTO getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusDTO estatus) {
        this.estatus = estatus;
    }
}
