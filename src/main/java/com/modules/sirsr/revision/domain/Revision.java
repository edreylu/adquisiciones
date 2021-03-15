/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.revision.domain;

import com.modules.sirsr.tipoRevision.domain.TipoRevision;
import com.modules.sirsr.solicitud.domain.Solicitud;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "REVISION")
public class Revision {

    @EmbeddedId
    protected RevisionPK revisionPK;
    @Basic(optional = false)
    @Column(name = "OBSERVACION")
    private String observacion;
    @JoinColumn(name = "ID_TIPO_REVISION", referencedColumnName = "ID_TIPO_REVISION")
    @ManyToOne(optional = false)
    private TipoRevision tipoRevision;
    @JoinColumn(name = "ID_SOLICITUD", referencedColumnName = "ID_SOLICITUD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Solicitud solicitud;

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

    public TipoRevision getTipoRevision() {
        return tipoRevision;
    }

    public void setTipoRevision(TipoRevision tipoRevision) {
        this.tipoRevision = tipoRevision;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    
}
