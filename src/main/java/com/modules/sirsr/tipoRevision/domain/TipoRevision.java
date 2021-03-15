/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.tipoRevision.domain;

import com.modules.sirsr.revision.domain.Revision;

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
@Table(name = "TIPO_REVISION")
public class TipoRevision {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_REVISION")
    private Short idTipoRevision;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoRevision")
    private List<Revision> revisiones;

    public Short getIdTipoRevision() {
        return idTipoRevision;
    }

    public void setIdTipoRevision(Short idTipoRevision) {
        this.idTipoRevision = idTipoRevision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

}
