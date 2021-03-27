/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.cotizaRequisicion.domain;

import com.modules.sirsr.estatus.domain.Estatus;
import com.modules.sirsr.detalleCotizaRequis.domain.DetalleCotizaRequis;
import com.modules.sirsr.proveedor.domain.Proveedor;
import com.modules.sirsr.requisicion.domain.Requisicion;

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
@Table(name = "COTIZA_REQUISICION")
public class CotizaRequisicion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cotizacion_generator")
    @SequenceGenerator(name = "cotizacion_generator", sequenceName = "SEQ_COTIZACION", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_COTIZA_REQUISICION")
    private Integer idCotizaRequisicion;
    @Basic(optional = false)
    @Column(name = "FECHA_RECEPCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor proveedor;
    @JoinColumn(name = "ID_REQUISICION", referencedColumnName = "ID_REQUISICION")
    @ManyToOne(optional = false)
    private Requisicion requisicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cotizaRequisicion")
    private List<DetalleCotizaRequis> detallesCotizaRequis;

    public Integer getIdCotizaRequisicion() {
        return idCotizaRequisicion;
    }

    public void setIdCotizaRequisicion(Integer idCotizaRequisicion) {
        this.idCotizaRequisicion = idCotizaRequisicion;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
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

    public List<DetalleCotizaRequis> getDetallesCotizaRequis() {
        return detallesCotizaRequis;
    }

    public void setDetallesCotizaRequis(List<DetalleCotizaRequis> detallesCotizaRequis) {
        this.detallesCotizaRequis = detallesCotizaRequis;
    }

    
}
