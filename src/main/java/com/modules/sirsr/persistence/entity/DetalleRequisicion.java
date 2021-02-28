/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

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
    @Column(name = "CANTIDAD_AUTORIZADA")
    @Basic(optional = true)
    private Integer cantidadAutorizada;
    @Column(name = "CARACTERISTICAS")
    private String caracteristicas;
    
    @JoinColumn(name = "ID_REQUISICION", referencedColumnName = "ID_REQUISICION")
    @ManyToOne(optional = false)
    private Requisicion requisicion;
    
    @JoinColumn(name = "ID_UNIDAD_MEDIDA", referencedColumnName = "ID_UNIDAD_MEDIDA")
    @ManyToOne(optional = false)
    private UnidadMedida unidadMedida;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleRequisicion")
    private List<DetalleCotizacion> detalleCotizacionList;

    
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

    public Integer getCantidadAutorizada() {
        return cantidadAutorizada;
    }

    public void setCantidadAutorizada(Integer cantidadAutorizada) {
        this.cantidadAutorizada = cantidadAutorizada;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Requisicion getRequisicion() {
        return requisicion;
    }

    public void setRequisicion(Requisicion requisicion) {
        this.requisicion = requisicion;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public List<DetalleCotizacion> getDetalleCotizacionList() {
        return detalleCotizacionList;
    }

    public void setDetalleCotizacionList(List<DetalleCotizacion> detalleCotizacionList) {
        this.detalleCotizacionList = detalleCotizacionList;
    }

    
}
