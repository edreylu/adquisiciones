/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "MARCA")
public class Marca {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_MARCA")
    private Integer idMarca;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;
    @OneToMany(mappedBy = "marca")
    private List<DetalleCotizaConsolida> detallesCotizaConsolida;
    @OneToMany(mappedBy = "marca")
    private List<DetalleRequisicion> detallesRequisicion;
    @OneToMany(mappedBy = "marca")
    private List<DetalleCotizaRequis> detallesCotizaRequis;

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public List<DetalleCotizaConsolida> getDetallesCotizaConsolida() {
        return detallesCotizaConsolida;
    }

    public void setDetallesCotizaConsolida(List<DetalleCotizaConsolida> detallesCotizaConsolida) {
        this.detallesCotizaConsolida = detallesCotizaConsolida;
    }

    public List<DetalleRequisicion> getDetallesRequisicion() {
        return detallesRequisicion;
    }

    public void setDetallesRequisicion(List<DetalleRequisicion> detallesRequisicion) {
        this.detallesRequisicion = detallesRequisicion;
    }

    public List<DetalleCotizaRequis> getDetallesCotizaRequis() {
        return detallesCotizaRequis;
    }

    public void setDetallesCotizaRequis(List<DetalleCotizaRequis> detallesCotizaRequis) {
        this.detallesCotizaRequis = detallesCotizaRequis;
    }

    
}
