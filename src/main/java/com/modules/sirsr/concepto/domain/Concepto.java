/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.concepto.domain;

import com.modules.sirsr.capitulo.domain.Capitulo;
import com.modules.sirsr.estatus.domain.Estatus;
import com.modules.sirsr.partidaGastoGenerica.domain.PartidaGastoGenerica;

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
    private Integer claveConcepto;
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
    @JoinColumn(name = "CLAVE_CAPITULO", referencedColumnName = "CLAVE_CAPITULO")
    @ManyToOne(optional = false)
    private Capitulo capitulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "concepto")
    private List<PartidaGastoGenerica> partidasGastoGenerica;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;

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

    public Capitulo getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
    }

    public List<PartidaGastoGenerica> getPartidasGastoGenerica() {
        return partidasGastoGenerica;
    }

    public void setPartidasGastoGenerica(List<PartidaGastoGenerica> partidasGastoGenerica) {
        this.partidasGastoGenerica = partidasGastoGenerica;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    
}
