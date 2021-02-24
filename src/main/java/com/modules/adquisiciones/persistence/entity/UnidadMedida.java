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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "UNIDAD_MEDIDA")
public class UnidadMedida{

    @Id
    @Basic(optional = false)
    @Column(name = "ID_UNIDAD_MEDIDA")
    private Short idUnidadMedida;
    @Column(name = "CLAVE_UNIDAD")
    private String claveUnidad;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadMedida")
    private List<DetalleRequisicion> detalleRequisicionList;

    public Short getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Short idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getClaveUnidad() {
        return claveUnidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<DetalleRequisicion> getDetalleRequisicionList() {
        return detalleRequisicionList;
    }

    public void setDetalleRequisicionList(List<DetalleRequisicion> detalleRequisicionList) {
        this.detalleRequisicionList = detalleRequisicionList;
    }

}
