/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.subTipoProducto.domain;

import com.modules.sirsr.estatus.domain.Estatus;
import com.modules.sirsr.objetoGasto.domain.ObjetoDeGasto;
import com.modules.sirsr.tipoProducto.domain.TipoProducto;
import com.modules.sirsr.producto.domain.Producto;

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
@Table(name = "SUBTIPO_PRODUCTO")
public class SubTipoProducto {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_SUBTIPO_PRODUCTO")
    private Integer idSubtipoProducto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "OBJETO_GASTO", referencedColumnName = "OBJETO_GASTO")
    @ManyToOne(optional = false)
    private ObjetoDeGasto objetoDeGasto;
    @JoinColumn(name = "ID_TIPO_PRODUCTO", referencedColumnName = "ID_TIPO_PRODUCTO")
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subtipoProducto")
    private List<Producto> productos;

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

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    
}
