/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.persistence.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "PARTIDA_GASTO_ESPECIFICA")
public class PartidaGastoEspecifica{

    @Id
    @Basic(optional = false)
    @Column(name = "CLAVE_ESPECIFICA")
    private Short claveEspecifica;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "DEFINICION")
    private String definicion;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Basic(optional = false)
    @Column(name = "ESTATUS")
    private short estatus;
    @JoinColumn(name = "CLAVE_GENERICA", referencedColumnName = "CLAVE_GENERICA")
    @ManyToOne(optional = false)
    private PartidaGastoGenerica claveGenerica;

    public Short getClaveEspecifica() {
        return claveEspecifica;
    }

    public void setClaveEspecifica(Short claveEspecifica) {
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

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(short estatus) {
        this.estatus = estatus;
    }

    public PartidaGastoGenerica getClaveGenerica() {
        return claveGenerica;
    }

    public void setClaveGenerica(PartidaGastoGenerica claveGenerica) {
        this.claveGenerica = claveGenerica;
    }

}
