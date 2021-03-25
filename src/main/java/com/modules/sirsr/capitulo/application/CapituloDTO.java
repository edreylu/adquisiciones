/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.capitulo.application;

import com.modules.sirsr.capitulo.domain.Capitulo;
import com.modules.sirsr.estatus.application.EstatusDTO;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 *
 * @author Edward Reyes
 */
public class CapituloDTO {
    private Integer claveCapitulo;
    private String descripcion;
    private String definicion;
    private Date fechaInicio;
    private Date fechaFinal;
    private EstatusDTO estatus;

    public Integer getClaveCapitulo() {
        return claveCapitulo;
    }

    public void setClaveCapitulo(Integer claveCapitulo) {
        this.claveCapitulo = claveCapitulo;
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

    public EstatusDTO getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusDTO estatus) {
        this.estatus = estatus;
    }
}
