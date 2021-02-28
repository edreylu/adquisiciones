/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

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
@Table(name = "PARTIDA_GASTO_GENERICA")
public class PartidaGastoGenerica{

    @Id
    @Basic(optional = false)
    @Column(name = "CLAVE_GENERICA")
    private Short claveGenerica;
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
    @JoinColumn(name = "CLAVE_CONCEPTO", referencedColumnName = "CLAVE_CONCEPTO")
    @ManyToOne(optional = false)
    private Concepto claveConcepto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "claveGenerica")
    private List<PartidaGastoEspecifica> partidaGastoEspecificaList;

    public Short getClaveGenerica() {
        return claveGenerica;
    }

    public void setClaveGenerica(Short claveGenerica) {
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

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(short estatus) {
        this.estatus = estatus;
    }

    public Concepto getClaveConcepto() {
        return claveConcepto;
    }

    public void setClaveConcepto(Concepto claveConcepto) {
        this.claveConcepto = claveConcepto;
    }

    public List<PartidaGastoEspecifica> getPartidaGastoEspecificaList() {
        return partidaGastoEspecificaList;
    }

    public void setPartidaGastoEspecificaList(List<PartidaGastoEspecifica> partidaGastoEspecificaList) {
        this.partidaGastoEspecificaList = partidaGastoEspecificaList;
    }

    
}
