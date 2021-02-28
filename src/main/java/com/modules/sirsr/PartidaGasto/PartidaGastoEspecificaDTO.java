package com.modules.sirsr.PartidaGasto;
import com.modules.sirsr.persistence.entity.PartidaGastoGenerica;

import java.util.Date;

public class PartidaGastoEspecificaDTO {
    private int claveEspecifica;
    private String descripcion;
    private String definicion;
    private Date fechaInicio;
    private Date fechaFinal;
    private int estatus;
    private PartidaGastoGenerica claveGenerica;

    public int getClaveEspecifica() {
        return claveEspecifica;
    }

    public void setClaveEspecifica(int claveEspecifica) {
        this.claveEspecifica = claveEspecifica;
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

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public PartidaGastoGenerica getClaveGenerica() {
        return claveGenerica;
    }

    public void setClaveGenerica(PartidaGastoGenerica claveGenerica) {
        this.claveGenerica = claveGenerica;
    }
}
