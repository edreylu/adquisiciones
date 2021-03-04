/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "SUBTIPO_PRODUCTO")
public class SubTipoProducto {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_SUBTIPO_PRODUCTO")
    private Integer idSubtipoProducto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ESTATUS")
    private Integer estatus;
    @JoinColumn(name = "OBJETO_GASTO", referencedColumnName = "OBJETO_GASTO")
    @ManyToOne(optional = false)
    private ObjetoDeGasto objetoDeGasto;
    @JoinColumn(name = "ID_TIPO_PRODUCTO", referencedColumnName = "ID_TIPO_PRODUCTO")
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subtipoProducto")
    private List<DetalleRequisicion> detalleRequisiciones;

    public Integer getIdSubtipoProducto() {
        return idSubtipoProducto;
    }

    public void setIdSubtipoProducto(Integer idSubtipoProducto) {
        this.idSubtipoProducto = idSubtipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public ObjetoDeGasto getObjetoDeGasto() {
        return objetoDeGasto;
    }

    public void setObjetoDeGasto(ObjetoDeGasto objetoDeGasto) {
        this.objetoDeGasto = objetoDeGasto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public List<DetalleRequisicion> getDetalleRequisiciones() {
        return detalleRequisiciones;
    }

    public void setDetalleRequisiciones(List<DetalleRequisicion> detalleRequisiciones) {
        this.detalleRequisiciones = detalleRequisiciones;
    }
}
