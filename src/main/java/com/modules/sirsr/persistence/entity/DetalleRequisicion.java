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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "DETALLE_REQUISICION")
public class DetalleRequisicion{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detallerequisicion_generator")
    @SequenceGenerator(name = "detallerequisicion_generator", sequenceName = "ADQUISICIONES.SEQ_DETALLE_REQUISICION", allocationSize = 1)
    @Column(name = "ID_DETALLE_REQUISICION")
    private Integer idDetalleRequisicion;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_SOLICITADA")
    private Integer cantidadSolicitada;
    @Column(name = "PRECIO_UNITARIO")
    private BigDecimal precioUnitario;
    @Column(name = "CANTIDAD_AUTORIZADA")
    private Integer cantidadAutorizada;
    
    @JoinColumn(name = "ID_REQUISICION", referencedColumnName = "ID_REQUISICION")
    @ManyToOne(optional = false)
    private Requisicion requisicion;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID_MARCA")
    @ManyToOne
    private Marca marca;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto producto;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "detalleRequisicion")
    private DetalleCotizaRequis detalleCotizaRequis;

    public Integer getIdDetalleRequisicion() {
        return idDetalleRequisicion;
    }

    public void setIdDetalleRequisicion(Integer idDetalleRequisicion) {
        this.idDetalleRequisicion = idDetalleRequisicion;
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

    public Requisicion getRequisicion() {
        return requisicion;
    }

    public void setRequisicion(Requisicion requisicion) {
        this.requisicion = requisicion;
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

    public DetalleCotizaRequis getDetalleCotizaRequis() {
        return detalleCotizaRequis;
    }

    public void setDetalleCotizaRequis(DetalleCotizaRequis detalleCotizaRequis) {
        this.detalleCotizaRequis = detalleCotizaRequis;
    }
    
    
    
}
