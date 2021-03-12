/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "DETALLE_CONSOLIDACION")
public class DetalleConsolidacion {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_CONSOLIDACION")
    private Integer idDetalleConsolidacion;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_SOLICITADA")
    private Integer cantidadSolicitada;
    @Column(name = "PRECIO_UNITARIO")
    private BigDecimal precioUnitario;
    @Column(name = "CANTIDAD_AUTORIZADA")
    private Integer cantidadAutorizada;
    @JoinColumn(name = "ID_CONSOLIDACION", referencedColumnName = "ID_CONSOLIDACION")
    @ManyToOne(optional = false)
    private Consolidacion consolidacion;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID_MARCA")
    @ManyToOne
    private Marca marca;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto producto;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "detalleConsolidacion")
    private DetalleCotizaConsolida detalleCotizaConsolida;

    public Integer getIdDetalleConsolidacion() {
        return idDetalleConsolidacion;
    }

    public void setIdDetalleConsolidacion(Integer idDetalleConsolidacion) {
        this.idDetalleConsolidacion = idDetalleConsolidacion;
    }

    public Integer getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(Integer cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidadAutorizada() {
        return cantidadAutorizada;
    }

    public void setCantidadAutorizada(Integer cantidadAutorizada) {
        this.cantidadAutorizada = cantidadAutorizada;
    }

    public Consolidacion getConsolidacion() {
        return consolidacion;
    }

    public void setConsolidacion(Consolidacion consolidacion) {
        this.consolidacion = consolidacion;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public DetalleCotizaConsolida getDetalleCotizaConsolida() {
        return detalleCotizaConsolida;
    }

    public void setDetalleCotizaConsolida(DetalleCotizaConsolida detalleCotizaConsolida) {
        this.detalleCotizaConsolida = detalleCotizaConsolida;
    }

    
    
}
