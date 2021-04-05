/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.cotizaConsolidacion.persistence;

import com.modules.sirsr.consolidacion.persistence.Consolidacion;
import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.detalleCotizaConsolida.persistence.DetalleCotizaConsolida;
import com.modules.sirsr.proveedor.persistence.Proveedor;

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
@Table(name = "COTIZA_CONSOLIDACION")
public class CotizaConsolidacion {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_COTIZA_CONSOLIDACION")
    private Integer idCotizaConsolidacion;
    @Basic(optional = false)
    @Column(name = "FECHA_RECEPCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cotizaConsolidacion")
    private List<DetalleCotizaConsolida> detallesCotizaConsolida;
    @JoinColumn(name = "ID_CONSOLIDACION", referencedColumnName = "ID_CONSOLIDACION")
    @ManyToOne(optional = false)
    private Consolidacion consolidacion;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor proveedor;

    public Integer getIdCotizaConsolidacion() {
        return idCotizaConsolidacion;
    }

    public void setIdCotizaConsolidacion(Integer idCotizaConsolidacion) {
        this.idCotizaConsolidacion = idCotizaConsolidacion;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public List<DetalleCotizaConsolida> getDetallesCotizaConsolida() {
        return detallesCotizaConsolida;
    }

    public void setDetallesCotizaConsolida(List<DetalleCotizaConsolida> detallesCotizaConsolida) {
        this.detallesCotizaConsolida = detallesCotizaConsolida;
    }

    public Consolidacion getConsolidacion() {
        return consolidacion;
    }

    public void setConsolidacion(Consolidacion consolidacion) {
        this.consolidacion = consolidacion;
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

    
}
