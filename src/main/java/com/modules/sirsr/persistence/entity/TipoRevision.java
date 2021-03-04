/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "TIPO_REVISION")
@NamedQueries({
    @NamedQuery(name = "TipoRevision.findAll", query = "SELECT t FROM TipoRevision t")})
public class TipoRevision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_REVISION")
    private Short idTipoRevision;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoRevision")
    private Collection<Revision> revisionCollection;

    public TipoRevision() {
    }

    public TipoRevision(Short idTipoRevision) {
        this.idTipoRevision = idTipoRevision;
    }

    public TipoRevision(Short idTipoRevision, String descripcion) {
        this.idTipoRevision = idTipoRevision;
        this.descripcion = descripcion;
    }

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

    public Collection<Revision> getRevisionCollection() {
        return revisionCollection;
    }

    public void setRevisionCollection(Collection<Revision> revisionCollection) {
        this.revisionCollection = revisionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRevision != null ? idTipoRevision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRevision)) {
            return false;
        }
        TipoRevision other = (TipoRevision) object;
        if ((this.idTipoRevision == null && other.idTipoRevision != null) || (this.idTipoRevision != null && !this.idTipoRevision.equals(other.idTipoRevision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modules.sirsr.persistence.entity.TipoRevision[ idTipoRevision=" + idTipoRevision + " ]";
    }
    
}
