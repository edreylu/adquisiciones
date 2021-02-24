/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.persistence.entity;

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

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "DETALLE_REQUISICION")
public class DetalleRequisicion{

    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_REQUISICION")
    private Integer idDetalleRequisicion;
    @Basic(optional = false)
    @Column(name = "ORDEN")
    private short orden;
    @Column(name = "CANTIDAD")
    private Short cantidad;
    @Basic(optional = false)
    @Column(name = "CARACTERISTICAS")
    private String caracteristicas;
    @Basic(optional = false)
    @Column(name = "CLAVE_ESPECIFICA")
    private short claveEspecifica;
    @Column(name = "DIGITO")
    private String digito;
    @JoinColumn(name = "ID_REQUISICION", referencedColumnName = "ID_REQUISICION")
    @ManyToOne(optional = false)
    private Requisicion idRequisicion;
    @JoinColumn(name = "ID_UNIDAD_MEDIDA", referencedColumnName = "ID_UNIDAD_MEDIDA")
    @ManyToOne(optional = false)
    private UnidadMedida idUnidadMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDetalleRequisicion")
    private List<DetalleCotizacion> detalleCotizacionList;

    
    public Integer getIdDetalleRequisicion() {
        return idDetalleRequisicion;
    }

    public void setIdDetalleRequisicion(Integer idDetalleRequisicion) {
        this.idDetalleRequisicion = idDetalleRequisicion;
    }

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public short getClaveEspecifica() {
        return claveEspecifica;
    }

    public void setClaveEspecifica(short claveEspecifica) {
        this.claveEspecifica = claveEspecifica;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public Requisicion getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(Requisicion idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public UnidadMedida getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(UnidadMedida idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public List<DetalleCotizacion> getDetalleCotizacionList() {
        return detalleCotizacionList;
    }

    public void setDetalleCotizacionList(List<DetalleCotizacion> detalleCotizacionList) {
        this.detalleCotizacionList = detalleCotizacionList;
    }

    
}
