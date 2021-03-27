/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.detalleCotizaRequis.domain;

import com.modules.sirsr.cotizaRequisicion.domain.CotizaRequisicion;
import com.modules.sirsr.requisicion.domain.DetalleRequisicion;
import com.modules.sirsr.marca.domain.Marca;

import java.math.BigDecimal;
import javax.persistence.Basic;
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
@Table(name = "DETALLE_COTIZA_REQUIS")
public class DetalleCotizaRequis {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detallecotizacion_generator")
    @SequenceGenerator(name = "detallecotizacion_generator", sequenceName = "SEQ_DETALLE_COTIZACION", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_COTIZA_REQUIS")
    private Integer idDetalleCotizaRequis;
    @Column(name = "PRECIO_UNITARIO")
    private BigDecimal precioUnitario;
    @Column(name = "CANTIDAD_COTIZADA")
    private Integer cantidadCotizada;
    @JoinColumn(name = "ID_COTIZA_REQUISICION", referencedColumnName = "ID_COTIZA_REQUISICION")
    @ManyToOne(optional = false)
    private CotizaRequisicion cotizaRequisicion;
    @JoinColumn(name = "ID_DETALLE_REQUISICION", referencedColumnName = "ID_DETALLE_REQUISICION")
    @OneToOne(optional = false)
    private DetalleRequisicion detalleRequisicion;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID_MARCA")
    @ManyToOne
    private Marca marca;

    public Integer getIdDetalleCotizaRequis() {
        return idDetalleCotizaRequis;
    }

    public void setIdDetalleCotizaRequis(Integer idDetalleCotizaRequis) {
        this.idDetalleCotizaRequis = idDetalleCotizaRequis;
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

    public CotizaRequisicion getCotizaRequisicion() {
        return cotizaRequisicion;
    }

    public void setCotizaRequisicion(CotizaRequisicion cotizaRequisicion) {
        this.cotizaRequisicion = cotizaRequisicion;
    }

    public DetalleRequisicion getDetalleRequisicion() {
        return detalleRequisicion;
    }

    public void setDetalleRequisicion(DetalleRequisicion detalleRequisicion) {
        this.detalleRequisicion = detalleRequisicion;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    
}
