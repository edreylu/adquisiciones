/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "DETALLE_COTIZACION")
public class DetalleCotizacion{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detallecotizacion_generator")
    @SequenceGenerator(name = "detallecotizacion_generator", sequenceName = "ADQUISICIONES.SEQ_DETALLE_COTIZACION", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_COTIZACION")
    private Integer idDetalleCotizacion;
    @Column(name = "PRECIO_UNITARIO")
    private BigDecimal precioUnitario;
    @Column(name = "PRECIO_TOTAL")
    private BigDecimal precioTotal;
    @Column(name = "CANTIDAD_COTIZADA")
    private Integer cantidadCotizada;
    @Column(name = "MARCA")
    private String marca;
    @JoinColumn(name = "ID_COTIZACION", referencedColumnName = "ID_COTIZACION")
    @ManyToOne(optional = false)
    private Cotizacion cotizacion;
    @JoinColumn(name = "ID_DETALLE_REQUISICION", referencedColumnName = "ID_DETALLE_REQUISICION")
    @ManyToOne(optional = false)
    private DetalleRequisicion detalleRequisicion;

    public Integer getIdDetalleCotizacion() {
        return idDetalleCotizacion;
    }

    public void setIdDetalleCotizacion(Integer idDetalleCotizacion) {
        this.idDetalleCotizacion = idDetalleCotizacion;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public DetalleRequisicion getDetalleRequisicion() {
        return detalleRequisicion;
    }

    public void setDetalleRequisicion(DetalleRequisicion detalleRequisicion) {
        this.detalleRequisicion = detalleRequisicion;
    }

    public DetalleCotizacion() {
    }

    public Integer getCantidadCotizada() {
        return cantidadCotizada;
    }

    public void setCantidadCotizada(Integer cantidadCotizada) {
        this.cantidadCotizada = cantidadCotizada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    
}
