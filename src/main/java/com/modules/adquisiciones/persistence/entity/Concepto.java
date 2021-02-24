/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.persistence.entity;

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
@Table(name = "CONCEPTO")
public class Concepto{

    @Id
    @Basic(optional = false)
    @Column(name = "CLAVE_CONCEPTO")
    private Short claveConcepto;
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
    @JoinColumn(name = "CLAVE_CAPITULO", referencedColumnName = "CLAVE_CAPITULO")
    @ManyToOne(optional = false)
    private Capitulo claveCapitulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "claveConcepto")
    private List<PartidaGastoGenerica> partidaGastoGenericaList;

    public Short getClaveConcepto() {
        return claveConcepto;
    }

    public void setClaveConcepto(Short claveConcepto) {
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

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(short estatus) {
        this.estatus = estatus;
    }

    public Capitulo getClaveCapitulo() {
        return claveCapitulo;
    }

    public void setClaveCapitulo(Capitulo claveCapitulo) {
        this.claveCapitulo = claveCapitulo;
    }

    public List<PartidaGastoGenerica> getPartidaGastoGenericaList() {
        return partidaGastoGenericaList;
    }

    public void setPartidaGastoGenericaList(List<PartidaGastoGenerica> partidaGastoGenericaList) {
        this.partidaGastoGenericaList = partidaGastoGenericaList;
    }
    
}
