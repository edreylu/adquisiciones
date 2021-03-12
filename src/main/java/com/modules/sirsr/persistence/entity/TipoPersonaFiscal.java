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
@Table(name = "TIPO_PERSONA_FISCAL")
public class TipoPersonaFiscal {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PERSONA_FISCAL")
    private Integer idTipoPersonaFiscal;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPersonaFiscal")
    private List<Proveedor> proveedores;

    public Integer getIdTipoPersonaFiscal() {
        return idTipoPersonaFiscal;
    }

    public void setIdTipoPersonaFiscal(Integer idTipoPersonaFiscal) {
        this.idTipoPersonaFiscal = idTipoPersonaFiscal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    
}
