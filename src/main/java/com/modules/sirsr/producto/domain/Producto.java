/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.producto.domain;

import com.modules.sirsr.requisicion.domain.DetalleRequisicion;
import com.modules.sirsr.estatus.domain.Estatus;
import com.modules.sirsr.detalleConsolidacion.domain.DetalleConsolidacion;
import com.modules.sirsr.subTipoProducto.domain.SubTipoProducto;
import com.modules.sirsr.tipoProducto.domain.TipoProducto;
import com.modules.sirsr.unidadMedida.domain.UnidadMedida;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "PRODUCTO")
public class Producto {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;
    @Basic(optional = false)
    @Column(name = "CARACTERISTICAS")
    private String caracteristicas;
    @Column(name = "PRECIO_DE_REFERENCIA")
    private BigDecimal precioDeReferencia;
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Basic(optional = false)
    @Column(name = "PERMISO_UR")
    private Integer permisoUr;
    @Column(name = "ID_TIPO_PRODUCTO", insertable = false, updatable = false)
    private Integer idTipoProducto;
    @JoinColumn(name = "ID_UNIDAD_MEDIDA", referencedColumnName = "ID_UNIDAD_MEDIDA")
    @ManyToOne(optional = false)
    private UnidadMedida unidadMedida;
    @JoinColumn(name = "ID_TIPO_PRODUCTO", referencedColumnName = "ID_TIPO_PRODUCTO")
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;
    @ManyToMany(mappedBy = "productos")
    private List<UnidadResponsable> unidadesResponsables;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<DetalleConsolidacion> detallesConsolidacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<DetalleRequisicion> detallesRequisicion;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public BigDecimal getPrecioDeReferencia() {
        return precioDeReferencia;
    }

    public void setPrecioDeReferencia(BigDecimal precioDeReferencia) {
        this.precioDeReferencia = precioDeReferencia;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getPermisoUr() {
        return permisoUr;
    }

    public void setPermisoUr(Integer permisoUr) {
        this.permisoUr = permisoUr;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public List<UnidadResponsable> getUnidadesResponsables() {
        return unidadesResponsables;
    }

    public void setUnidadesResponsables(List<UnidadResponsable> unidadesResponsables) {
        this.unidadesResponsables = unidadesResponsables;
    }

    public List<DetalleConsolidacion> getDetallesConsolidacion() {
        return detallesConsolidacion;
    }

    public void setDetallesConsolidacion(List<DetalleConsolidacion> detallesConsolidacion) {
        this.detallesConsolidacion = detallesConsolidacion;
    }

    public List<DetalleRequisicion> getDetallesRequisicion() {
        return detallesRequisicion;
    }

    public void setDetallesRequisicion(List<DetalleRequisicion> detallesRequisicion) {
        this.detallesRequisicion = detallesRequisicion;
    }

    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }
}
