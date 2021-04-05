/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.detalleCotizaConsolida.persistence;

import com.modules.sirsr.cotizaConsolidacion.persistence.CotizaConsolidacion;
import com.modules.sirsr.marca.persistence.Marca;
import com.modules.sirsr.detalleConsolidacion.persistence.DetalleConsolidacion;

import java.math.BigDecimal;
import javax.persistence.Basic;
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
@Table(name = "DETALLE_COTIZA_CONSOLIDA")
public class DetalleCotizaConsolida {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_COTIZA_CONS")
    private Integer idDetalleCotizaCons;
    @Column(name = "PRECIO_UNITARIO")
    private BigDecimal precioUnitario;
    @Column(name = "CANTIDAD_COTIZADA")
    private Integer cantidadCotizada;
    @JoinColumn(name = "ID_COTIZA_CONSOLIDACION", referencedColumnName = "ID_COTIZA_CONSOLIDACION")
    @ManyToOne(optional = false)
    private CotizaConsolidacion cotizaConsolidacion;
    @JoinColumn(name = "ID_DETALLE_CONSOLIDACION", referencedColumnName = "ID_DETALLE_CONSOLIDACION")
    @OneToOne(optional = false)
    private DetalleConsolidacion detalleConsolidacion;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID_MARCA")
    @ManyToOne
    private Marca marca;

    public Integer getIdDetalleCotizaCons() {
        return idDetalleCotizaCons;
    }

    public void setIdDetalleCotizaCons(Integer idDetalleCotizaCons) {
        this.idDetalleCotizaCons = idDetalleCotizaCons;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidadCotizada() {
        return cantidadCotizada;
    }

    public void setCantidadCotizada(Integer cantidadCotizada) {
        this.cantidadCotizada = cantidadCotizada;
    }

    public CotizaConsolidacion getCotizaConsolidacion() {
        return cotizaConsolidacion;
    }

    public void setCotizaConsolidacion(CotizaConsolidacion cotizaConsolidacion) {
        this.cotizaConsolidacion = cotizaConsolidacion;
    }

    public DetalleConsolidacion getDetalleConsolidacion() {
        return detalleConsolidacion;
    }

    public void setDetalleConsolidacion(DetalleConsolidacion detalleConsolidacion) {
        this.detalleConsolidacion = detalleConsolidacion;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    
    
}
