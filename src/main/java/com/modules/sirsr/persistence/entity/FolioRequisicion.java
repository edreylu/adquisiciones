/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "FOLIO_REQUISICION")
@NamedQueries({
    @NamedQuery(name = "FolioRequisicion.findAll", query = "SELECT f FROM FolioRequisicion f")})
public class FolioRequisicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ANIO")
    private Short anio;
    @Basic(optional = false)
    @Column(name = "CONSECUTIVO")
    private short consecutivo;

    public FolioRequisicion() {
    }

    public FolioRequisicion(Short anio) {
        this.anio = anio;
    }

    public FolioRequisicion(Short anio, short consecutivo) {
        this.anio = anio;
        this.consecutivo = consecutivo;
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
        this.anio = anio;
    }

    public short getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(short consecutivo) {
        this.consecutivo = consecutivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anio != null ? anio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FolioRequisicion)) {
            return false;
        }
        FolioRequisicion other = (FolioRequisicion) object;
        if ((this.anio == null && other.anio != null) || (this.anio != null && !this.anio.equals(other.anio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modules.sirsr.persistence.entity.FolioRequisicion[ anio=" + anio + " ]";
    }
    
}
