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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "TIPO_PRODUCTO")
public class TipoProducto{

    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PRODUCTO")
    private Integer idTipoProducto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ESTATUS")
    private Integer estatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProducto")
    private List<SubTipoProducto> subTipoProductos;

    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
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

    public List<SubTipoProducto> getSubTipoProductos() {
        return subTipoProductos;
    }

    public void setSubTipoProductos(List<SubTipoProducto> subTipoProductos) {
        this.subTipoProductos = subTipoProductos;
    }

    public List<SubTipoProducto> getSubtipoProductos() {
        return subTipoProductos;
    }

    public void setSubtipoProductos(List<SubTipoProducto> subTipoProductos) {
        this.subTipoProductos = subTipoProductos;
    }
}
