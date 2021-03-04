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
    @Column(name = "ID_UNIDAD_MEDIDA")
    private Integer idUnidadMedida;
    @Column(name = "CLAVE_UNIDAD")
    private String claveUnidad;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadMedida")
    private List<DetalleRequisicion> detalleRequisiciones;

    public Integer getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Integer idUnidadMedida) {
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

    public List<DetalleRequisicion> getDetalleRequisiciones() {
        return detalleRequisiciones;
    }

    public void setDetalleRequisiciones(List<DetalleRequisicion> detalleRequisiciones) {
        this.detalleRequisiciones = detalleRequisiciones;
    }

    public UnidadMedida() {
    }

}
