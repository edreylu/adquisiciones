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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "COTIZACION")
public class Cotizacion{

    @Basic(optional = false)
    @Column(name = "ID_REQUISICION")
    private int idRequisicion;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cotizacion_generator")
    @SequenceGenerator(name = "cotizacion_generator", sequenceName = "ADQUISICIONES.SEQ_COTIZACION", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_COTIZACION")
    private Integer idCotizacion;
    @Basic(optional = false)
    @Column(name = "FECHA_RECEPCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    @Column(name = "ESTATUS")
    private Short estatus;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor proveedor;
    @JoinColumn(name = "ID_REQUISICION", referencedColumnName = "ID_REQUISICION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requisicion requisicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cotizacion")
    private List<DetalleCotizacion> detalleCotizaciones;

    public int getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(int idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public Integer getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Short getEstatus() {
        return estatus;
    }

    public void setEstatus(Short estatus) {
        this.estatus = estatus;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Requisicion getRequisicion() {
        return requisicion;
    }

    public void setRequisicion(Requisicion requisicion) {
        this.requisicion = requisicion;
    }

    public List<DetalleCotizacion> getDetalleCotizaciones() {
        return detalleCotizaciones;
    }

    public void setDetalleCotizaciones(List<DetalleCotizacion> detalleCotizaciones) {
        this.detalleCotizaciones = detalleCotizaciones;
    }

    
}
