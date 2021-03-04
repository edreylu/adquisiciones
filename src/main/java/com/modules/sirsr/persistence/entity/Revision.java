/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "REVISION")
@NamedQueries({
    @NamedQuery(name = "Revision.findAll", query = "SELECT r FROM Revision r")})
public class Revision implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RevisionPK revisionPK;
    @Basic(optional = false)
    @Column(name = "OBSERVACION")
    private String observacion;
    @JoinColumn(name = "ID_TIPO_REVISION", referencedColumnName = "ID_TIPO_REVISION")
    @ManyToOne(optional = false)
    private TipoRevision idTipoRevision;

    public Revision() {
    }

    public Revision(RevisionPK revisionPK) {
        this.revisionPK = revisionPK;
    }

    public Revision(RevisionPK revisionPK, String observacion) {
        this.revisionPK = revisionPK;
        this.observacion = observacion;
    }

    public Revision(Date fechaRevision, int idRequisicion) {
        this.revisionPK = new RevisionPK(fechaRevision, idRequisicion);
    }

    public RevisionPK getRevisionPK() {
        return revisionPK;
    }

    public void setRevisionPK(RevisionPK revisionPK) {
        this.revisionPK = revisionPK;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public TipoRevision getIdTipoRevision() {
        return idTipoRevision;
    }

    public void setIdTipoRevision(TipoRevision idTipoRevision) {
        this.idTipoRevision = idTipoRevision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (revisionPK != null ? revisionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revision)) {
            return false;
        }
        Revision other = (Revision) object;
        if ((this.revisionPK == null && other.revisionPK != null) || (this.revisionPK != null && !this.revisionPK.equals(other.revisionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modules.sirsr.persistence.entity.Revision[ revisionPK=" + revisionPK + " ]";
    }
    
}
