/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.util.List;
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
    @Column(name = "CANTIDAD_SOLICITADA")
    private Integer cantidadSolicitada;
    @Column(name = "CARACTERISTICAS")
    private String caracteristicas;
    @Column(name = "DIGITO")
    private String digito;
    @Column(name = "CANTIDAD_AUTORIZADA")
    private Integer cantidadAutorizada;
    
    @JoinColumn(name = "ID_VOLANTE", referencedColumnName = "ID_VOLANTE")
    @ManyToOne(optional = false)
    private Volante volante;
    
    @JoinColumn(name = "ID_UNIDAD_MEDIDA", referencedColumnName = "ID_UNIDAD_MEDIDA")
    @ManyToOne(optional = false)
    private UnidadMedida unidadMedida;
    
    @JoinColumn(name = "ID_SUBTIPO_PRODUCTO", referencedColumnName = "ID_SUBTIPO_PRODUCTO")
    @ManyToOne(optional = false)
    private SubTipoProducto subtipoProducto;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleRequisicion")
    private List<DetalleCotizacion> detalleCotizaciones;

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

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public Integer getCantidadAutorizada() {
        return cantidadAutorizada;
    }

    public void setCantidadAutorizada(Integer cantidadAutorizada) {
        this.cantidadAutorizada = cantidadAutorizada;
    }

    public Volante getVolante() {
        return volante;
    }

    public void setVolante(Volante volante) {
        this.volante = volante;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public SubTipoProducto getSubtipoProducto() {
        return subtipoProducto;
    }

    public void setSubtipoProducto(SubTipoProducto subtipoProducto) {
        this.subtipoProducto = subtipoProducto;
    }

    public List<DetalleCotizacion> getDetalleCotizaciones() {
        return detalleCotizaciones;
    }

    public void setDetalleCotizaciones(List<DetalleCotizacion> detalleCotizaciones) {
        this.detalleCotizaciones = detalleCotizaciones;
    }
    
    
    
}
